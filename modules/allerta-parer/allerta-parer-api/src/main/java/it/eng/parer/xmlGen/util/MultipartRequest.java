package it.eng.parer.xmlGen.util;



import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * 
 * @author Pratola_L
 *
 */


public class MultipartRequest {

	private static Log logger = LogFactoryUtil.getLog(MultipartRequest.class);

	public String invia (String url, Map<String, File> allegati, Map<String, String> parameter) throws ClientProtocolException, IOException {

		RequestConfig config = RequestConfig.custom().setConnectTimeout(15 * 1000).build();
		try(CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(config).build()){

			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			builder.setCharset(Charset.forName(IJavaToXMLParerConstants.CHARSET));

			//Aggiungo i parametri di testo (LOGINAME, PASSWORD, etc..)
			//		for(Map.Entry<String, String> entry : parameter.entrySet()){
			//			builder.addTextBody(entry.getKey(), entry.getValue() ,ContentType.DEFAULT_TEXT);
			//		}

			//NOTA i parametri devono essere popolati in quest'ordine nel body altrimenti parer "si incazza"
			builder.addTextBody(IJavaToXMLParerConstants.PAR_VERSIONE, parameter.get(IJavaToXMLParerConstants.PAR_VERSIONE) ,ContentType.DEFAULT_TEXT);
			builder.addTextBody(IJavaToXMLParerConstants.PAR_LOGINNAME, parameter.get(IJavaToXMLParerConstants.PAR_LOGINNAME) ,ContentType.DEFAULT_TEXT);
			builder.addTextBody(IJavaToXMLParerConstants.PAR_PASSWORD, parameter.get(IJavaToXMLParerConstants.PAR_PASSWORD) ,ContentType.DEFAULT_TEXT);
			builder.addTextBody(IJavaToXMLParerConstants.PAR_XMLSIP, parameter.get(IJavaToXMLParerConstants.PAR_XMLSIP) ,ContentType.DEFAULT_TEXT);

			//Aggiungo i parametri file (Allegati)
			for(Map.Entry<String, File> entry: allegati.entrySet()){
				builder.addBinaryBody(entry.getKey(), entry.getValue(), ContentType.DEFAULT_BINARY, entry.getValue().getName());
			}

			//Costruisco l'entity
			HttpEntity multipart = builder.build();

			//Costruisco la richiesta settando il method e il body (entity)
			HttpUriRequest request = RequestBuilder
					.post(url)
					.setEntity(multipart)
					.build();

			logger.info("Executing request " + request.getRequestLine());

			//Sottometto la richiesta
			HttpResponse response = httpClient.execute(request);
			//Elaboro il result
			HttpEntity result = response.getEntity();

			
			int status = response.getStatusLine().getStatusCode();

			if (status == HttpURLConnection.HTTP_OK) {

				String resultInvio  = result != null ? EntityUtils.toString(result) : "";
				httpClient.close();
				return resultInvio;

			} else {
				logger.error("Server returned non-OK status: " + status);
				httpClient.close();
				throw new IOException("Server returned non-OK status: " + status);
			}
		}

	}

}
