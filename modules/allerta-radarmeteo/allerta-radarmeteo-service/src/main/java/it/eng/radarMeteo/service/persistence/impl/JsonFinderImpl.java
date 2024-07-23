package it.eng.radarMeteo.service.persistence.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.radarMeteo.service.persistence.JsonFinder;

public class JsonFinderImpl extends JsonFinderBaseImpl implements JsonFinder{
	public static final Log _log = LogFactoryUtil.getLog(JsonFinderImpl.class);
	
	private String FIND_RecentValueByVar = JsonFinderImpl.class.getName()
			+ ".findRecentValueByVar";
	private String FIND_ValuesByVarDate = JsonFinderImpl.class.getName()
			+ ".findValuesByVarDate";
	private String FIND_ValuesByElenco = JsonFinderImpl.class.getName()
			+ ".findValuesByElenco";
	private String FIND_LastThreeDays = JsonFinderImpl.class.getName()
			+ ".findLastThreeDays";
	private String GET_InfoSensore = JsonFinderImpl.class.getName()
			+ ".getInfoSensore";
	private String GET_AllStations = JsonFinderImpl.class.getName()
			+ ".getAllStations";
	
	public List<Object[]> findRecentValuesByVar(String variabile) {
//		System.out.println("Entered");
		Session session = openSession();

		String sql = customSQL.get(this.getClass(), FIND_RecentValueByVar);
		SQLQuery query = session.createSQLQuery(sql);
		query.setCacheable(true);
		query.addScalar("idstazione", Type.STRING);
		query.addScalar("value", Type.DOUBLE);
		query.addScalar("lat", Type.LONG);
		query.addScalar("lon", Type.LONG);

		QueryPos qPos = QueryPos.getInstance(query);
		qPos.add(variabile);

//		System.out.println("Entered! Variable is - "+variabile);
		List<Object[]> list = (List<Object[]>)QueryUtil.list(query, getDialect(), -1, -1);
//		System.out.println(list.size());

		closeSession(session);
		return list;
	}
	public List<Object[]> findValuesByVarDate(String variabile, Long date) {
		//		long start = System.currentTimeMillis();
		Session session = null;
		
		try{
			
			if (TimeZone.getDefault().getRawOffset()>0) {
				date -= TimeZone.getDefault().getRawOffset();
				//if (TimeZone.getDefault().inDaylightTime(new Date())) date -= 3600000;
			}
			
			session = openSession();
			/*
			String sql ="SELECT  staz.id_, coalesce(vs.value, 0) as value, staz.lat, staz.lon, staz.name, stazvar.soglia1, stazvar.soglia2, stazvar.soglia3, staz.progressivo " + 
						"FROM bollettino_stazionevariabile stazvar INNER JOIN bollettino_stazione staz ON stazvar.idstazione = staz.id_ " +
						"left join bollettino_valoresensore vs on vs.idstazione = staz.id_ and vs.datetime = ? and vs.idvariabile = ? " +
						"WHERE stazvar.idvariabile = ? AND attivo = 't' AND stazvar.dataultimovalore >= (CURRENT_DATE - 4);";
						*/ 
			String sql = customSQL.get(this.getClass(),FIND_ValuesByVarDate);
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(true);
			query.addScalar("id_", Type.STRING);
			query.addScalar("value", Type.DOUBLE);
			query.addScalar("lat", Type.LONG);
			query.addScalar("lon", Type.LONG);
			query.addScalar("name", Type.STRING);
			//servono per i livelli idro ma li inserisco per tutti perche' cmq non va in errore essendo presenti e impostati a 0
			query.addScalar("progressivo", Type.INTEGER);
			query.addScalar("soglia1", Type.DOUBLE);
			query.addScalar("soglia2", Type.DOUBLE);
			query.addScalar("soglia3", Type.DOUBLE);
			

			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(new Timestamp(date));
			qPos.add(variabile);
			qPos.add(variabile);
			return (List<Object[]>)QueryUtil.list(query, getDialect(), -1, -1);
		}
		catch(Exception e){
			try{
				throw new SystemException(e);
			}
			catch(SystemException se){
				se.printStackTrace();
			}
		}
		finally{
			closeSession(session);
		}
		return null;
	}
	public List<Object[]> findValuesByElenco(String variabile, Long date) {
		//		long start = System.currentTimeMillis();
		Session session = null;
		try{
			
			if (TimeZone.getDefault().getRawOffset()>0) {
				date -= TimeZone.getDefault().getRawOffset();
				//if (TimeZone.getDefault().inDaylightTime(new Date())) date -= 3600000;
			}
			
			session = openSession();
			String sql = customSQL.get(this.getClass(), FIND_ValuesByElenco);
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(true);

			query.addScalar("id_", Type.STRING);
			query.addScalar("value", Type.DOUBLE);
			query.addScalar("lat", Type.LONG);
			query.addScalar("lon", Type.LONG);
			query.addScalar("name", Type.STRING);
			query.addScalar("progressivo", Type.INTEGER);
			query.addScalar("idvariabile",Type.STRING);
			query.addScalar("valueplus", Type.DOUBLE);

			QueryPos qPos = QueryPos.getInstance(query);

			//		Date verifyH = new Date(date);
			//		verifyH.
			Date verifyH = new Date(date);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm");
			int minute = Integer.parseInt(simpleDateFormat.format(verifyH));
//			System.out.println(verifyH+"  "+minute);
			String[] variabileS;
			variabileS = variabile.split("/");
			if(minute==30)
				variabile = "1,0,1800/"+variabileS[1]+"/"+variabileS[2];
			if (minute==15 || minute==45)
				variabile = "1,0,900/"+variabileS[1]+"/"+variabileS[2];
//			System.out.println(variabile);
			qPos.add(variabile);
			qPos.add(new Timestamp(date));
			return (List<Object[]>)QueryUtil.list(query, getDialect(), -1, -1);
		}
		catch(Exception e){
			try{
				throw new SystemException(e);
			}
			catch(SystemException se){
				se.printStackTrace();
			}
		}
		finally{
			closeSession(session);
		}
		return null;
	}
	public List<Object[]> findLastTheeDays(String stazione, String variabile) {
		Session session = null;
		try{
			session = openSession();
			Calendar calendar = new GregorianCalendar();//getInstance(TimeZone.getTimeZone("UTC"));
			calendar.setTime(new Date());
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			calendar.add(Calendar.DAY_OF_MONTH,1);
			calendar.add(Calendar.HOUR_OF_DAY,-2);
		
			//		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"));

			//	       For test purpose only
			//		calendar.set(2016,6,20);
//			_log.info(calendar.get(Calendar.DAY_OF_MONTH)+" "+calendar.get(Calendar.MONTH)+
//					" "+calendar.get(Calendar.YEAR)+" "+calendar.get(Calendar.HOUR_OF_DAY)+
//					" "+calendar.get(Calendar.MINUTE)+" "+calendar.get(Calendar.SECOND));
			long currTime = calendar.getTimeInMillis();
			calendar.add(Calendar.DAY_OF_MONTH, -3); 
			long historyTime = calendar.getTimeInMillis();
//			_log.info(calendar.get(Calendar.DAY_OF_MONTH)+" "+calendar.get(Calendar.MONTH)+
//					" "+calendar.get(Calendar.YEAR)+" "+calendar.get(Calendar.HOUR_OF_DAY)+
//					" "+calendar.get(Calendar.MINUTE)+" "+calendar.get(Calendar.SECOND));
//			System.out.println(currTime+"   "+historyTime);
			String sql = customSQL.get(this.getClass(), FIND_LastThreeDays);

			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(true);
			query.addScalar("value", Type.DOUBLE);
			query.addScalar("datetime", Type.TIMESTAMP);

			QueryPos qPos = QueryPos.getInstance(query);

			qPos.add(stazione);
			qPos.add(variabile);
			qPos.add(new Timestamp(historyTime));
			qPos.add(new Timestamp(currTime));
			
			return (List<Object[]>)QueryUtil.list(query, getDialect(), -1, -1);

		}
		catch(Exception e){
			try{
				throw new SystemException(e);
			}
			catch(SystemException se){
				se.printStackTrace();
			}
		}
		finally{
			closeSession(session);
		}
		return null;
	}
	
