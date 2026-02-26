package it.eng.allerta.messages.services;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import it.eng.allerta.messages.services.action.ShutdownAction;
import it.eng.allerta.messages.services.model.SmsSchedulerContext;
import it.eng.allerta.messages.services.model.impl.SmsSchedulerContextImpl;
import it.eng.allerta.messages.services.model.impl.SmsSchedulerContextImpl.SmsSchedulerState;
import it.eng.allerta.messages.services.scheduler.SmsSchedulerContextConstants;
import it.eng.allerta.messages.services.service.SmsSchedulerContextLocalService;
import it.eng.allerta.messages.services.service.SmsSchedulerContextLocalServiceUtil;
import it.eng.allerta.utils.AllertaTracker;

import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


public class SmsWebServiceServerVerify implements Runnable {

		// <var di classe>
		private static Log logger = LogFactoryUtil.getLog(SmsWebServiceServerVerify.class);
		
		private static ServiceTracker<SmsSchedulerContextLocalService, SmsSchedulerContextLocalService> _serviceTrackerSmsSchedulerContext;
		private static SmsSchedulerContextLocalService smsSchedulerContextLocalService;
		private static Bundle bundle;

		static {
			bundle = FrameworkUtil.getBundle(SmsSchedulerContextLocalService.class);
		
			ServiceTracker<SmsSchedulerContextLocalService, SmsSchedulerContextLocalService> serviceTracker =
					new ServiceTracker<SmsSchedulerContextLocalService, SmsSchedulerContextLocalService>(bundle.getBundleContext(), SmsSchedulerContextLocalService.class, null);
			serviceTracker.open();	
			_serviceTrackerSmsSchedulerContext = serviceTracker;
		}
		
		private static String errMsg = "Errore nella chiamata per la verifica della presenza o meno del service Telecom";
		
		private static String USERNAME;
		private static String PASSWORD;
		private static String TOKEN;
		private static String ALIAS;
		
		private static CloseableHttpClient httpClient;
		private static HttpPost httpPost;
		
		private int countError;
		private long sscServerVerifyDelayBetweenCall; // ms
		private long sscServerVerifyMaxError;
		private boolean serverVerifyEnable;
		
		public SmsWebServiceServerVerify() throws SystemException {
			try {
				/*
				USERNAME = AuthLocalServiceUtil.fetchAuth("USERNAME").getValue();
				PASSWORD = AuthLocalServiceUtil.fetchAuth("PASSWORD").getValue();
				TOKEN = AuthLocalServiceUtil.fetchAuth("TOKEN").getValue();
				ALIAS = AuthLocalServiceUtil.fetchAuth("ALIAS").getValue();
				*/
				USERNAME = AllertaTracker.getAllertaSMSConfiguration().username();
				PASSWORD = AllertaTracker.getAllertaSMSConfiguration().password();
				TOKEN = AllertaTracker.getAllertaSMSConfiguration().token();
				ALIAS = AllertaTracker.getAllertaSMSConfiguration().alias();
				smsSchedulerContextLocalService = _serviceTrackerSmsSchedulerContext.getService();
				serverVerifyEnable = true;
			} catch (Throwable e) {
				String errMsg = "Errore nella creazione del SmsWebServiceServerVerify, impoosibile creare il thread di verifica attività del server Telecom";
				logger.error(errMsg, e);
				
				smsSchedulerContextLocalService.sendMailWithPlainText(errMsg);		
				
				throw e;
			}
		}

		// metodo run che verrà eseguito dal thread di scheduling
		@Override
		public void run() {			
			boolean tryDeactivate = false;
			CloseableHttpClient httpClient = null;
			
			try {				
				tryDeactivate = SmsManagerWebServices.getInstance().isSmsSchedulerStateOneOf(SmsSchedulerState.FORCE_SHUTDOWN);
				
				if (tryDeactivate) {				
					SmsManagerWebServices.getInstance().forceShutdownSchedulerServerVerify();
					logger.info("Stop forzato dello schedulerServerVerify tramite lo stato FORCE_SHUTDOWN settato a DB");
				}
				
				// non sono stato interrotto (shutdownNow manuale dall'esterno o forzato tramite DB)
				if (serverVerifyEnable) {
					if (!Thread.currentThread().isInterrupted() && !tryDeactivate) {
						// eseguo il controllo tramite un numero di chiamate pari a maxError per verificare che il server Telecom sia attivo
						countError = 0;
						
						while (countError < sscServerVerifyMaxError && !tryDeactivate) {
							if (!isServerResponseStatusOk()) {
								++countError;
							} else countError = 0;					
							Thread.sleep(sscServerVerifyDelayBetweenCall);
							tryDeactivate = SmsManagerWebServices.getInstance().isSmsSchedulerStateOneOf(SmsSchedulerState.FORCE_SHUTDOWN);
						}
						if (countError == sscServerVerifyMaxError) {
							smsSchedulerContextLocalService.sendMailWithPlainText("Il server Telecom sembra non rispondere, verificare che il servizio sia attivo");
						}
					}
				}
			} catch (InterruptedException ie) {
				logger.info("schedulerServerVerify è stato interrotto in una fase di sleep, probabilmente è avvenuto uno shutdown");
			} catch (Throwable t) {
				String errMsg = "schedulerServerVerify andato in eccezione, verificare che la chiamata di verifica attività del server Telecom sia corretta";			
				logger.error(errMsg, t);				
				
				/*
				if (ShutdownAction.isServerShutdown()) { // perchè il server è in shutdown
					Thread.currentThread().interrupt(); // quindi mi auto interrompo
				}
				*/				
				smsSchedulerContextLocalService.sendMailWithPlainText(errMsg);
			} finally {
				if (httpClient != null) {
					SmsUtility.closeResources(httpClient);
				}
			}
		}
		
