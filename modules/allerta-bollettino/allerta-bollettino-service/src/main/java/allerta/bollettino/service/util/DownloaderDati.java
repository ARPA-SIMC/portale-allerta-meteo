package allerta.bollettino.service.util;

import com.liferay.portal.kernel.json.JSONDeserializer;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Base64;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DownloaderDati {
	
	private static Log logger = LogFactoryUtil.getLog(DownloaderDati.class);
	
	public static String downloadStazioni() {
		return download("portale_allerte/osservati/stations.json");
	}
	
	public static String downloadVariabili() {
		return download("portale_allerte/osservati/variables.json");
	}
	
	public static String downloadSensori() {
		return download("portale_allerte/osservati/sensors.json");
	}
	
	public static String downloadDatiOsservati() {
		return download("portale_allerte/osservati/data.json");
	}
	
	public static List<Map<String,Object>> convertiJson(String s) {
		
		if (s==null) return null;
		
		try {
			JSONDeserializer<ArrayList> deserializer = 
					JSONFactoryUtil.createJSONDeserializer();
			
			return deserializer.deserialize(s);
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	
	public static <T> T convertiJsonGenerico(String s) {
		
		if (s==null) return null;
		
		try {
			JSONDeserializer<T> deserializer = 
					JSONFactoryUtil.createJSONDeserializer();
			
			return deserializer.deserialize(s);
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	
	public static String download(String service) {
		
		String url = "https://portaleallerte:Phu9ka@simc.arpae.it/" + service;
		return downloadUrl(url);
		
	}
	
	private static String downloadUrl(String url) {
		
		try {

			URL u = new URL(url);

			HttpURLConnection conn = (HttpURLConnection) u.openConnection();
			
			conn.setConnectTimeout(30000);
			conn.setReadTimeout(60000);
			
			//logger.info("Request URL ... " + url);
			
			if (u.getUserInfo() != null) {
				String basicAuth = "Basic " + new String(new Base64().encode(u.getUserInfo().getBytes()));
				conn.setRequestProperty("Authorization", basicAuth);
			}
			
			boolean redirectRequest = false;

			int status = conn.getResponseCode();
			
			if (status != HttpURLConnection.HTTP_OK) {
				
				if (status == HttpURLConnection.HTTP_MOVED_TEMP
					|| status == HttpURLConnection.HTTP_MOVED_PERM
						|| status == HttpURLConnection.HTTP_SEE_OTHER)
					
					redirectRequest = true;
			}

			if (redirectRequest) {

				String newUrl = conn.getHeaderField("Location");
				conn.setConnectTimeout(30000);
				conn.setReadTimeout(60000);
				
				//logger.info("Redirect to URL : " + newUrl);
				conn = (HttpURLConnection) new URL(newUrl).openConnection();
			}

			BufferedReader in = new BufferedReader(
		                              new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();

			return content.toString();
						
		}
		catch (FileNotFoundException f) {
			logger.error("Error 404: "+url);
			return null;
		}
		catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

}