	public List<Object[]> getInfoSensore(String idstazione, String variabile) {
		Session session = null;
		try{
			session = openSession();

			String sql = customSQL.get(this.getClass(), GET_InfoSensore);
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(true);
			query.addScalar("name", Type.STRING);
			query.addScalar("description_it", Type.STRING);
			query.addScalar("height", Type.DOUBLE);
			query.addScalar("namebasin", Type.STRING);
			query.addScalar("namesubbasin", Type.STRING);
			query.addScalar("soglia1", Type.DOUBLE);
			query.addScalar("soglia2", Type.DOUBLE);
			query.addScalar("soglia3", Type.DOUBLE);
			query.addScalar("unit", Type.STRING);

			QueryPos qPos = QueryPos.getInstance(query);

			qPos.add(idstazione);
			qPos.add(variabile);

			return (List<Object[]>)QueryUtil.list(query, getDialect(), -1, -1);
		}
		catch(Exception e){
			try{
				throw new SystemException(e);
			}
			catch(SystemException se){
				se.printStackTrace();
			}
		}
		finally{
			closeSession(session);
		}
		return null;

	}

	public ArrayList<Object[]> getAllStations() {
		Session session = null;
		try{
			session = openSession();

			String sql = customSQL.get(this.getClass(), GET_AllStations);

			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(true);
			query.addScalar("id_", Type.STRING);
			query.addScalar("name", Type.STRING);
			query.addScalar("namemunicipality", Type.STRING);
			query.addScalar("height", Type.DOUBLE);
			query.addScalar("lat", Type.LONG);
			query.addScalar("lon", Type.LONG);
			query.addScalar("attivo", Type.BOOLEAN);


			QueryPos qPos = QueryPos.getInstance(query);
			ArrayList<Object[]> lista = new ArrayList<Object[]>();
			lista.addAll((List<Object[]>)QueryUtil.list(query, getDialect(), -1, -1));
			return lista; 
		}
		catch(Exception e){
			try{
				throw new SystemException(e);
			}
			catch(SystemException se){
				se.printStackTrace();
			}
		}
		finally{
			closeSession(session);
		}
		return null;
	}

	@ServiceReference(type = CustomSQL.class)
	private CustomSQL customSQL;

}
