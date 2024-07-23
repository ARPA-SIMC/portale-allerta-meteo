package it.eng.sms.portlet.portlet;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
import com.liferay.portal.kernel.util.PortalUtil;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerta.utils.AllertaTracker;
import it.eng.allerter.allerta.JasperUtils;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=" + AllertaKeys.AllertaCategory,
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/elencoCittadini.jsp",
		"javax.portlet.display-name=Elenco Cittadini", 
		"javax.portlet.name=" + "ElencoCittadiniPortlet",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ElencoCittadiniPortlet extends MVCPortlet {
	
	@Override
	public void serveResource(
				ResourceRequest resourceRequest, ResourceResponse resourceResponse) 
						throws IOException, PortletException {
		
		String cognome = ParamUtil.getString(resourceRequest, "cognome");
		String nome = ParamUtil.getString(resourceRequest, "nome");
		String email = ParamUtil.getString(resourceRequest, "email");
		String comune = ParamUtil.getString(resourceRequest, "comune");
		String tel = ParamUtil.getString(resourceRequest, "tel");
		
		Long userId = PortalUtil.getUserId(resourceRequest);
		
		
		DataSource ds = InfrastructureUtil.getDataSource();
		Connection connection = null;
		try {
			connection = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HashMap<String,Object> params = new HashMap<String,Object>();
		
		String templateName = "Cittadini.jasper";
		
		String pathReports = "/report/";
		String dirSubReport = pathReports;
		
		params.put("SUBREPORT_DIR",dirSubReport);
		System.out.println("SUBREPORT_DIR -> "+dirSubReport);
		
		params.put("USER", userId);
		params.put("COMUNE", comune);
		params.put("COGNOME", cognome);
		params.put("NOME", nome);
		params.put("EMAIL", email);
		params.put("TEL", tel);
		
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
		
		if (connection!=null) {
			try {
				connection.close();
			} catch (Exception e) {}
		}
	}
	
}
