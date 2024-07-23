package it.eng.radarMeteo.service.persistence.impl;

import java.util.List;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.radarMeteo.service.persistence.Comuni_wsFinder;

public class Comuni_wsFinderImpl extends Comuni_wsFinderBaseImpl implements Comuni_wsFinder{
	private String GET_Meteomont = Comuni_wsFinderImpl.class.getName() + ".getMeteomont";
	private String GET_StatoAllerta = Comuni_wsFinderImpl.class.getName() + ".getStatoAllerta";
	private String GET_StatoAllertaForCap = Comuni_wsFinderImpl.class.getName() + ".getAllertaForCap";
	private String GET_BollettinoMonitoraggio = Comuni_wsFinderImpl.class.getName() + 
			".getBollettinoMonitoraggio";

	public List<Object[]> getMeteomont() {
		Session session = openSession();

		String sql = customSQL.get(this.getClass(), GET_Meteomont);
		SQLQuery query = session.createSQLQuery(sql);
		query.setCacheable(true);
//		QueryPos qPos = QueryPos.getInstance(query);

		List<Object[]> list = (List<Object[]>)QueryUtil.list(query, getDialect(), -1, -1);

		closeSession(session);
		
		return list;
	}
	
	public List<Object[]> getStatoAllerta(java.sql.Timestamp data) {
		Session session = openSession();
		String sql = customSQL.get(this.getClass(), GET_StatoAllerta);
		SQLQuery query = session.createSQLQuery(sql);
		query.setCacheable(true);
		QueryPos qPos = QueryPos.getInstance(query);
		qPos.add(data);
		qPos.add(data);
		qPos.add(data);
		qPos.add(data);

		List<Object[]> list = (List<Object[]>)QueryUtil.list(query, getDialect(), -1, -1);
		
		closeSession(session);
		return list;
	}
	
	public List<Object[]> getStatoAllertaForCap(java.sql.Timestamp data) {
		Session session = openSession();
		String sql = customSQL.get(this.getClass(), GET_StatoAllertaForCap);
		SQLQuery query = session.createSQLQuery(sql);
		query.setCacheable(true);
		QueryPos qPos = QueryPos.getInstance(query);
		qPos.add(data);
		qPos.add(data);

		List<Object[]> list = (List<Object[]>)QueryUtil.list(query, getDialect(), -1, -1);
		
		closeSession(session);
		return list;
	}
	
	public List<Object[]> getBollettinoMonitoraggio() {
		Session session = openSession();
		String sql = customSQL.get(this.getClass(), GET_BollettinoMonitoraggio);
		SQLQuery query = session.createSQLQuery(sql);
		query.setCacheable(true);
//		QueryPos qPos = QueryPos.getInstance(query);

		List<Object[]> list = (List<Object[]>)QueryUtil.list(query, getDialect(), -1, -1);
		
		closeSession(session);
		return list;
	}
	
	@ServiceReference(type = CustomSQL.class)
	private CustomSQL customSQL;
}
