package it.eng.allerta.controlpanel.portlet;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;

import java.util.List;

import it.eng.allerter.model.AllertaParametro;
import it.eng.allerter.service.AllertaParametroLocalServiceUtil;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;

public class AllertaParametroSearchHelper {
	
	public static List<AllertaParametro> getParametros(AllertaParametroDisplayTerms dt, int start, int end) {
		DynamicQuery dq = AllertaParametroLocalServiceUtil.dynamicQuery();
		dq = dq.addOrder(OrderFactoryUtil.asc("parametroId"));
		dq.setLimit(start, end);
		return AllertaParametroLocalServiceUtil.dynamicQuery(dq);

	}
	
	public static int getParametroCount(AllertaParametroDisplayTerms displayTerms) {
		String q = "select count(*) from allerter_allertaparametro";
		Object o = BollettinoLocalServiceUtil.eseguiQueryGenerica(q);
		
		if ( o== null) 
			return 0;
		
		return Integer.parseInt(o.toString());
	}

}
