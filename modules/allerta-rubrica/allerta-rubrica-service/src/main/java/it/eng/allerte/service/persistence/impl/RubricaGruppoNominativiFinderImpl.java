package it.eng.allerte.service.persistence.impl;

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

import it.eng.allerte.service.persistence.RubricaGruppoNominativiFinder;


public class RubricaGruppoNominativiFinderImpl extends RubricaGruppoNominativiFinderBaseImpl 
	implements RubricaGruppoNominativiFinder{
		
	public static final Log _log = LogFactoryUtil.getLog(RubricaGruppoNominativiFinderImpl.class);
		
	private String DEL_GRUPPO_BY_NOMINATIVO = RubricaGruppoNominativiFinderImpl.class.getName()
					+ ".deleteByNominativo";
		
	private String DEL_GRUPPO_NOMINATIVO_BY_GRUPPO = RubricaGruppoNominativiFinderImpl.class.getName()
			+ ".deleteByGruppo";
	
	private String DEL_NOMINATIVO_FROM_GRUPPO = RubricaGruppoNominativiFinderImpl.class.getName()
			+ ".deleteNominativoDaGruppo";
	
	private String LOAD_GRUPPO_BY_NOMINATIVO = RubricaGruppoNominativiFinderImpl.class.getName()
					+ ".loadByIdRuolo";
	
	private String LOAD_NOMINATIVI_GRUPPO = RubricaGruppoNominativiFinderImpl.class.getName()
			+ ".loadNominativiGruppo";
	
	private String LOAD_RUOLI_BY_NOMINATIVO = RubricaGruppoNominativiFinderImpl.class.getName()
			+ ".laodRuoliByNominativo";
		

	public void deleteByNominativo(Long fkNominativo) {
		Session session = null;
		try{
			session = openSession();

			String sql = customSQL.get(this.getClass(), DEL_GRUPPO_BY_NOMINATIVO);

			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(true);

			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(fkNominativo);
				
			query.executeUpdate();
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
	}

	public void deleteByGruppo(Long fkGruppo) {
		Session session = null;
		try{
			session = openSession();

			String sql = customSQL.get(this.getClass(), DEL_GRUPPO_NOMINATIVO_BY_GRUPPO);

			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(true);

			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(fkGruppo);
				
			query.executeUpdate();
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
	}
	
	
	public void deleteNominativoDaGruppo(Long fkGruppo, Long fkNominativo) {
		Session session = null;
		try{
			session = openSession();

			String sql = customSQL.get(this.getClass(), DEL_NOMINATIVO_FROM_GRUPPO);

			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(true);

			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(fkGruppo);
			qPos.add(fkNominativo);
				
			query.executeUpdate();
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
	}
		
	public List<Object[]> loadByidRuolo(Long idRuolo) {

		Session session = null;
			
		try{
			
			session = openSession();

			String sql = customSQL.get(this.getClass(), LOAD_GRUPPO_BY_NOMINATIVO);
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(true);
			query.addScalar("FK_GRUPPO", Type.LONG);
			query.addScalar("FK_NOMINATIVO", Type.LONG);
	
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(idRuolo);
	
			List<Object[]> list = (List<Object[]>)QueryUtil.list(query, getDialect(), -1, -1);
	
			return list;
		
		} catch(Exception e){
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
	
	public List<Object[]> loadNominativiGruppo(Long idGruppo, Long idSite) {

		Session session = null;
			
		try{
			
			session = openSession();

			String sql = customSQL.get(this.getClass(), LOAD_NOMINATIVI_GRUPPO);
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addScalar("FK_GRUPPO", Type.LONG);
			query.addScalar("FK_NOMINATIVO", Type.LONG);
			query.addScalar("FK_RUOLO", Type.LONG);
			query.addScalar("SPECIFICA_RUOLO", Type.STRING);
	
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(idGruppo);
			qPos.add(idSite);
	
			List<Object[]> list = (List<Object[]>)QueryUtil.list(query, getDialect(), -1, -1);
	
			return list;
		
		} catch(Exception e){
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
	
	public List<Object[]> loadRuoloByNominativo(Long idNominativo) {

		Session session = null;
			
		try{
			
			session = openSession();

			String sql = customSQL.get(this.getClass(), LOAD_RUOLI_BY_NOMINATIVO);
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addScalar("FK_GRUPPO", Type.LONG);
			query.addScalar("FK_NOMINATIVO", Type.LONG);
			query.addScalar("FK_RUOLO", Type.LONG);
	
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(idNominativo);
	
			List<Object[]> list = (List<Object[]>)QueryUtil.list(query, getDialect(), -1, -1);
	
			return list;
		
		} catch(Exception e){
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

	
	

