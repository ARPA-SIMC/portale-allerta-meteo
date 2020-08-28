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
import it.eng.allerte.model.RubricaGruppo;
import it.eng.allerte.service.persistence.RubricaGruppoFinder;

public class RubricaGruppoFinderImpl extends RubricaGruppoFinderBaseImpl implements RubricaGruppoFinder{
		
	public static final Log _log = LogFactoryUtil.getLog(RubricaGruppoFinderImpl.class);
		
		private String GET_GRUPPY_BY_NAME = RubricaGruppoFinderImpl.class.getName()
				+ ".getGruppiByName";
		
		private String GET_GRUPPI_BY_OWNER_AND_NAME = RubricaGruppoFinderImpl.class.getName()
				+ ".getGruppoForOwnerAndName";
	
		private String GET_ALL_GRUPPI = RubricaGruppoFinderImpl.class.getName()
				+ ".getAllGruppi";
		
		private String GET_GROUP = RubricaGruppoFinderImpl.class.getName()
				+ ".getGroup";
		
		private String AGGIORNA_TUTTO_GRUPPO = RubricaGruppoFinderImpl.class.getName()
				+ ".aggiornaTuttoGruppo";
		
		public void aggiornaTuttoGruppo(Long gruppo) {
			Session session = null;
			try{
				session = openSession();
				int start = -1;
				int end = -1;
				
				String sql = customSQL.get(this.getClass(),AGGIORNA_TUTTO_GRUPPO);
				
				SQLQuery query = session.createSQLQuery(sql);
				query.setCacheable(false);

				QueryPos qPos = QueryPos.getInstance(query);
				qPos.add(gruppo);
				
				query.executeUpdate();
				
				return; 
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
			return;
		
		}

		public ArrayList<Object[]> getGruppiByName(Long site, String groupName, Long limit, Long offset) {
			Session session = null;
			try{
				session = openSession();
				int start = -1;
				int end = -1;
				
				String sql = customSQL.get(this.getClass(), GET_GRUPPY_BY_NAME);
				
				SQLQuery query = session.createSQLQuery(sql);
				query.setCacheable(false);

				query.addScalar("ID_GRUPPO", Type.LONG);
				query.addScalar("NOME", Type.STRING);
				query.addScalar("FK_SITO_PROPRIETARIO", Type.LONG);
				query.addScalar("NOTE", Type.STRING);
				query.addScalar("FK_UTENTE_CREAZIONE", Type.LONG);
				query.addScalar("DATA_CREAZIONE", Type.DATE);
				query.addScalar("FK_UTENTE_MODIFICA", Type.LONG);
				query.addScalar("DATA_MODIFICA", Type.DATE);
				query.addScalar("DISABLED", Type.BOOLEAN);


				QueryPos qPos = QueryPos.getInstance(query);

				groupName = "%"+groupName+"%";
				qPos.add(site);
				qPos.add(groupName);
				
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
		
		
		@SuppressWarnings("unchecked")
		public Object[] getGruppiByOwnerAndName(Long idOwner, String groupName) {
			
			Session session = null;
			try{
				session = openSession();
				int start = -1;
				int end = -1;
				
				String sql = customSQL.get(this.getClass(), GET_GRUPPI_BY_OWNER_AND_NAME);
				
				SQLQuery query = session.createSQLQuery(sql);
				query.setCacheable(false);

				query.addScalar("ID_GRUPPO", Type.LONG);
				query.addScalar("NOME", Type.STRING);
				query.addScalar("FK_SITO_PROPRIETARIO", Type.LONG);
				query.addScalar("NOTE", Type.STRING);
				query.addScalar("FK_UTENTE_CREAZIONE", Type.LONG);
				query.addScalar("DATA_CREAZIONE", Type.DATE);
				query.addScalar("FK_UTENTE_MODIFICA", Type.LONG);
				query.addScalar("DATA_MODIFICA", Type.DATE);
				query.addScalar("DISABLED", Type.BOOLEAN);


				QueryPos qPos = QueryPos.getInstance(query);

				qPos.add(idOwner);
				qPos.add(groupName);
				
				
				ArrayList<Object[]> lista = new ArrayList<Object[]>();
				lista.addAll((List<Object[]>)QueryUtil.list(query, getDialect(), start, end));
			
				if(null != lista && !lista.isEmpty()) {
					return lista.get(0);
				} else {
					return null;
				}
				
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
		
		
		
		public ArrayList<Object[]> getAllGruppi(Long limit, Long offset) {
			Session session = null;
			try{
				session = openSession();
				int start = -1;
				int end = -1;
				
				String sql = customSQL.get(this.getClass(), GET_ALL_GRUPPI);
				
				SQLQuery query = session.createSQLQuery(sql);
				query.setCacheable(false);
				//Result
				query.addScalar("ID", Type.LONG);
				query.addScalar("NOME", Type.STRING);
				query.addScalar("FK_SITO_PROPRIETARIO", Type.LONG);
				query.addScalar("NOTE", Type.STRING);
				query.addScalar("FK_UTENTE_CREAZIONE", Type.LONG);
				query.addScalar("DATA_CREAZIONE", Type.DATE);
				query.addScalar("FK_UTENTE_MODIFICA", Type.LONG);
				query.addScalar("DATA_MODIFICA", Type.DATE);
				query.addScalar("DISABLED", Type.BOOLEAN);


				QueryPos qPos = QueryPos.getInstance(query);
				
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
		
		
		public ArrayList<Object[]> getGroup(Long id) {
			Session session = null;
			try{
				session = openSession();
				int start = -1;
				int end = -1;
				
				String sql = customSQL.get(this.getClass(),GET_GROUP);
				
				SQLQuery query = session.createSQLQuery(sql);
				query.setCacheable(false);

				query.addScalar("NOMEGRUPPO", Type.STRING);
				query.addScalar("COGNOME", Type.STRING);
				query.addScalar("NOME", Type.STRING);
				query.addScalar("NOMERUOLO", Type.STRING);
				query.addScalar("SPECIFICA_RUOLO", Type.STRING);
				query.addScalar("INDIRIZZO", Type.STRING);
				query.addScalar("TIPO_CONTATTO", Type.STRING);
				query.addScalar("CONTATTO", Type.STRING);
				query.addScalar("DATAGRUPPO", Type.DATE);
				query.addScalar("DATACONTATTO", Type.DATE);
				

				QueryPos qPos = QueryPos.getInstance(query);
				qPos.add(id);
				
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

	
	

