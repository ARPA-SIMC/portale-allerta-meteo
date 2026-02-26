package it.eng.allerte.service.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.eng.allerte.custom.util.RubricaUtil;
import it.eng.allerte.service.persistence.RubricaNominativoFinder;

@Component(service = RubricaNominativoFinder.class)
public class RubricaNominativoFinderImpl extends RubricaNominativoFinderBaseImpl 
	implements RubricaNominativoFinder{
		
	public static final Log _log = LogFactoryUtil.getLog(RubricaNominativoFinderImpl.class);
		
		/*private String GET_NOMINATIVO_BY_NAME = RubricaNominativoFinderImpl.class.getName()
				+ ".getNominativiByName";*/
	
	private String GET_NOMINATIVO_BY_NAME = "select distinct rn.ID_NOMINATIVO, rn.COGNOME, rn.NOME, rn.INDIRIZZO,rn.FK_SITO_PROPRIETARIO, rn.FK_UTENTE_PORTALE, \r\n"
			+ "		rn.FK_UTENTE_CREAZIONE, rn.DATA_CREAZIONE, rn.FK_UTENTE_MODIFICA, rn.DATA_MODIFICA, rn.DISABLED\r\n"
			+ "		from rubrica_rubricanominativo rn left join rubrica_rubricacontatto rc on rc.fk_nominativo = rn.id_nominativo\r\n"
			+ "		where (upper(rn.cognome) like upper(?)	or upper(rn.nome) like upper(?) or upper(rc.contatto) like upper(?))\r\n"
			+ "		       and not rn.disabled\r\n"
			+ "	    order by rn.cognome, rn.nome";
	

		public ArrayList<Object[]> getNominativiByName(String name, Long limit, Long offset) {
			Session session = null;
			try{
				session = openSession();
				int start = -1;
				int end = -1;
				
				String sql = GET_NOMINATIVO_BY_NAME;
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



}

	
	

