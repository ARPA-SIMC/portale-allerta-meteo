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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.allerte.custom.util.RubricaUtil;
import it.eng.allerte.model.RubricaNominativo;
import it.eng.allerte.service.persistence.RubricaNominativoFinder;


public class RubricaNominativoFinderImpl extends RubricaNominativoFinderBaseImpl 
	implements RubricaNominativoFinder{
		
	public static final Log _log = LogFactoryUtil.getLog(RubricaNominativoFinderImpl.class);
		
		private String GET_NOMINATIVO_BY_NAME = RubricaNominativoFinderImpl.class.getName()
				+ ".getNominativiByName";
	

		public ArrayList<Object[]> getNominativiByName(String name, Long limit, Long offset) {
			Session session = null;
			try{
				session = openSession();
				int start = -1;
				int end = -1;
				
				String sql = customSQL.get(this.getClass(), GET_NOMINATIVO_BY_NAME);
				name = "%"+name+"%";
				
				SQLQuery query = session.createSQLQuery(sql);
				query.setCacheable(false);
				//Result
				query.addScalar("ID_NOMINATIVO", Type.LONG);
				query.addScalar("COGNOME", Type.STRING);
				query.addScalar("NOME", Type.STRING);
				query.addScalar("INDIRIZZO", Type.STRING);
				query.addScalar("FK_SITO_PROPRIETARIO", Type.LONG);
				query.addScalar("FK_UTENTE_PORTALE", Type.LONG);
				query.addScalar("FK_UTENTE_CREAZIONE", Type.LONG);
				query.addScalar("DATA_CREAZIONE", Type.TIMESTAMP);
				query.addScalar("FK_UTENTE_MODIFICA", Type.LONG);
				query.addScalar("DATA_MODIFICA", Type.TIMESTAMP);
				query.addScalar("DISABLED", Type.BOOLEAN);


				QueryPos qPos = QueryPos.getInstance(query);
				//Se mi passano il nome lo metto in ricerca, altrimenti prendo tutto
				qPos.add(name);
				qPos.add(name);
				qPos.add(name);
				
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

	
	

