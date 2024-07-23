package allerta.verifica.web.bean;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import allerta.verifica.model.Verifica;
import allerta.verifica.service.VerificaLocalServiceUtil;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;

public class VerificaSearchHelper {
	
	public static List<Verifica> getVerifiche(VerificaDisplayTerms displayTerms,int start,int end) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		DynamicQuery dq = VerificaLocalServiceUtil.dynamicQuery();
		try {
			if (Validator.isNotNull(displayTerms.getDataDa()))
				dq = dq.add(PropertyFactoryUtil.forName("dataFine").gt(sdf.parse(displayTerms.getDataDa())));
			if (Validator.isNotNull(displayTerms.getDataA()))
				dq = dq.add(PropertyFactoryUtil.forName("dataInizio").le(sdf.parse(displayTerms.getDataA())));
		} catch (Exception e) {
			e.printStackTrace();
		}
		dq = dq.addOrder(OrderFactoryUtil.desc("dataInizio"));
		dq.setLimit(start, end);
		//List<Verifica> evts = VerificaLocalServiceUtil.getVerificas(start, end);
		return VerificaLocalServiceUtil.dynamicQuery(dq);

	}
	
	
	public static int getVerificheCount(VerificaDisplayTerms displayTerms) {
		

		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String q = "select count(*) from verifica_verifica where 1=1 ";
		if ( Validator.isNotNull(displayTerms.getDataDa())) {
			
			try {
				q += " and datafine>'" + sdf.parse(displayTerms.getDataDa()) + "'";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if ( Validator.isNotNull(displayTerms.getDataA())) {
			
			try {
				q += " and datainizio<='" + sdf.parse(displayTerms.getDataA()) + "'";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Object o = BollettinoLocalServiceUtil.eseguiQueryGenerica(q);
		
		if ( o== null) 
			return 0;
		
		return Integer.parseInt(o.toString());
	}

}
