package it.eng.allerta.messages.services;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ServiceScope;

import it.eng.allerta.messages.services.service.SmsSchedulerContextLocalService;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


@Component(
	immediate = true,
	scope = ServiceScope.SINGLETON,
	service = SmsUtility.class
)
public class SmsUtility {
	
	private static Log logger = LogFactoryUtil.getLog(SmsUtility.class);
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	SmsSchedulerContextLocalService smsSchedulerContextLocalService;
	
	public static String nameJVM(){
		return ManagementFactory.getRuntimeMXBean().getName();
	}

	public static String tail( File file, int lines) {
		java.io.RandomAccessFile fileHandler = null;
		
		try {
			fileHandler = new java.io.RandomAccessFile( file, "r" );
			long fileLength = fileHandler.length() - 1;
			StringBuilder sb = new StringBuilder(lines*80);
			int line = 0;

			for(long filePointer = fileLength; filePointer != -1; filePointer--){
				fileHandler.seek( filePointer );
				int readByte = fileHandler.readByte();

				if( readByte == 0xA ) {
					if (filePointer < fileLength) {
						line = line + 1;
					}
				} else if( readByte == 0xD ) {
					if (filePointer < fileLength-1) {
						line = line + 1;
					}
				}
				if (line >= lines) {
					break;
				}
				sb.append(( char ) readByte );
			}
			String lastLine = sb.reverse().toString();			
			
			return lastLine;
		} catch(java.io.FileNotFoundException e) {
			logger.error("File non trovato", e);
			
			return null;
		} catch(java.io.IOException e) {
			logger.error("File non trovato", e);
			
			return null;
		} finally {
			if (fileHandler != null) {
				try {
					fileHandler.close();
				} catch (IOException e) {
					logger.error("Non è stato possibile chiudere il file " + file.getName(), e);
				}
			}
		}
	}	
	
	/**
	 * Creazione e configurazione del client per le chiamate Rest
	 * 
	 * @return
	 */
	public static CloseableHttpClient getCloseableHttpClient(int timeout_s) {		
		//return new HttpClient();
		RequestConfig config = RequestConfig.custom()
				.setConnectTimeout(120 * 1000)
				.build();
		CloseableHttpClient httpClient = HttpClients.custom()
				.setDefaultRequestConfig(config)
				.build();
		
		return httpClient;
	}
	
	/**
	 * Chiusura delle risorse
	 * 
	 * @param closeables risorse che devono essere chiuse
	 */
	public static void closeResources(Closeable... closeables) {
		if (closeables != null) {
			for (Closeable closable:closeables) {
				if (closable != null) {
					try {
						closable.close();
					} catch (IOException e) {
						logger.error("Si è verificato un errore nella chiusura della risorsa " + closable.toString(), e);
					}
				}
			}
		}
	}
}
