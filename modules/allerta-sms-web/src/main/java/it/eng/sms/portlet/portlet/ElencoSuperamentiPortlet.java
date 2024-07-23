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

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerta.utils.AllertaTracker;
import it.eng.allerter.allerta.JasperUtils;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=" + AllertaKeys.AllertaCategory,
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/elencoSuperamenti.jsp",
		"javax.portlet.display-name=Elenco Superamenti", 
		"javax.portlet.name=" + "ElencoSuperamentiPortlet",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ElencoSuperamentiPortlet extends MVCPortlet {
	
	@Override
	public void serveResource(
				ResourceRequest resourceRequest, ResourceResponse resourceResponse) 
						throws IOException, PortletException {
		
		String tipo = ParamUtil.getString(resourceRequest, "tipo");
		String dataDa = ParamUtil.getString(resourceRequest, "dataDa");
		String dataA = ParamUtil.getString(resourceRequest, "dataA");
		String comune = ParamUtil.getString(resourceRequest, "comune");
		String provincia = ParamUtil.getString(resourceRequest, "provincia");
		String bacino = ParamUtil.getString(resourceRequest, "bacino");
		String stazione = ParamUtil.getString(resourceRequest, "stazione");
		String zona = ParamUtil.getString(resourceRequest, "zona");
		String soglia = ParamUtil.getString(resourceRequest, "soglia");
		
		DataSource ds = InfrastructureUtil.getDataSource();
		Connection connection = null;
		try {
			connection = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HashMap<String,Object> params = new HashMap<String,Object>();
		
		String templateName = "Superamenti.jasper";
		
		String pathReports = "/report/";
		String dirSubReport = pathReports;
		
		params.put("SUBREPORT_DIR",dirSubReport);
		System.out.println("SUBREPORT_DIR -> "+dirSubReport);
		
		params.put("TIPO", tipo);
		
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		try {
			if (dataDa!=null && !dataDa.equals("")) {
				
				if (!dataDa.contains(":")) 
					dataDa = dataDa.trim()+" 00:00";
				
				dataDa = sdf2.format(sdf1.parse(dataDa));
			}
			if (dataA!=null && !dataA.equals("")) {
				
				if (!dataA.contains(":")) 
					dataA = dataA.trim()+" 00:00";
				
				dataA = sdf2.format(sdf1.parse(dataA));
			}
		} catch (Exception e) {}
		
		params.put("DATADA", dataDa);
		params.put("DATAA", dataA);
		params.put("COMUNE", comune);
		params.put("PROVINCIA", provincia);
		params.put("BACINO", bacino);
		params.put("STAZIONE", stazione);
		params.put("ZONA", zona);
		params.put("SOGLIA", soglia);
		
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
