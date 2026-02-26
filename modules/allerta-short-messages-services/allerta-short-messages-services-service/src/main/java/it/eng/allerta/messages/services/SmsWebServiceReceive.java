package it.eng.allerta.messages.services;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtils;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;

import it.eng.allerta.messages.services.SmsWebServiceReceive.SmsReceiveTask.Result;
import it.eng.allerta.messages.services.action.ShutdownAction;
import it.eng.allerta.messages.services.model.impl.SmsSchedulerContextImpl.SmsSchedulerState;
import it.eng.allerta.messages.services.service.SmsSchedulerContextLocalService;
import it.eng.allerta.utils.AllertaTracker;
import it.eng.allerte.model.RubricaNominativo;
import it.eng.allerte.service.RubricaNominativoLocalServiceUtil;
import it.eng.allerter.model.SMS;
import it.eng.allerter.service.SMSLocalService;

public class SmsWebServiceReceive implements Runnable {
	
	// <inner classes>
	
	// +-- <SmsReceiveTaskFuture>
	public class SmsReceiveTaskFuture implements Future<SmsReceiveTask.Result> {
		
		private Future<SmsReceiveTask.Result> future;
		private SmsReceiveTask smsReceiveTask;
		
		public SmsReceiveTaskFuture(Future<SmsReceiveTask.Result> future, SmsReceiveTask smsReceiveTask) {
			this.future = future;
			this.smsReceiveTask = smsReceiveTask;
		}

		@Override
		public boolean cancel(boolean mayInterruptIfRunning) {
			boolean cancel = future.cancel(mayInterruptIfRunning);
			
			try {
				smsReceiveTask.abort();
			} catch (Throwable t) {
				// non necessario gestire l'eccezione, se esegue l'abort va bene se non ci riesce va bene comunque
			}
			
			return cancel;
		}

		@Override
		public boolean isCancelled() {
			return future.isCancelled();
		}

		@Override
		public boolean isDone() {
			return future.isDone();
		}

		@Override
		public SmsReceiveTask.Result get() throws InterruptedException, ExecutionException {
			return future.get();
		}

