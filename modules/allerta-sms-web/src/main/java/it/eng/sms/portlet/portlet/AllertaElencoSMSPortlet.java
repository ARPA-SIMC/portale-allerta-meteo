package it.eng.sms.portlet.portlet;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.sql.DataSource;

import org.apache.http.HttpHeaders;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.InfrastructureUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerta.utils.AllertaTracker;
import it.eng.allerter.allerta.JasperUtils;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=" + AllertaKeys.AllertaCategory,
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/elencoSms.jsp",
		"javax.portlet.display-name=Elenco SMS", 
		"javax.portlet.name=" + AllertaKeys.AllertaElencoSmsPortlet,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AllertaElencoSMSPortlet extends MVCPortlet {
	
	@Override
	public void serveResource(
				ResourceRequest resourceRequest, ResourceResponse resourceResponse) 
						throws IOException, PortletException {
		
		String tipo = ParamUtil.getString(resourceRequest, "tipo");
		String sottoTipo = ParamUtil.getString(resourceRequest, "sottotipo");
		String nome = ParamUtil.getString(resourceRequest, "nome");
		String numero = ParamUtil.getString(resourceRequest, "numero");
		String dataInvioDa = ParamUtil.getString(resourceRequest, "dataInvioDa");
		String dataInvioA = ParamUtil.getString(resourceRequest, "dataInvioA");
		Long stato = ParamUtil.getLong(resourceRequest, "stato");
		String source = ParamUtil.getString(resourceRequest, "source");
		
		
		DataSource ds = InfrastructureUtil.getDataSource();
		Connection connection = null;
		try {
			connection = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HashMap<String,Object> params = new HashMap<String,Object>();
		
		String templateName = "SMS.jasper";
		if( source.equals("email"))
			templateName = "Email.jasper";
		
		String pathReports = "/report/";
		String dirSubReport = pathReports;
		
		params.put("SUBREPORT_DIR",dirSubReport);
		System.out.println("SUBREPORT_DIR -> "+dirSubReport);
		
		params.put("TIPO", tipo);
		params.put("SOTTOTIPO", sottoTipo);
		
		params.put("NUMERO", numero);
		params.put("DESTINATARIO", nome);
		
		params.put("PARAM", -1);

		params.put("DATADA", dataInvioDa);
		params.put("DATAA", dataInvioA);
		
		params.put("STATO", stato);
		
		JasperUtils ju = AllertaTracker.getService(JasperUtils.class); 
		byte[] report = null;
		
		try {
			report = ju.getReportAsExcel(templateName, params, connection);
		} catch( Exception x) {
			
		}
		
		if( report != null) {
			
			resourceResponse.setContentType(ContentTypes.APPLICATION_VND_MS_EXCEL);
	        resourceResponse.addProperty(HttpHeaders.CACHE_CONTROL, "must-revalidate, post-check=0, pre-check=0");
	        resourceResponse.addProperty(HttpHeaders.PRAGMA, "public");
	        resourceResponse.addProperty(HttpHeaders.EXPIRES, "0");
	        
			OutputStream out = resourceResponse.getPortletOutputStream();
			out.write(report);
			out.flush();
            out.close();
		}
	}
	
}
