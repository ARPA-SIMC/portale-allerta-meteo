package it.eng.sms.portlet.portlet;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.sms.bean.SMSGrafico;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author CPPNDR74H
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=" + AllertaKeys.AllertaCategory,
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/grafico.jsp",
		"com.liferay.portlet.footer-portlet-javascript=/js/Chart.min.js",
		"com.liferay.portlet.footer-portlet-javascript=/js/sms-grafico.js",
		"javax.portlet.display-name=Grafico SMS", 
		"javax.portlet.name=" + AllertaKeys.AllertaGraficoSMSPortlet,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AllertaGraficoSmsWebPortlet extends MVCPortlet {
	
	@Override
	public void render( RenderRequest request, RenderResponse response) 
			throws IOException, PortletException {

		/*
		try {
			SMSGrafico g = new SMSGrafico();
		} catch(Exception e) {}
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		Date result = cal.getTime();
		
		try {
			
			_srv.findBydata(result);
			
		} catch(Exception e) {}
		*/
		super.render(request, response);
		
	}
	
	//@Reference 
	//private CounterSmsLocalService _srv;
}