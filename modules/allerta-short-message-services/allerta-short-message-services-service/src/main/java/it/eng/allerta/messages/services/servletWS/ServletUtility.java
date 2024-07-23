package it.eng.allerta.messages.services.servletWS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import it.eng.allerta.messages.services.model.Nodo;
import it.eng.allerta.messages.services.scheduler.SmsSchedulerContextUtility;
import it.eng.allerta.messages.services.service.NodoLocalServiceUtil;
import it.eng.allerta.messages.services.service.SmsSchedulerContextLocalService;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


public class ServletUtility {
	private static Log logger = LogFactoryUtil.getLog(ServletUtility.class);
	
	private static ServiceTracker<SmsSchedulerContextLocalService, SmsSchedulerContextLocalService> _serviceTrackerSmsSchedulerContext;
	private static SmsSchedulerContextLocalService smsSchedulerContextLocalService;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SmsSchedulerContextLocalService.class);
	
		ServiceTracker<SmsSchedulerContextLocalService, SmsSchedulerContextLocalService> serviceTracker =
				new ServiceTracker<SmsSchedulerContextLocalService, SmsSchedulerContextLocalService>(bundle.getBundleContext(), SmsSchedulerContextLocalService.class, null);
		serviceTracker.open();	
		_serviceTrackerSmsSchedulerContext = serviceTracker;
		smsSchedulerContextLocalService = _serviceTrackerSmsSchedulerContext.getService();
	}
	
	private static List<Nodo> nodeIpList;

	public static String callServletURL(String _url) throws IOException {
		BufferedReader in = null;
		boolean secure = !_url.contains("8080") && !_url.contains("8081");
		URL url = new URL((secure?"https://":"http://") + _url);			
		
		HttpURLConnection huc = (HttpURLConnection) url.openConnection();
		HttpsURLConnection.setFollowRedirects(false);
		huc.setConnectTimeout(0); // timeout infinito
		huc.setRequestMethod("GET");
		huc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2 (.NET CLR 3.5.30729)");
		
		if (huc instanceof HttpsURLConnection) {
			((HttpsURLConnection)huc).setHostnameVerifier(new HostnameVerifier() {
		        @Override
		        public boolean verify(String hostname, SSLSession sslSession) {
		            return true;
		        }			
		    });
		}
		
		
		huc.connect();
		
		in = new BufferedReader(new InputStreamReader(huc.getInputStream()));
		String readLine = in.readLine();
		String result = readLine.substring(2, readLine.length()-1);
		
		huc.disconnect();		
		
		try {
			if (in != null) {
				in.close();
			}
		} catch (IOException e) {
			logger.error("Errore nella chiusura del BufferedReader all'interno del metodo callServletURL", e);
		}
		
		return result;
	}
	
	/*public static String callMethodFromServlet(String methodName) {
		logger.debug("Invocato metodo callservlet con metodoName " + methodName);
		
		String URL = null;
		
		try {
			String hostIp_port = SmsSchedulerContextUtility.getHostIPAndPortOfCurrentScheduler();
			String hostIp = hostIp_port.substring(0, hostIp_port.indexOf(":"));			
			URL = hostIp_port + "/sms-service-portlet/ServletRestWS?callback=a&method_name=" + methodName + "&node_ip=" + hostIp + "&token=XG8ub2SNXoil5LWmdWUu";
			
			return callServletURL(URL);			
		} catch (UnknownHostException e1) {
			logger.error("Host non conosciuto", e1);
		} catch (IOException e) {
			logger.error("Errore di IO durante la chiamata alla servlet : " + URL, e);
		}
		
		return null;
	}*/
	
	public static String callMethodFromServlet(String methodName) {
		logger.debug("Invocato metodo callservlet con metodoName " + methodName);
		
		String URL = null;
		
		try {
			String hostIp_port = smsSchedulerContextLocalService.getHostIPAndPortOfCurrentScheduler();
			String hostIp = hostIp_port.substring(0, hostIp_port.indexOf(":"));			
			URL = hostIp_port + "/o/ServletRestWS?callback=a&method_name=" + methodName + "&node_ip=" + hostIp + "&token=XG8ub2SNXoil5LWmdWUu";
			
			return ServletUtility.callServletURL(URL);			
		} catch (UnknownHostException e1) {
			logger.error("Host non conosciuto", e1);
		} catch (IOException e) {
			logger.error("Errore di IO durante la chiamata alla servlet : " + URL, e);
		}
		
		return null;
	}
	
	// metodi private
	
	private static List<Nodo> getNodeIpList() throws SystemException {
		if (nodeIpList == null) {
			synchronized (ServletUtility.class) {
				if (nodeIpList == null) {
					nodeIpList = NodoLocalServiceUtil.getNodos(0, 2);
				}
			}			
		}
		
		return nodeIpList;
	}
}
