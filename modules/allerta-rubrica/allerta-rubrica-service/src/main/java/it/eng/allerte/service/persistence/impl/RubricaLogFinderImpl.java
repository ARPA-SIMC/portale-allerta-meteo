package it.eng.allerte.service.persistence.impl;

import java.util.ArrayList;
import java.util.List;

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

import it.eng.allerte.custom.util.RubricaUtil;
import it.eng.allerte.service.persistence.RubricaLogFinder;

public class RubricaLogFinderImpl extends RubricaLogFinderBaseImpl implements RubricaLogFinder{
	
	public static final Log _log = LogFactoryUtil.getLog(RubricaLogFinderImpl.class);
	
	private String GET_LOG_BY_NAME_TABLE = RubricaLogFinderImpl.class.getName()
			+ ".getLogByNameTable";
	
	
	public ArrayList<Object[]> getLogByNameTable(String tableName, Long ownerId, Long limit, Long offset) {
		Session session = null;
		try{
			session = openSession();
			int start = -1;
			int end = -1;
			
			String sql = customSQL.get(this.getClass(), GET_LOG_BY_NAME_TABLE);
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			//Result
			query.addScalar("ID_LOG", Type.LONG);
			query.addScalar("FK_SITO_PROPRIETARIO", Type.LONG);
			query.addScalar("TABELLA", Type.STRING);
			query.addScalar("TIPO_OPERAZIONE", Type.STRING);
			query.addScalar("ID_OGGETTO", Type.STRING);
			query.addScalar("NUOVA_DESCRIZIONE", Type.STRING);
			query.addScalar("FK_UTENTE_MODIFICA", Type.LONG);
			query.addScalar("DATA_MODIFICA", Type.TIMESTAMP);


			QueryPos qPos = QueryPos.getInstance(query);

			//tableName = "%"+tableName+"%";
			
			qPos.add(tableName);
			qPos.add(ownerId);
			
			//Gestisco per la paginazione
			start = RubricaUtil.calcolaStart(offset.intValue(), limit.intValue());

			end = RubricaUtil.calcolaEnd(start, limit.intValue());
			
			ArrayList<Object[]> lista = new ArrayList<Object[]>();
			lista.addAll((List<Object[]>)QueryUtil.list(query, getDialect(), start, end));
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
