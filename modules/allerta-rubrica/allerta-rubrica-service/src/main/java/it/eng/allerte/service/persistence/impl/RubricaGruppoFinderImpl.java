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
import it.eng.allerte.model.RubricaGruppo;
import it.eng.allerte.service.persistence.RubricaGruppoFinder;

@Component(service = RubricaGruppoFinder.class)
public class RubricaGruppoFinderImpl extends RubricaGruppoFinderBaseImpl implements RubricaGruppoFinder{
		
	public static final Log _log = LogFactoryUtil.getLog(RubricaGruppoFinderImpl.class);
		
		/*private String GET_GRUPPY_BY_NAME = RubricaGruppoFinderImpl.class.getName()
				+ ".getGruppiByName";
		
		private String GET_GRUPPY_BY_NAME_CATEGORY = RubricaGruppoFinderImpl.class.getName()
				+ ".getGruppiByNameCategory";
		
		private String GET_GRUPPI_BY_OWNER_AND_NAME = RubricaGruppoFinderImpl.class.getName()
				+ ".getGruppoForOwnerAndName";
	
		private String GET_ALL_GRUPPI = RubricaGruppoFinderImpl.class.getName()
				+ ".getAllGruppi";
		
		private String GET_GROUP = RubricaGruppoFinderImpl.class.getName()
				+ ".getGroup";
		
		private String AGGIORNA_TUTTO_GRUPPO = RubricaGruppoFinderImpl.class.getName()
				+ ".aggiornaTuttoGruppo";
		
		private String GET_GERARCHIA = RubricaGruppoFinderImpl.class.getName()
				+ ".getGerarchia";*/
	
	private String GET_GRUPPY_BY_NAME = "select distinct rg.ID_GRUPPO, rg.NOME, rg.FK_SITO_PROPRIETARIO, rg.NOTE, rg.FK_UTENTE_CREAZIONE, rg.DATA_CREAZIONE, rg.FK_UTENTE_MODIFICA, rg.DATA_MODIFICA, rg.DISABLED\r\n"
			+ "	from  rubrica_rubricaGruppo rg\r\n"
			+ "	where rg.fk_sito_proprietario = ? \r\n"
			+ "	and not rg.disabled  \r\n"
			+ "	and upper(nome) like upper (?)\r\n"
			+ "	order by rg.nome";
	
	private String GET_GRUPPY_BY_NAME_CATEGORY = "select distinct rg.ID_GRUPPO, rg.NOME, rg.FK_SITO_PROPRIETARIO, rg.NOTE, rg.FK_UTENTE_CREAZIONE, rg.DATA_CREAZIONE, rg.FK_UTENTE_MODIFICA, rg.DATA_MODIFICA, rg.DISABLED\r\n"
			+ "	from  rubrica_rubricaGruppo rg\r\n"
			+ "	where rg.fk_sito_proprietario = ? \r\n"
			+ "	and not rg.disabled  \r\n"
			+ "	and upper(nome) like upper (?) and fk_categoria = ?\r\n"
			+ "	order by rg.nome";
	
	private String GET_GRUPPI_BY_OWNER_AND_NAME = "select rg.ID_GRUPPO, rg.NOME, rg.FK_SITO_PROPRIETARIO, rg.NOTE, rg.FK_UTENTE_CREAZIONE, rg.DATA_CREAZIONE, rg.FK_UTENTE_MODIFICA, rg.DATA_MODIFICA, rg.DISABLED\r\n"
			+ "	from  rubrica_rubricaGruppo rg\r\n"
			+ "	where rg.fk_sito_proprietario = ? \r\n"
			+ "	and not rg.disabled  \r\n"
			+ "	and upper(nome) = upper (?)";

	private String GET_ALL_GRUPPI = "select rg.nome as gruppo, rn.cognome,rn.nome, rr.descrizione as ruolo, rgn.specifica_ruolo, rn.indirizzo, rca.nome as tipo_contatto, rc.contatto from\r\n"
			+ "	rubrica_rubricagruppo rg join rubrica_rubricagrupponominativi rgn on rgn.fk_gruppo = rg.id_gruppo\r\n"
			+ "	join rubrica_rubricanominativo rn on rn.id_nominativo = rgn.fk_nominativo\r\n"
			+ "	join rubrica_rubricacontatto rc on rc.fk_nominativo = rn.id_nominativo\r\n"
			+ "	left join rubrica_rubricaruolo rr on rr.id_ruolo=rgn.fk_ruolo\r\n"
			+ "	left join rubrica_rubricacanale rca on rca.id_canale = rc.fk_canale\r\n"
			+ "	where not rn.disabled and not rg.disabled and rc.data_fine_validita is null\r\n"
			+ "	order by rg.nome,rn.cognome,rn.nome,rca.nome,rc.contatto";
	