		@Override
		public SmsReceiveTask.Result get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
			return future.get(timeout, unit);
		}		
	}
	// </SmsReceiveTaskFuture>
	
	// +-- <SmsSendTask>
	public class SmsReceiveTask implements Callable<SmsReceiveTask.Result> {
		
		public class Result {
			public final int stato;
			public final String descrizione;
			
			public Result(int stato, String descrizione) {
				this.stato = stato;
				this.descrizione = descrizione;
			}
		}
		
		// var di classe	
		private CloseableHttpClient httpClient; // client http per eseguire le chiamate al server
		private HttpPost httpPost;
		private SMS sms; // info per la verifica degli sms
		
		// constructor
		public SmsReceiveTask(SMS sms, CloseableHttpClient httpClient) throws SystemException, ClientProtocolException, IllegalStateException, IOException {
			Args.notNull(sms, "l'oggetto sms non può essere null");
			Args.notNull(httpClient, "l'oggetto httpClient non può essere null");
			
			this.sms = sms;
			this.httpClient = httpClient;
			
			verifySmsAndCreateHttpPostForReceive();
		}
		
		// metodi public set/get
		
		public void abort() {
			if (httpPost != null) {
				httpPost.abort();
			}
		}

		@Override
		public Result call() throws Exception {			
			int prevState = (int) sms.getStato();
			String prevDescrizione = sms.getDescrizioneErrore();
					
			try {
				// salva stato
				putInDB(sms, 6, "preso in carico dal task di verifica invio sms");		
				// verifica notifica sms con scrittura a db degli stati				
				return receive(sms);
			} catch (Throwable t) {
				logger.error("Errore nel task di verifica invio SMS; id SMS = " + sms.getId(), t);
				
				// ripristina stato in caso di errore grave
				putInDB(sms, prevState, prevDescrizione);
				
				throw t;
			}
		}
		
		// metodi private
		
		private void verifySmsAndCreateHttpPostForReceive() throws SystemException, IllegalStateException, UnsupportedEncodingException {			
			int stato;
			String descrizione;	
			long diff = new Date().getTime() - sms.getDataInvio().getTime();
			
			if (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) > 3) {
				stato = 7;
				descrizione = "Son passati tre giorni dall'invio, interrompo la richiesta di verifica invio";
				// salva stato
				putInDB(sms, stato, descrizione);
				
				throw new IllegalStateException(descrizione);
			}
			
			String codiceOperazione = sms.getTimestamp();
			// prepara la chiamata al servizio telecom
			if (sms.getNumeroDa()!=null && sms.getNumeroDa().equals(ALIAS)) {
				httpPost = prepareHttpPostForService(USERNAME, PASSWORD, TOKEN, codiceOperazione);
			} else {
				//sms del sindaco, non funziona se chiediamo la ricevuta con le credenziali dell'agenzia
				if (sms.getNumeroDa()!=null && sms.getDestinatario()>0) {
					RubricaNominativo rn = RubricaNominativoLocalServiceUtil.fetchRubricaNominativo(sms.getDestinatario());
					//potrebbe non esistere, se il destinatario � un id utente Liferay e non un nominativo di rubrica. In questo
					//caso nessun problema, perch� questi non dovremmo nemmeno mandarli con un account del sindaco.
					//controlliamo per� che il sito della rubrica abbia un alias Telecom che fa match con il numeroDa.
					if (rn!=null) {
						long sito = rn.getFK_SITO_PROPRIETARIO();
						Group g = GroupLocalServiceUtil.fetchGroup(sito);
						if (g!=null) {
							Map<String,Serializable> m = g.getExpandoBridge().getAttributes();
							String user = (String)m.get("Telecom Username");
							String pass = (String)m.get("Telecom Password");
							String token = (String)m.get("Telecom Token");
							String alias = (String)m.get("Telecom Alias");
							if (alias!=null && alias.equals(sms.getNumeroDa())) {
								//alias identico, possiamo procedere
								httpPost = prepareHttpPostForService(user, pass, token, codiceOperazione);
							}
						}
					}
				}
			}
		}
		
		private SmsReceiveTask.Result receive(SMS sms) throws SystemException, ClientProtocolException, IOException, IllegalStateException {			
			int stato;
			String descrizione;			
			CloseableHttpResponse response = null;
			
			try {
				// +-- chiamata http
				response = httpClient.execute(httpPost);				
				String content = EntityUtils.toString(response.getEntity());
				
				//logger.info("risposta dal servizio di verifica invio = " + content);
				
				// se lo status è ok (200) e la risposta json è ok
				if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK && getStatus(content, STATUS, 0).equals(STR_OK)) {					
					String date = getStatus(content, DATA_RICEZIONE, 1);
					String esito = getStatus(content, ESITO, 1);
					
					// sms non è stato ricevuto ma la data non è valorizzata quindi non sono proprio sicuro che non sia stato ricevuto
					// TODO : che condizione strana !!! Verificare
					if (esito.equals(NONRICEVUTO) && (date.equalsIgnoreCase("") || date.equalsIgnoreCase(ND))) {
						stato = 3;
						descrizione = "Esito : forse non ricevuto perchè data non presente";
						// salva stato
						putInDB(sms, 3, descrizione);
						
						return new SmsReceiveTask.Result(stato, descrizione);
					}
					// se la data della ricevuta di ritorno è valorizzata
					if (!date.equalsIgnoreCase(ND) && !date.equalsIgnoreCase("")) {
						Date parse;
						// verifica la correttezza della data
						try {
							SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							parse = formatter.parse(date);
						} catch (java.text.ParseException e) {
						// se ci sono errori
							stato = 5;
							descrizione = "Errore nel parsing della data di ricezione del sms";
							logger.error(descrizione, e);
							
							putInDB(sms, 5, descrizione);							
							// SmsUtility.sendMailWithPlainText(descrizione + " -> " + e.getMessage());
							
							return new SmsReceiveTask.Result(stato, descrizione);
						}
						
						// se non ci sono errori nella data salva stato dopo le opportune verifiche						
						sms.setDataRicevuta(parse);
						sms.setCodiceErrore(String.valueOf(response.getStatusLine().getStatusCode()));
						sms.setDescrizioneErrore(getStatus(content, MESSAGE, 0));
						
						// da qui in poi la data non ha errori ed è presente
						
						// msg non ricevuto
						if (esito.equals(NONRICEVUTO)) {
							stato = 7;
							descrizione = "Esito: sms non ricevuto, data presente";
							logger.info("risposta dal servizio di verifica invio = " + content);
						// msg ricevuto
						} else if (esito.equals(RICEVUTO)) {
							stato = 4;
							descrizione = "Esito: sms ricevuto, data presente";							
							logger.info("risposta dal servizio di verifica invio = " + content);
						} else {
						// caso non definito
							stato = 3;
							descrizione = "Esito : ND, non sono entrato in alcuna casistica";							
						}
						putInDB(sms, stato, descrizione);
						
						return new SmsReceiveTask.Result(stato, descrizione);						
					} else {
						stato = 3;
						descrizione = "Il campo data ricevuto non è valorizzato";
						
						putInDB(sms, stato, descrizione);
						
						return  new SmsReceiveTask.Result(stato, descrizione);
					}
				} else {
					stato = 3;
					descrizione = "Errore nella verifica invio SMS (status <> 200)";
					sms.setCodiceErrore(String.valueOf(response.getStatusLine().getStatusCode()));
					sms.setDescrizioneErrore(getStatus(content, MESSAGE, 0));
					
					putInDB(sms, stato, descrizione);
					
					return new SmsReceiveTask.Result(stato, descrizione);
				}
			} catch (IOException ex) {
				stato = 3;
				descrizione = "IOException nella chiamata al service di verifica invio SMS con id = " + sms.getId() + " al destinatario " + sms.getDestinatario();		
				sms.setCodiceErrore("IOEx");
				sms.setDescrizioneErrore("IOException verifica invio");							
				
				logger.error(descrizione);
				
				// salva stato
				putInDB(sms, stato, descrizione);
				
				return new SmsReceiveTask.Result(stato, descrizione);
			} catch (Throwable e) {
				stato = 3;
				descrizione = "Errore imprevisto nella verifica invio sms";				
				logger.error(descrizione, e);
				
				smsSchedulerContextLocalService.sendMailWithPlainText(descrizione + " -> " + e.getMessage());
				putInDB(sms, stato, descrizione);			
				
				return new SmsReceiveTask.Result(stato, descrizione);
			} finally {
				if (response != null) {
					try {response.close();} catch (IOException e) {};						
				}
			}
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
		private HttpPost prepareHttpPostForService(String username, String password, String token, String codiceOperazione) throws UnsupportedEncodingException {
			// +-- config httpPost
			List<BasicNameValuePair> params = prepareParams(username, password, token, codiceOperazione);
			httpPost = new HttpPost(AllertaTracker.getAllertaSMSConfiguration().urlServizio() + "search");
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
		private List<BasicNameValuePair> prepareParams(String username, String password, String token, String codiceOperazione) {		
			List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
			
			params.add(new BasicNameValuePair("username", username));
			params.add(new BasicNameValuePair("password", password));
			params.add(new BasicNameValuePair("token", token));
			params.add(new BasicNameValuePair("codiceOperazione", codiceOperazione));
			params.add(new BasicNameValuePair("numeroRicorrenza", "0"));
			params.add(new BasicNameValuePair("offset", "1"));
			params.add(new BasicNameValuePair("limit", "2"));
			
			return params;
		}
		
		private String getStatus(String body, String campo, int level) throws IOException, IllegalStateException, IllegalArgumentException {
			final String msgError = "Impossibile recuperare lo status";
			
			if (body!=null && !"".equals(body)) {
				if (level == 0) {
					try {
						ObjectMapper mapper = new ObjectMapper();
						JsonNode root = mapper.readTree(body);
						
						return root.path(campo).textValue();
					} catch (IOException e) {
						logger.error(msgError, e);
						
						throw e;
					}
				} else if (level == 1) {
					try {
						ObjectMapper mapper = new ObjectMapper();
						JsonNode root = mapper.readTree(body).get("items");
						
						if (root.isArray()) {
							return root.get(0).path(campo).textValue();
						} else {
							throw new IllegalStateException("Impossibile valutare lo status, il root JsonNode non è un Array");
						}
					} catch (IOException e) {
						logger.error(msgError, e);
						
						throw e;
					}
				} else {
					throw new IllegalArgumentException("Impossibile valutare lo status, il level non è tra quelli disponibili");
				}
			} else {
				throw new IllegalArgumentException("Impossibile valutare lo status, il body della response non è valorizzato");
			}
		}
	}
	
	// <var di classe>

	private static Log logger = LogFactoryUtil.getLog(SmsWebServiceReceive.class);
	
	private static ServiceTracker<SmsSchedulerContextLocalService, SmsSchedulerContextLocalService> _serviceTrackerSmsSchedulerContext;
	private static SmsSchedulerContextLocalService smsSchedulerContextLocalService;
	private static ServiceTracker<SMSLocalService, SMSLocalService> _serviceTrackerSMS;
	private static SMSLocalService smsLocalService;
	private static Bundle bundle1,bundle2;

	static {
		bundle1 = FrameworkUtil.getBundle(SmsSchedulerContextLocalService.class);
	
		ServiceTracker<SmsSchedulerContextLocalService, SmsSchedulerContextLocalService> serviceTracker1 =
				new ServiceTracker<SmsSchedulerContextLocalService, SmsSchedulerContextLocalService>(bundle1.getBundleContext(), SmsSchedulerContextLocalService.class, null);
		serviceTracker1.open();	
		_serviceTrackerSmsSchedulerContext = serviceTracker1;
		
		bundle2 = FrameworkUtil.getBundle(SMSLocalService.class);
		
		ServiceTracker<SMSLocalService, SMSLocalService> serviceTracker2 =
				new ServiceTracker<SMSLocalService, SMSLocalService>(bundle2.getBundleContext(), SMSLocalService.class, null);
		serviceTracker2.open();	
		_serviceTrackerSMS = serviceTracker2;
	}
		
	private static String USERNAME;
	private static String PASSWORD;
	private static String TOKEN;
	private static String ALIAS;
	
	private static final String RICEVUTO = "Ricevuto";
	private static final String NONRICEVUTO = "Non Ricevuto";
	private static final String DATA_RICEZIONE = "dataRicezione";
	private static final String ESITO = "esito";
	private static final String ND = "n/d";	
	private static final String STATUS = "status";
	private static final String MESSAGE = "message";
	private static final String STR_OK = "OK";
	
	private static CloseableHttpClient httpClient = null;
	private static List<SmsReceiveTaskFuture> smsReceiveTaskFutureList = Collections.emptyList();

	// <contructor>
	
	public SmsWebServiceReceive() throws SystemException {
		try {
			/*
			USERNAME = AuthLocalServiceUtil.fetchAuth("USERNAME").getValue();
			PASSWORD = AuthLocalServiceUtil.fetchAuth("PASSWORD").getValue();
			TOKEN = AuthLocalServiceUtil.fetchAuth("TOKEN").getValue();
			ALIAS = AuthLocalServiceUtil.fetchAuth("ALIAS").getValue();
			
			USERNAME = "AllertaMeteo2019";
			PASSWORD = "Meteo-TIM-2019";
			TOKEN = "249060EE1B4E52A3A33DC55840A8848418047584";
			ALIAS = "AllerteER";*/
			
			USERNAME = AllertaTracker.getAllertaSMSConfiguration().username();
			PASSWORD = AllertaTracker.getAllertaSMSConfiguration().password();
			TOKEN = AllertaTracker.getAllertaSMSConfiguration().token();
			ALIAS = AllertaTracker.getAllertaSMSConfiguration().alias();
			smsSchedulerContextLocalService = _serviceTrackerSmsSchedulerContext.getService();
			smsLocalService = _serviceTrackerSMS.getService();
		} catch (Throwable e) {
			String errMsg = "Errore nella creazione del SmsWebServiceReceive, impoosibile creare il Runnable di verifica ricezione sms";
			logger.error(errMsg, e);
			
			smsSchedulerContextLocalService.sendMailWithPlainText(errMsg);		
			
			throw e;
		}
	}

	// metodo run che verrà eseguito dal thread di scheduling
	@Override
	public void run() {
		boolean tryDeactivate = false;
		ExecutorService executorSmsReceive = null;
		
		try {
			/*
			if (SmsManagerWebServices.getInstance()==null) {
				logger.warn("schedulerReceive: SmsManagerWebServices momentaneamente non disponibile");
				return;
			}
			*/
			tryDeactivate = SmsManagerWebServices.getInstance().isSmsSchedulerStateOneOf(SmsSchedulerState.FORCE_SHUTDOWN);
			
			if (tryDeactivate) {				
				SmsManagerWebServices.getInstance().forceShutdownSchedulerReceive();
				logger.info("Stop forzato dello schedulerReceive tramite lo stato FORCE_SHUTDOWN settato a DB");
			}
			
			// non sono stato interrotto (shutdownNow dall'esterno)
			if (!Thread.currentThread().isInterrupted() && !tryDeactivate) {
				logger.debug("schedulerReceive loop restarted");				
				/*
				if (SMSLocalServiceUtil.getService()==null) {
					//probabilmente deploy in corso, il service non è disponibile
					logger.warn("schedulerReceive: SMSLocalService momentaneamente non disponibile");
					return;
				}
				*/				
				// recupero la lista degli sms per cui verificare la notifica di invio
				List<Object[]> smsFromDB = smsLocalService.ottieniPerSpedizione(null, null, 0, 3, 3, -1);	// non lo porto in stato 6, lo fa il Task che lo prende effettivamente in carico			
				
				// se ci sono sms da verificare
				if (smsFromDB.size() > 0) {
					//logger.info("call query ottieniPerSpedizione -> Trovati " + smsFromDB.size() + " SMS da verificare il relativo invio");
					
					// creazione executorService con pool di Thread che gestiranno i task SmsReceiveTask
					executorSmsReceive = Executors.newFixedThreadPool(4);
					// creo httpClient con cui verranno fatte le chiamate REST, è threadSafe
					httpClient = SmsUtility.getCloseableHttpClient(120);					
					smsReceiveTaskFutureList = new LinkedList<SmsWebServiceReceive.SmsReceiveTaskFuture>();
					
					// li controllo tramite dei task che verranno presi in carico da un ExecutoreService con un Pool di Thread
					for (Object[] o : smsFromDB) {						
						SMS sms = null;
						long idSms = -1;
						tryDeactivate = SmsManagerWebServices.getInstance().isSmsSchedulerStateOneOf(SmsSchedulerState.FORCE_SHUTDOWN);
						
						try {
							// sono stato interrotto (shutdownNow dall'esterno) ?
							if (Thread.currentThread().isInterrupted() || tryDeactivate) {
								// se non creo nuovi task di invio ed esco dal ciclo for
								executorSmsReceive.shutdownNow();
								logger.warn("schedulerReceive loop interrupted");
								
								break;
							}
							// recupero del singolo sms da inviare
							idSms = Long.parseLong(o[3].toString());
							sms = smsLocalService.fetchSMS(idSms);
							
							//logger.debug("creo il task per SMS con id = " + sms.getId());					
							// crea il task che invierà sms
							// se i relativi controlli non vanno a buon fine va in exception e quindi non viene eseguito dal pool di thread
							SmsReceiveTask smsReceiveTask = new SmsReceiveTask(sms, httpClient);
							// submit del task al executorServie
							Future<SmsReceiveTask.Result> future = executorSmsReceive.submit(smsReceiveTask);
							// recupero del future del task per elaborazione futura
							smsReceiveTaskFutureList.add(new SmsReceiveTaskFuture(future, smsReceiveTask));						
						} catch (Throwable e) {
							// prepara errore							
							String errMsg = "errore imprevisto nella fase di creazione/avvio task per la verifica sms : ";
							
							if (idSms != -1) {
								errMsg = errMsg + " id SMS = " + idSms + ", " + e.getMessage();
							} else {
								errMsg = errMsg + e.getMessage();
							}
							logger.error(errMsg, e);
							// invia email con errore
							smsSchedulerContextLocalService.sendMailWithPlainText(errMsg);				
						}
					}				
					// attesa terminazione di tutti i task					
					for (SmsReceiveTaskFuture smsReceiveTaskFuture:smsReceiveTaskFutureList) {
						SmsReceiveTask.Result result = null;
						
						try {
							result = smsReceiveTaskFuture.get();							
						} catch (InterruptedException e) {
							logger.warn("eccezione a causa di una interruzione del task di verifica invio SMS in attesa della sua terminazione", e);
						} catch (ExecutionException e) {
							logger.error("eccezione esecutiva nell'attesa della fine del task di verifica invio SMS", e);
						} catch (Throwable t) {
							logger.error("eccezione non prevista nell'attesa della fine del task di verifica invio SMS", t);
						}
					}
				} else {
					//pulisci il db dagli eventuali messaggi rimasti in sospeso
					int smsTimeout = smsLocalService.marcaMessaggiInTimeout();
					
					if (smsTimeout > 0) { 
						logger.info("Marcati " + smsTimeout + " SMS come falliti per timeout");
					}
				}
			}
		} catch (Throwable t) {
			String errMsg = "schedulerReceive andato in eccezione";			
			logger.error(errMsg, t);			
			
			/*
			if (ShutdownAction.isServerShutdown()) { // perchè il server è in shutdown
				Thread.currentThread().interrupt(); // quindi mi auto interrompo
			}
			*/			
			smsSchedulerContextLocalService.sendMailWithPlainText(errMsg);
		} finally {
			String infoMsg = "schedulerReceive loop ended";
			
			if (executorSmsReceive != null) {
				infoMsg = infoMsg + "; eseguo lo shutdown del executorSmsReceive";
				executorSmsReceive.shutdownNow();				
			}
			executorSmsReceive = null;
			
			if (httpClient != null) {
				SmsUtility.closeResources(httpClient);
			}
			logger.debug(infoMsg);
		}		
	}
	
	/**
	 * Cancella tutti i task interrompendoli se necessario
	 */
	public synchronized void cancelAllTask(boolean mayInterruptIfRunning) {
		if (smsReceiveTaskFutureList != null && !smsReceiveTaskFutureList.isEmpty()) {
			for (Future<Result> smsReceiveTask:smsReceiveTaskFutureList) {
				smsReceiveTask.cancel(mayInterruptIfRunning);
			}
		}
		
		SmsUtility.closeResources(httpClient);
	}
	
	
	// metodi private
	
	private void putInDB(SMS sms, int stato, String what) throws SystemException {	
		try {
			
			
			if (sms.getStato()==6 && stato==3 && sms.getDataAck()!=null) {
				long tempoTrascorso = new Date().getTime() - sms.getDataAck().getTime();
				if (tempoTrascorso>72*3600*1000) {
					stato = 5;
					what = "Nessuna ricevuta 72 ore dopo l'invio";
				}
			}
			
			sms.setStato(stato);
			sms.setDescrizioneErrore(what);
			
			if (sms.getDescrizioneErrore()!=null && sms.getDescrizioneErrore().length()>195)
				sms.setDescrizioneErrore(sms.getDescrizioneErrore().substring(0, 194));
			
			smsLocalService.updateSMS(sms);
		} catch (SystemException e) {
			String logMsg = String.format("PutInDB %s -> sms id = %s, stato = %s, motivo = %s", "fail", sms.getId(), stato,  what);
			logger.error(logMsg);
			
			smsSchedulerContextLocalService.sendMailWithPlainText(logMsg);

			throw e;
		}
	}
}
