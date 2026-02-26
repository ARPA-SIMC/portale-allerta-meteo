package it.eng.radarMeteo.service.persistence.impl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import it.eng.radarMeteo.model.Img;
import it.eng.radarMeteo.model.impl.ImgImpl;
import it.eng.radarMeteo.service.persistence.ImgFinder;

@Component(service = ImgFinder.class)
public class ImgFinderImpl extends ImgFinderBaseImpl implements ImgFinder{
	/*private String GET_MostOld = ImgFinderImpl.class.getName()
			+ ".getMostOld";
	private String GET_LastRadar = ImgFinderImpl.class.getName()
			+ ".getLastRadar";*/
	
	private String GET_MostOld = "select * from rt_portlet_img  where timestamp in (select min(timestamp) from rt_portlet_img)";
	private String GET_LastRadar = "select * from rt_portlet_img  where timestamp in (select max(timestamp) from rt_portlet_img)";

	public Img findFirstToUpdate() {
		Session session = openSession();

		String sql = GET_MostOld;
		SQLQuery query = session.createSQLQuery(sql);

		query.addEntity("Img", ImgImpl.class);

		List<Img> list = (List<Img>)QueryUtil.list(query, getDialect(), -1, -1);

		closeSession(session);
		return list.get(0);
	}
	
	public Img findLastRadar() {
		Session session = openSession();
		String sql = GET_LastRadar;
		
		SQLQuery query = session.createSQLQuery(sql);

		query.addEntity("Img", ImgImpl.class);

		QueryPos qPos = QueryPos.getInstance(query);

		List<Img> list = (List<Img>)QueryUtil.list(query, getDialect(), -1, -1);

		closeSession(session);
		return list.get(0);
	}


}