	private String GET_GROUP = "with recursive grafo_gruppi (gruppo,cognome,nome,ruolo,specifica_ruolo,indirizzo,tipo_contatto,contatto,nomegruppo,nomeruolo,datagruppo,datacontatto)\r\n"
			+ "    as (	\r\n"
			+ "    select rg.id_gruppo as gruppo,rn.cognome,rn.nome,rgn.fk_ruolo,rgn.specifica_ruolo,rn.indirizzo,rca.nome as tipo_contatto,rc.contatto,rg.nome as nomegruppo,rr.descrizione as nomeruolo,\r\n"
			+ "    coalesce(rg.data_modifica,rg.data_creazione) as datagruppo, coalesce(rc.data_modifica,rc.data_creazione) as datacontatto\r\n"
			+ "    from rubrica_rubricagruppo rg \r\n"
			+ "    left join rubrica_rubricagrupponominativi rgn on rgn.fk_gruppo=rg.id_gruppo\r\n"
			+ "    left join rubrica_rubricanominativo rn on rn.id_nominativo = rgn.fk_nominativo and not rn.disabled\r\n"
			+ "    left join rubrica_rubricacontatto rc on rc.fk_nominativo = rn.id_nominativo\r\n"
			+ "    left join rubrica_rubricaruolo rr on rr.id_ruolo=rgn.fk_ruolo\r\n"
			+ "    left join rubrica_rubricacanale rca on rca.id_canale = rc.fk_canale\r\n"
			+ "    where id_gruppo = ? and not (rg.disabled=true)  and rc.data_fine_validita is null\r\n"
			+ "        UNION\r\n"
			+ "    select rg.id_gruppo as gruppo,rn.cognome,rn.nome,rgn.fk_ruolo,rgn.specifica_ruolo,rn.indirizzo,rca.nome as tipo_contatto,rc.contatto,rg.nome as nomegruppo,rr.descrizione as nomeruolo,\r\n"
			+ "    coalesce(rg.data_modifica,rg.data_creazione) as datagruppo, coalesce(rc.data_modifica,rc.data_creazione) as datacontatto\r\n"
			+ "    from grafo_gruppi gg \r\n"
			+ "    left join rubrica_rubricagruppogruppi rgg on rgg.fk_gruppo_padre = gg.gruppo\r\n"
			+ "    left join rubrica_rubricagruppo rg on rg.id_gruppo = rgg.fk_gruppo_figlio and not rg.disabled\r\n"
			+ "    left join rubrica_rubricagrupponominativi rgn on rgn.fk_gruppo=rg.id_gruppo\r\n"
			+ "    left join rubrica_rubricanominativo rn on rn.id_nominativo = rgn.fk_nominativo and not rn.disabled\r\n"
			+ "    left join rubrica_rubricacontatto rc on rc.fk_nominativo = rn.id_nominativo and rc.data_fine_validita is null\r\n"
			+ "    left join rubrica_rubricaruolo rr on rr.id_ruolo=rgn.fk_ruolo\r\n"
			+ "    left join rubrica_rubricacanale rca on rca.id_canale = rc.fk_canale\r\n"
			+ "    )\r\n"
			+ "    select * from grafo_gruppi where contatto is not null order by gruppo,cognome,nome,tipo_contatto,contatto";
	
	private String AGGIORNA_TUTTO_GRUPPO = "update rubrica_rubricacontatto rc set data_modifica = now() where\r\n"
			+ "	rc.id_contatto in (\r\n"
			+ "	select distinct id_contatto from rubrica_rubricacontatto rc2 join\r\n"
			+ "	rubrica_rubricagrupponominativi rn on rn.fk_nominativo = rc2.fk_nominativo\r\n"
			+ "	where rn.fk_gruppo = ?\r\n"
			+ "	)";
	
	private String GET_GERARCHIA = "select *\r\n"
			+ "	from  lr7_rubrica_gerarchia rg\r\n"
			+ "	where rg.fk_sito_proprietario = ? ";
		
		public void aggiornaTuttoGruppo(Long gruppo) {
			Session session = null;
			try{
				session = openSession();
				int start = -1;
				int end = -1;
				
				String sql = AGGIORNA_TUTTO_GRUPPO;
				
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
				
				String sql =  GET_GRUPPY_BY_NAME;
				
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
		
		public ArrayList<Object[]> getGruppiByNameCategory(Long site, String groupName, Long category, Long limit, Long offset) {
			Session session = null;
			try{
				session = openSession();
				int start = -1;
				int end = -1;
				
				String sql =  GET_GRUPPY_BY_NAME_CATEGORY;
				
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
				qPos.add(category);
				
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
		
		public ArrayList<Object[]> getGerarchia(Long site) {
			Session session = null;
			try{
				session = openSession();
				int start = -1;
				int end = -1;
				
				String sql =  GET_GERARCHIA;
				
				SQLQuery query = session.createSQLQuery(sql);
				query.setCacheable(false);

				query.addScalar("ID_GRUPPO", Type.LONG);
				query.addScalar("NOME", Type.STRING);
				query.addScalar("FK_SITO_PROPRIETARIO", Type.LONG);
				query.addScalar("SOTTOGRUPPI", Type.STRING);
				query.addScalar("NOMINATIVI", Type.STRING);


				QueryPos qPos = QueryPos.getInstance(query);

				qPos.add(site);

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
				
				String sql =  GET_GRUPPI_BY_OWNER_AND_NAME;
				
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
				
				String sql =  GET_ALL_GRUPPI;
				
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
		
		public ArrayList<Object[]> getGroup(Long id) {
			Session session = null;
			try{
				session = openSession();
				int start = -1;
				int end = -1;
				
				String sql = GET_GROUP;
				
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

	
	

