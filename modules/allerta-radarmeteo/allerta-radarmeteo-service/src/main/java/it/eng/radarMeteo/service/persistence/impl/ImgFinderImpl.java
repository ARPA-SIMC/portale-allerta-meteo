package it.eng.radarMeteo.service.persistence.impl;

import java.util.List;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.radarMeteo.model.Img;
import it.eng.radarMeteo.model.impl.ImgImpl;
import it.eng.radarMeteo.service.persistence.ImgFinder;

public class ImgFinderImpl extends ImgFinderBaseImpl implements ImgFinder{
	private String GET_MostOld = ImgFinderImpl.class.getName()
			+ ".getMostOld";
	private String GET_LastRadar = ImgFinderImpl.class.getName()
			+ ".getLastRadar";

	public Img findFirstToUpdate() {
		Session session = openSession();

		String sql = customSQL.get(this.getClass(), GET_MostOld);
		SQLQuery query = session.createSQLQuery(sql);

		query.addEntity("Img", ImgImpl.class);

		List<Img> list = (List<Img>)QueryUtil.list(query, getDialect(), -1, -1);

		closeSession(session);
		return list.get(0);
	}
	
	public Img findLastRadar() {
		Session session = openSession();

		String sql = customSQL.get(this.getClass(), GET_LastRadar);
		
		SQLQuery query = session.createSQLQuery(sql);

		query.addEntity("Img", ImgImpl.class);

		QueryPos qPos = QueryPos.getInstance(query);

		List<Img> list = (List<Img>)QueryUtil.list(query, getDialect(), -1, -1);

		closeSession(session);
		return list.get(0);
	}
	
	@ServiceReference(type = CustomSQL.class)
	private CustomSQL customSQL;

}
