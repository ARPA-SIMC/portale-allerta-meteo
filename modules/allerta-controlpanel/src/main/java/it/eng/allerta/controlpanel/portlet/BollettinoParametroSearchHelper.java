package it.eng.allerta.controlpanel.portlet;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;

import java.util.List;

import it.eng.bollettino.model.BollettinoParametro;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;
import it.eng.bollettino.service.BollettinoParametroLocalServiceUtil;

public class BollettinoParametroSearchHelper {
	
	public static List<BollettinoParametro> getParametros(BollettinoParametroDisplayTerms dt, int start, int end) {
		DynamicQuery dq = BollettinoParametroLocalServiceUtil.dynamicQuery();
		dq = dq.addOrder(OrderFactoryUtil.asc("parametroId"));
		dq.setLimit(start, end);
		return BollettinoParametroLocalServiceUtil.dynamicQuery(dq);

	}
	
	public static int getParametroCount(BollettinoParametroDisplayTerms displayTerms) {
		String q = "select count(*) from bollettino_bollettinoparametro";
		Object o = BollettinoLocalServiceUtil.eseguiQueryGenerica(q);
		
		if ( o== null) 
			return 0;
		
		return Integer.parseInt(o.toString());
	}

}