		public boolean isServerVerifyEnable() {
			return this.serverVerifyEnable;
		}
		
		public void setServerVerifyEnable(boolean serverVerifyEnable) {
			this.serverVerifyEnable = serverVerifyEnable;
		}
		
		public void initParamFromDB() {
			try {
				SmsSchedulerContext SSC_SERVER_VERIFY_DELAY_BETWEEN_CALL = SmsSchedulerContextLocalServiceUtil.fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_SERVER_VERIFY_DELAY_BETWEEN_CALL);
				SmsSchedulerContext SSC_SERVER_VERIFY_MAXERROR = SmsSchedulerContextLocalServiceUtil.fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_SERVER_VERIFY_MAXERROR);
				sscServerVerifyDelayBetweenCall = Long.valueOf(SSC_SERVER_VERIFY_DELAY_BETWEEN_CALL.getValue()); // conversione da stringa a long
				sscServerVerifyMaxError =  Long.valueOf(SSC_SERVER_VERIFY_MAXERROR.getValue()); // conversione da stringa a long
			} catch (Throwable e) {
				logger.warn("Nella creazione del SmsWebServiceServerVerify, non è stato possibile leggere/convertire i relativi parametri da DB, verranno settati i valori di default");
				
				sscServerVerifyDelayBetweenCall = SmsSchedulerContextConstants.SERVER_VERIFY_DELAY_BETWEEN_CALL;
				sscServerVerifyMaxError = SmsSchedulerContextConstants.SERVER_VERIFY_MAXERROR;
			}
		}
		
		// metodi private
		
		private boolean isServerResponseStatusOk() {
			boolean result = false;
			
			try {
				// creo httpClient con cui verranno fatte le chiamate REST, è threadSafe
				httpClient = SmsUtility.getCloseableHttpClient(120);
				httpPost = prepareHttpPostForService(USERNAME, PASSWORD, TOKEN);
				
				// +-- chiamata http
				CloseableHttpResponse response = httpClient.execute(httpPost);				
				String content = EntityUtils.toString(response.getEntity());
				
				// se true vuol dire che il server è attivo e risponde
				if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					result = true;
				} else {
					logger.error("Si è verificato qualche errore nella chiamata di verifica attività del server Telecom : status code = " + response.getStatusLine().getStatusCode()); 
				}
			} catch (UnsupportedEncodingException e) {
				logger.error(errMsg, e);
			} catch (ClientProtocolException e) {
				logger.error(errMsg, e);
			} catch (IOException e) {
				// se siamo qui il server non risponde proprio
				logger.error(errMsg, e);
			}
			
			return result;
			
		}
		
		/**
		 * Prepara la httpPost
		 * 
		 * @param username
		 * @param password
		 * @param token
		 * @param codiceOperazione
		 * @return
		 * @throws UnsupportedEncodingException 
		 * @throws ClientProtocolException
		 * @throws IOException
		 */
		private HttpPost prepareHttpPostForService(String username, String password, String token) throws UnsupportedEncodingException {
			// +-- config httpPost
			List<BasicNameValuePair> params = prepareParams(username, password, token);
			httpPost = new HttpPost(AllertaTracker.getAllertaSMSConfiguration().urlServizio() + "plafond");
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			httpPost.setHeader(HttpHeaders.ACCEPT, "application/json");
			
			return httpPost;
		}
		
		/**
		 * Prepara i parametri per la post. 
		 * 
		 * @param username
		 * @param password
		 * @param token
		 * @param codiceOperazione
		 * @return
		 */
		private List<BasicNameValuePair> prepareParams(String username, String password, String token) {		
			List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
			
			params.add(new BasicNameValuePair("username", username));
			params.add(new BasicNameValuePair("password", password));
			params.add(new BasicNameValuePair("token", token));			
			
			return params;
		}
}

