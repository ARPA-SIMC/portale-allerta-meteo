package it.eng.radarMeteo.service.persistence.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.eng.radarMeteo.service.persistence.JsonFinder;

@Component(service = JsonFinder.class)
public class JsonFinderImpl extends JsonFinderBaseImpl implements JsonFinder{
	public static final Log _log = LogFactoryUtil.getLog(JsonFinderImpl.class);
	
	/*private String FIND_RecentValueByVar = JsonFinderImpl.class.getName()
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
			+ ".getAllStations";*/
	
	private String FIND_RecentValueByVar = "select  idstazione, value, staz.lat, staz.lon\r\n"
			+ "	from\r\n"
			+ "	(\r\n"
			+ "	select idstazione, value, datetime,\r\n"
			+ "	       MAX( datetime) over (partition by idstazione) max_my_date\r\n"
			+ "	from   bollettino_valoresensore where idvariabile = ?\r\n"
			+ "	) as maxDate\r\n"
			+ "	inner join bollettino_stazione staz on staz.id_= maxDate.idstazione\r\n"
			+ "	where datetime = max_my_date";
	private String FIND_ValuesByVarDate = "SELECT  staz.id_, case when vs.value is not null then vs.value when ? > stazvar.dataultimovalore and  ? < stazvar.dataultimovalore+cast('90 minute' as interval) then vs2.value else null end as value, staz.lat, staz.lon, staz.name, \r\n"
			+ "case when ds.idstazione is null then stazvar.soglia1 else 0 end as soglia1, \r\n"
			+ "case when ds.idstazione is null then stazvar.soglia2 else 0 end as soglia2, \r\n"
			+ "case when ds.idstazione is null then stazvar.soglia3 else 0 end as soglia3, \r\n"
			+ "staz.progressivo,\r\n"
			+ "case when vs.value is null then 'S' else 'N' end as precedente\r\n"
			+ "    FROM bollettino_stazionevariabile stazvar\r\n"
			+ "    INNER JOIN bollettino_stazione staz\r\n"
			+ "    ON stazvar.idstazione = staz.id_\r\n"
			+ "    left join bollettino_valoresensore vs on vs.idstazione = staz.id_ and vs.datetime = ? and vs.idvariabile = ?\r\n"
			+ "    left join bollettino_disattivazionesensore ds on ds.idstazione=staz.id_ and right(ds.idvariabile,5)=right(stazvar.idvariabile,5)\r\n"
			+ "	left join bollettino_valoresensore vs2 on vs2.idstazione = staz.id_ and vs2.idvariabile=stazvar.idvariabile and vs2.datetime=stazvar.dataultimovalore\r\n"
			+ "	WHERE stazvar.idvariabile = ?\r\n"
			+ "    AND attivo = 't' AND stazvar.dataultimovalore >= (CURRENT_DATE - 4)\r\n"
			+ "    ORDER BY staz.progressivo DESC";
	private String FIND_ValuesByElenco = "select q.id_, q.v60 as value, q.lat, q.lon, q.name, q.progressivo, q.idvariabile,\r\n"
			+ "	case\r\n"
			+ "		when q.v60 is not null then q.v60\r\n"
			+ "		when q.v30a is not null and q.v30b is not null then q.v30a + q.v30b\r\n"
			+ "		when q.v15a is not null and q.v15b is not null and q.v15c is not null and q.v15d is not null then q.v15a+q.v15b+q.v15c+q.v15d\r\n"
			+ "		else null end valuePlus,\r\n"
			+ "		case when q.ts2<cast(? as timestamp without time zone) then 'S' else 'N' end as precedente\r\n"
			+ "		from\r\n"
			+ "	(select staz.id_,x.idvariabile,staz.lon,staz.lat,staz.name,staz.progressivo,vs.value as v60, vs2.value as v30a, vs3.value as v30b,\r\n"
			+ "	vs4.value as v15a, vs5.value as v15b, vs6.value as v15c, vs7.value as v15d, x.ts2\r\n"
			+ "	from (select *, case when v.dataultimovalore<tim.ts1 and v.dataultimovalore>tim.ts1-cast('90 minute' as interval) then v.dataultimovalore else tim.ts1 end as ts2 from view_staz_sensore_15m v, \r\n"
			+ "	  (select ? as var, cast(? as timestamp without time zone) as ts1) tim) x\r\n"
			+ "	 JOIN bollettino_stazione staz\r\n"
			+ "		ON x.idstazione=staz.id_ \r\n"
			+ "	 	LEFT JOIN bollettino_valoresensore vs on vs.idstazione=x.idstazione and \r\n"
			+ "	  vs.idvariabile='1,0,3600/1,-,-,-/B13011' and vs.datetime=x.ts2\r\n"
			+ "	  LEFT JOIN bollettino_valoresensore vs2 on x.idvariabile='1,0,1800/1,-,-,-/B13011' and vs2.idstazione=x.idstazione and \r\n"
			+ "	  vs2.idvariabile='1,0,1800/1,-,-,-/B13011' and vs2.datetime=x.ts2\r\n"
			+ "	  LEFT JOIN bollettino_valoresensore vs3 on x.idvariabile='1,0,1800/1,-,-,-/B13011' and vs3.idstazione=x.idstazione and \r\n"
			+ "	  vs3.idvariabile='1,0,1800/1,-,-,-/B13011' and vs3.datetime=x.ts2- INTERVAL '30 min'\r\n"
			+ "	  LEFT JOIN bollettino_valoresensore vs4 on x.idvariabile='1,0,900/1,-,-,-/B13011' and vs4.idstazione=x.idstazione and \r\n"
			+ "	  vs4.idvariabile='1,0,900/1,-,-,-/B13011' and vs4.datetime=x.ts2\r\n"
			+ "	  LEFT JOIN bollettino_valoresensore vs5 on x.idvariabile='1,0,900/1,-,-,-/B13011' and vs5.idstazione=x.idstazione and \r\n"
			+ "	  vs5.idvariabile='1,0,900/1,-,-,-/B13011' and vs5.datetime=x.ts2-INTERVAL '15 min'\r\n"
			+ "	  LEFT JOIN bollettino_valoresensore vs6 on x.idvariabile='1,0,900/1,-,-,-/B13011' and vs6.idstazione=x.idstazione and \r\n"
			+ "	  vs6.idvariabile='1,0,900/1,-,-,-/B13011' and vs6.datetime=x.ts2-INTERVAL '30 min'\r\n"
			+ "	  LEFT JOIN bollettino_valoresensore vs7 on x.idvariabile='1,0,900/1,-,-,-/B13011' and vs7.idstazione=x.idstazione and \r\n"
			+ "	  vs7.idvariabile='1,0,900/1,-,-,-/B13011' and vs7.datetime=x.ts2- INTERVAL '45 min') q";
	private String FIND_LastThreeDays = "select DISTINCT ON (datetime) datetime, value\r\n"
			+ "	from  bollettino_valoresensore \r\n"
			+ "	where idstazione = ? and idvariabile=? and datetime BETWEEN ? AND ?\r\n"
			+ "	ORDER BY datetime ASC";
	private String GET_InfoSensore = "select  name,description_it, height, namebasin, namesubbasin, soglia1,soglia2,soglia3, var.unit\r\n"
			+ "	from  bollettino_stazione staz\r\n"
			+ "	inner join bollettino_stazionevariabile stazvar on staz.id_= stazvar.idstazione\r\n"
			+ "	inner join bollettino_variabile var on var.id_ = stazvar.idvariabile\r\n"
			+ "	where staz.id_= ? and  stazvar.idvariabile = ?";
	private String GET_AllStations = "select id_, name, namemunicipality, height, lat, lon, attivo\r\n"
			+ "	from  bollettino_stazione where nameregion = 'EMILIA-ROMAGNA'";
	
	public List<Object[]> findRecentValuesByVar(String variabile) {
//		System.out.println("Entered");
		Session session = openSession();

		String sql = FIND_RecentValueByVar;
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
			String sql = FIND_ValuesByVarDate;
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
			query.addScalar("precedente", Type.STRING);
			

			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(new Timestamp(date));
			qPos.add(new Timestamp(date));
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
			String sql = FIND_ValuesByElenco;
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
			query.addScalar("precedente", Type.STRING);

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
			qPos.add(new Timestamp(date));
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
			String sql = FIND_LastThreeDays;

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

			String sql = GET_InfoSensore;
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

			String sql = GET_AllStations;

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


}
