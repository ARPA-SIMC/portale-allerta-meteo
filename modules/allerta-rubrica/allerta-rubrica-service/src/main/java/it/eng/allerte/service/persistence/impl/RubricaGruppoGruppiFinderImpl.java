package it.eng.allerte.service.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.CacheMode;
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

import it.eng.allerte.model.RubricaGruppoGruppi;
import it.eng.allerte.service.persistence.RubricaGruppoGruppiFinder;


public class RubricaGruppoGruppiFinderImpl extends RubricaGruppoGruppiFinderBaseImpl 
	implements RubricaGruppoGruppiFinder{
		
	public static final Log _log = LogFactoryUtil.getLog(RubricaGruppoGruppiFinderImpl.class);
		
		private String GET_ANTENATI = RubricaGruppoGruppiFinderImpl.class.getName()
				+ ".getAntenati";
		
		private String GET_GRUPPI_FIGLI = RubricaGruppoGruppiFinderImpl.class.getName()
				+ ".getGruppiFigli";
		
		private String GET_GRUPPI_PADRE_FIGLI = RubricaGruppoGruppiFinderImpl.class.getName()
				+ ".getGruppiPadriPerFiglio";
		
		private String DEL_GRUPPO_PADRE_FIGLIO = RubricaGruppoGruppiFinderImpl.class.getName()
				+ ".deleteGruppoPadreFiglio";
		
		private String DEL_GRUPPO_SOTTO_GRUPPO = RubricaGruppoGruppiFinderImpl.class.getName()
				+ ".deleteGruppoSottoGruppo";

		public ArrayList<Object[]> getAntenati(Long fkGruppoFiglio) {
			Session session = null;
			try{
				session = openSession();

				String sql = customSQL.get(this.getClass(), GET_ANTENATI);

				SQLQuery query = session.createSQLQuery(sql);
				query.setCacheable(false);
				query.addScalar("FK_GRUPPO_PADRE", Type.LONG);


				QueryPos qPos = QueryPos.getInstance(query);
				qPos.add(fkGruppoFiglio);
				
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
		
		public ArrayList<Object[]> getGruppiFigli(Long fkGruppoPadre) {
			Session session = null;
			try{
				session = openSession();

				String sql = customSQL.get(this.getClass(), GET_GRUPPI_FIGLI);

				SQLQuery query = session.createSQLQuery(sql);
				query.setCacheable(false);
				query.addScalar("FK_GRUPPO_PADRE", Type.LONG);
				query.addScalar("FK_GRUPPO_FIGLIO", Type.LONG);


				QueryPos qPos = QueryPos.getInstance(query);
				qPos.add(fkGruppoPadre);
				
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
		
		public ArrayList<Object[]> getGruppiPadriPerFiglio(Long fkGruppoPadre) {
			Session session = null;
			try{
				session = openSession();

				String sql = customSQL.get(this.getClass(), GET_GRUPPI_PADRE_FIGLI);

				SQLQuery query = session.createSQLQuery(sql);
				query.setCacheable(false);
				query.addScalar("FK_GRUPPO_PADRE", Type.LONG);
				query.addScalar("NOME",Type.STRING);
				query.addScalar("FK_GRUPPO_FIGLIO", Type.LONG);


				QueryPos qPos = QueryPos.getInstance(query);
				qPos.add(fkGruppoPadre);
				
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

		
		public void deleteGruppoPadreFiglio(Long fkGruppo) {
			
			Session session = null;
			
			try{
				session = openSession();

				String sql = customSQL.get(this.getClass(), DEL_GRUPPO_PADRE_FIGLIO);

				SQLQuery query = session.createSQLQuery(sql);
				query.setCacheable(false);

				QueryPos qPos = QueryPos.getInstance(query);
				qPos.add(fkGruppo);
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
		
		public void deleteGruppoSottoGruppo(Long fkGruppo, Long fkSottoGruppo) {
			
			Session session = null;
			
			try{
				session = openSession();

				String sql = customSQL.get(this.getClass(), DEL_GRUPPO_SOTTO_GRUPPO);

				SQLQuery query = session.createSQLQuery(sql);
				query.setCacheable(false);

				QueryPos qPos = QueryPos.getInstance(query);
				qPos.add(fkGruppo);
				qPos.add(fkSottoGruppo);
					
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
		
		@ServiceReference(type = CustomSQL.class)
		private CustomSQL customSQL;

}

	
	

