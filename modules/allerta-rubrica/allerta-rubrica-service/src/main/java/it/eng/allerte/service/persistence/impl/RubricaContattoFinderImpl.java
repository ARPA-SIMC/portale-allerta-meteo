package it.eng.allerte.service.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
//import com.liferay.util.dao.orm.CustomSQLUtil;

import it.eng.allerte.model.RubricaContatto;
import it.eng.allerte.service.persistence.RubricaContattoFinder;

@Component(service = RubricaContattoFinder.class)
public class RubricaContattoFinderImpl extends RubricaContattoFinderBaseImpl 
	implements RubricaContattoFinder{
		
	public static final Log _log = LogFactoryUtil.getLog(RubricaContattoFinderImpl.class);
		
		/*private String DEL_CONTATTO_BY_NOMINATIVO = RubricaContattoFinderImpl.class.getName()
				+ ".deleteByNominativo";
		
		private String LOAD_CONTATTO_BY_NOMINATIVO = RubricaContattoFinderImpl.class.getName()
				+ ".loadByNominativo";*/
	
	private String DEL_CONTATTO_BY_NOMINATIVO = "delete from  rubrica_rubricaContatto where FK_NOMINATIVO = ?";
	
	private String LOAD_CONTATTO_BY_NOMINATIVO = "	select ID_CONTATTO, FK_NOMINATIVO, FK_CANALE, CONTATTO, ALLERTAMENTO, FK_UTENTE_CREAZIONE, "
			+ "	DATA_CREAZIONE, FK_UTENTE_MODIFICA, DATA_MODIFICA, DATA_FINE_VALIDITA "
			+ "	from  rubrica_rubricaContatto "
			+ "	where FK_NOMINATIVO = ? "
			+ "	and DATA_FINE_VALIDITA is null "
			+ "	and ALLERTAMENTO";
		

		public void deleteByNominativo(Long fkNominativo) {
			Session session = null;
			try{
				session = openSession();

				String sql = DEL_CONTATTO_BY_NOMINATIVO;

				SQLQuery query = session.createSQLQuery(sql);
				query.setCacheable(false);

				QueryPos qPos = QueryPos.getInstance(query);
				qPos.add(fkNominativo);
				
				query.executeUpdate();
//				ArrayList<Object[]> lista = new ArrayList<Object[]>();
//				lista.addAll((List<Object[]>)QueryUtil.list(query, getDialect(), -1, -1));

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
		
		
		public ArrayList<Object[]> loadByNominativo(Long idNominativo) {
			Session session = null;
			try{
				session = openSession();

				String sql = LOAD_CONTATTO_BY_NOMINATIVO;

				SQLQuery query = session.createSQLQuery(sql);
				query.setCacheable(false);
				query.addScalar("ID_CONTATTO", Type.LONG);
				query.addScalar("FK_NOMINATIVO", Type.LONG);
				query.addScalar("FK_CANALE", Type.LONG);
				query.addScalar("CONTATTO", Type.STRING);
				query.addScalar("ALLERTAMENTO", Type.BOOLEAN);
				query.addScalar("FK_UTENTE_CREAZIONE", Type.LONG);
				query.addScalar("DATA_CREAZIONE", Type.DATE);
				query.addScalar("FK_UTENTE_MODIFICA", Type.LONG);
				query.addScalar("DATA_MODIFICA", Type.DATE);
				query.addScalar("DATA_FINE_VALIDITA", Type.DATE);


				QueryPos qPos = QueryPos.getInstance(query);
				qPos.add(idNominativo);
				
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

	
	

