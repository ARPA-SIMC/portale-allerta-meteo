package it.eng.allerta.messages.services.service.persistence.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.eng.allerta.messages.services.service.persistence.ParametroFinder;

public class ParametroFinderImpl extends ParametroFinderBaseImpl
			implements ParametroFinder {
	
	private final Log logger = LogFactoryUtil.getLog(ParametroFinderImpl.class);
	private String resetSMS = ParametroFinderImpl.class.getName()
			+ ".resetSMSFaseTwo";
	private String fetchStato3 = ParametroFinderImpl.class.getName()
			+ ".fetchSmsStatoTre";
	private String resetSMSSixToThree = ParametroFinderImpl.class.getName()
			+ ".resetSMSFaseThree";

	public int resetSMSFaseTwo() {
		Session session = null;
		int executeUpdate;
		try{
			session = openSession();

			String sql = CustomSQLUtil.get(this.getClass(), resetSMS);
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			executeUpdate = query.executeUpdate();
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				logger.error(se);
			}
			executeUpdate = -1;
		} finally {
			closeSession(session);
		}
		return executeUpdate;
	}
	
	public int resetSMSFaseThree() {
		Session session = null;
		int executeUpdate;
		try{
			session = openSession();

			String sql = CustomSQLUtil.get(this.getClass(), resetSMSSixToThree);
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			executeUpdate = query.executeUpdate();
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				logger.error(se);
			}
			executeUpdate = -1;
		} finally {
			closeSession(session);
		}
		return executeUpdate;
	}

	public List<Long> fetchSmsStatoTre() {
		Session session = null;
		try{
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.DATE, -2);
			Date dateBefore2Days = cal.getTime();
			
			session = openSession();

			String sql = CustomSQLUtil.get(this.getClass(), fetchStato3);
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addScalar("id_", Type.LONG);
			QueryPos qPos = QueryPos.getInstance(query);
//			qPos.add(3);
			qPos.add(dateBefore2Days);
			List<Long> list = (List<Long>) QueryUtil.list(query, getDialect(), 0, 100);
			return list;
		} catch (Exception e) {
			logger.error(e);
		}
		finally {
			closeSession(session);
		}
		return null;
	}

}
