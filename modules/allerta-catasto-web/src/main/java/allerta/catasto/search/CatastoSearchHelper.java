package allerta.catasto.search;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import allerta.catasto.model.Segnalazione;
import allerta.catasto.service.SegnalazioneLocalServiceUtil;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;

public class CatastoSearchHelper {
	
	public static List<Segnalazione> getVerifiche(CatastoDisplayTerms displayTerms,int start,int end) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		DynamicQuery dq = SegnalazioneLocalServiceUtil.dynamicQuery();
		try {
			if (Validator.isNotNull(displayTerms.getDataDa()))
				dq = dq.add(PropertyFactoryUtil.forName("dataEvento").ge(sdf.parse(displayTerms.getDataDa())));
			if (Validator.isNotNull(displayTerms.getDataA()))
				dq = dq.add(PropertyFactoryUtil.forName("dataEvento").le(sdf.parse(displayTerms.getDataA())));
			if (Validator.isNotNull(displayTerms.getAreaFilter()) && !Validator.isBlank(displayTerms.getAreaFilter()))
				dq = dq.add(PropertyFactoryUtil.forName("area").like(displayTerms.getAreaFilter().toUpperCase()+"%"));
			if (Validator.isNotNull(displayTerms.getComuneFilter()) && !Validator.isBlank(displayTerms.getComuneFilter()))
				dq = dq.add(PropertyFactoryUtil.forName("comune").like("%"+displayTerms.getComuneFilter().toUpperCase()+"%"));
			if (displayTerms.getCategoriaFilter()>0)
				dq = dq.add(PropertyFactoryUtil.forName("categoria").eq(new Long(displayTerms.getCategoriaFilter())));

		} catch (Exception e) {
			e.printStackTrace();
		}
		String orderBy = displayTerms.getOrderByCol()!=null && !"".equals(displayTerms.getOrderByCol())?
				displayTerms.getOrderByCol():"dataEvento";
		boolean asc = "asc".equals(displayTerms.getOrderByType());
		dq = dq.addOrder(asc?OrderFactoryUtil.asc(orderBy):OrderFactoryUtil.desc(orderBy));
		dq.setLimit(start, end);
		//List<Verifica> evts = VerificaLocalServiceUtil.getVerificas(start, end);
		return SegnalazioneLocalServiceUtil.dynamicQuery(dq);

	}
	
	
	public static int getVerificheCount(CatastoDisplayTerms displayTerms) {
		

		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		String q = "select count(*) from catasto_segnalazione where 1=1 ";
		if ( Validator.isNotNull(displayTerms.getDataDa())) {
			
			try {
				q += " and dataevento>='" + sdf.parse(displayTerms.getDataDa()) + "'";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if ( Validator.isNotNull(displayTerms.getDataA())) {
			
			try {
				q += " and dataevento<='" + sdf.parse(displayTerms.getDataA()) + "'";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (Validator.isNotNull(displayTerms.getAreaFilter()) && !Validator.isBlank(displayTerms.getAreaFilter())) {
			q += " and area like '" + displayTerms.getAreaFilter().toUpperCase() + "%'";
		}
		if (Validator.isNotNull(displayTerms.getComuneFilter()) && !Validator.isBlank(displayTerms.getComuneFilter())) {
			q += " and comune like '%" + displayTerms.getComuneFilter().toUpperCase() + "%'";
		}
		if (displayTerms.getCategoriaFilter()>0) {
			q += " and categoria = " + displayTerms.getCategoriaFilter();

		}

		
		Object o = BollettinoLocalServiceUtil.eseguiQueryGenerica(q);
		
		if ( o== null) 
			return 0;
		
		return Integer.parseInt(o.toString());
	}

}
