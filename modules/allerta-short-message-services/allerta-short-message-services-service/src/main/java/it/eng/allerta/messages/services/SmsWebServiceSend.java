package it.eng.allerta.messages.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.sites.kernel.util.SitesUtil;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtils;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import it.eng.allerta.messages.services.SmsWebServiceSend.SmsSendTask.Result;
import it.eng.allerta.messages.services.action.ShutdownAction;
import it.eng.allerta.messages.services.model.SmsSchedulerContext;
import it.eng.allerta.messages.services.model.impl.SmsSchedulerContextImpl;
import it.eng.allerta.messages.services.model.impl.SmsSchedulerContextImpl.SmsSchedulerState;
import it.eng.allerta.messages.services.scheduler.SmsSchedulerContextConstants;
import it.eng.allerta.messages.services.service.SmsSchedulerContextLocalService;
import it.eng.allerta.messages.services.service.SmsSchedulerContextLocalServiceUtil;
import it.eng.allerta.utils.AllertaTracker;
import it.eng.allerte.model.RubricaNominativo;
import it.eng.allerte.service.RubricaNominativoLocalServiceUtil;
import it.eng.allerte.service.impl.RubricaNominativoLocalServiceImpl;
import it.eng.allerter.model.AllertaParametro;
import it.eng.allerter.model.SMS;
import it.eng.allerter.service.AllertaParametroLocalServiceUtil;
import it.eng.allerter.service.SMSLocalService;

public class SmsWebServiceSend implements Runnable {
	
	// <inner classes>
	
	// +-- <SmsSendTaskFuture>
	public class SmsSendTaskFuture implements Future<SmsSendTask.Result> {
		
		private Future<SmsSendTask.Result> future;
		private SmsSendTask smsSendTask;
		
		
		public SmsSendTaskFuture(Future<SmsSendTask.Result> future, SmsSendTask smsSendTask) {
			this.future = future;
			this.smsSendTask = smsSendTask;
		}
		
		public SmsSendTask getSmsSendTask() {
			return smsSendTask;
		}

		@Override
		public boolean cancel(boolean mayInterruptIfRunning) {
			boolean cancel = future.cancel(mayInterruptIfRunning);
			
			try {
				smsSendTask.abort();
			} catch (Throwable t) {
				// non necessario gestire l'eccezione, esegue l'abort : va bene anche se non ci riesce (connessione già chiusa)
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
		public SmsSendTask.Result get() throws InterruptedException, ExecutionException {
			return future.get();
		}

		@Override
		public SmsSendTask.Result get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
			return future.get(timeout, unit);
		}		
	}
	// </SmsSendTaskFuture>
	
	// +-- <SmsSendTask>
	public class SmsSendTask implements Callable<SmsSendTask.Result> {
		
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
		private SMS sms; // info per l'invio degli sms
		private long sscSchedulerTaskSentDelay;
		
		// constructor
		public SmsSendTask(SMS sms, CloseableHttpClient httpClient, long sscSchedulerTaskSentDelay) throws SystemException, IllegalStateException {
			Args.notNull(sms, "l'oggetto sms non può essere null");
			Args.notNull(httpClient, "l'oggetto httpClient non può essere null");
			
			this.sms = sms;
			this.httpClient = httpClient;
			this.sscSchedulerTaskSentDelay = sscSchedulerTaskSentDelay;
			
			verifySmsAndCreateHttpPostForSend();
		}
		
		// metodi public set/get
		
		public void abort() throws IOException {
			if (httpPost != null) {
				httpPost.abort();
			}
		}

		// metodo call richiamato dal executoreService attraverso un thread dei pool
		@Override
		public Result call() throws Exception {
			int prevState = (int) sms.getStato();
			String prevDescrizione = sms.getDescrizioneErrore();
					
			try { 
				
				if (AllertaTracker.getAllertaBaseConfiguration().disableSms()) { 
					sms.setDataAck(new Date());
					sms.setDataRicevuta(new Date());
					putInDB(sms, 4, "TEST - invio simulato");
					System.out.println("TEST");
					return new SmsSendTask.Result(4, "TEST - invio simulato");
				}
								
				// salva stato
				putInDB(sms, 2, "preso in carico dal task di invio sms");				
				// invio sms con scrittura a db degli stati				
				return send(sms);
			} catch (Throwable t) {
				logger.error("errore nel task di invio SMS; id SMS = " + sms.getId(), t);
				
				// ripristina stato in caso di errore grave
				putInDB(sms, prevState, prevDescrizione);
				
				throw t;
			}
		}
		
		// metodi private
		
		private void verifySmsAndCreateHttpPostForSend() throws SystemException, IllegalStateException {			
			int stato;
			String descrizione;
			
			// controllo della blacklist
			if (isInBlackList(sms)) {
				stato = 4;
				descrizione = "Il numero " + sms.getNumero() + " è in lista nera, non procedo con l'invio";					
				sms.setDescrizioneErrore(descrizione);
				// salva stato
				putInDB(sms, stato, descrizione);
				
				throw new IllegalStateException(descrizione);
			} else {
				// pulisce il numero da eventuali spazi
				String numero = clearNumber(sms.getNumero());
				String MSISDN;
				
				// valida il numero
				if (validateNumber(numero)) {
					// se il numero è valido lo utilizza
					MSISDN = numero;
					// prepara la chiamata al servizio telecom. Se viene dal portale (numeroda="AllerteER") usa le credenziali della protezione civile.
					if (sms.getNumeroDa()!=null && sms.getNumeroDa().equals(ALIAS))
						httpPost = prepareHttpPostForService(USERNAME, PASSWORD, TOKEN, ALIAS, MSISDN, sms.getTesto());
					else {
						//viene da un sito del sindaco?
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
										//alias identico, possiamo spedire
										httpPost = prepareHttpPostForService(user, pass, token, alias, MSISDN, sms.getTesto());
									}
								}
							}
						}
					}
				} else {
					// se il numero non è valido scrive a DB il nuovo stato del SMS
					stato = 5;
					descrizione = "Non inviato, numero (MSISDN=" + numero + ") non valido";
					sms.setDescrizioneErrore(descrizione);
					// salva stato
					putInDB(sms, stato, descrizione);
					
					throw new IllegalStateException(descrizione);
				}
			}
		}
		
		private SmsSendTask.Result send(SMS sms) throws SystemException, ClientProtocolException, IOException {						
			int stato;
			String descrizione;

			Date now = new Date();
			sms.setDataInvio(now);

			if (isSendSMS()) {
			// se true caso di invio reale del SMS
				logger.info("Tento l'invio SMS con id = " + sms.getId());				
				
				CloseableHttpResponse response = null;
				
				try {
					Long timestampLastSent;
					
					if (sscSchedulerTaskSentDelay > 0) {
						timestampLastSent = lastSmsSent.get(sms.getNumero());					
						
						if (timestampLastSent != null) {						
							long deltaTime = System.currentTimeMillis() - timestampLastSent;
							
							if (deltaTime <= sscSchedulerTaskSentDelay) {							
								try {
									Thread.sleep(sscSchedulerTaskSentDelay);
								} catch (InterruptedException e) {
									// non mi interessa sapere che lo sleep è stato interrotto
								}							
							} 
						}
					}
					
					// +-- chiamata http
					response = httpClient.execute(httpPost);				
					String content = EntityUtils.toString(response.getEntity());
					
					logger.info("risposta dal servizio = " + content);
	
					// se lo status è ok (200) e la risposta json è ok
					if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK && getStatus(content, STATUS, 0).equals(STR_OK)) {
						logger.debug("SMS con id = " + sms.getId() + " per il destinatario " + sms.getDestinatario() + " inviato con successo al servizio");
						
						smsInviati++;
						
						sms.setDataAck(now);
						sms.setCodiceErrore(String.valueOf(response.getStatusLine().getStatusCode()));
						sms.setDescrizioneErrore(getStatus(content, MESSAGE, 0));
						try {
							if (sms.getDescrizioneErrore()!=null && sms.getDescrizioneErrore().length()>197) {
								sms.setDescrizioneErrore(sms.getDescrizioneErrore().substring(0, 195));
							}
						} catch (Exception exx) {}
						
						sms.setTimestamp(sms.getDescrizioneErrore().substring(sms.getDescrizioneErrore().lastIndexOf("CODE:") + 5));
						
						stato = 3;
						descrizione = "Chiamata al service di invio SMS avvenuta con successo; SMS con id = " + sms.getId();
					} else {					
						sms.setTentativi(sms.getTentativi() + 1);
						sms.setCodiceErrore(String.valueOf(response.getStatusLine().getStatusCode()));
						sms.setDescrizioneErrore(getStatus(content, MESSAGE, 0));
						
						if (sms.getTentativi() > 5) {
							stato = 5;
							descrizione = "Errore nella chiamata al service di invio SMS con id = " + sms.getId() + " al destinatario " + sms.getDestinatario() + "; tentativi superati, metto in stato " + stato;
						} else {
							stato = 1;
							descrizione = "Errore nella chiamata al service di invio SMS con id = " + sms.getId() + " al destinatario " + sms.getDestinatario() + "; invio SMS fallito : tentativo numero " + sms.getTentativi() + " ritento alla prossima schedulazione";						
						}					
						
						logger.error(descrizione);
					}					
					// salva stato
					putInDB(sms, stato, descrizione);					
					
					return new SmsSendTask.Result(stato, descrizione);
				} catch (IOException ex) {
					sms.setTentativi(sms.getTentativi() + 1);
					sms.setCodiceErrore("IOEx");
					sms.setDescrizioneErrore("IOException invio SMS");
					
					if (sms.getTentativi() > 5) {
						stato = 5;
						descrizione = "IOException nella chiamata al service di invio SMS con id = " + sms.getId() + " al destinatario " + sms.getDestinatario() + "; invio SMS fallito : tentativi superati, metto in stato " + stato;
					} else {
						stato = 1;
						descrizione = "IOException nella chiamata al service di invio SMS con id = " + sms.getId() + " al destinatario " + sms.getDestinatario() + "; invio SMS fallito : tentativo numero " + sms.getTentativi() + " ritento alla prossima schedulazione";						
					}					
					
					logger.error(descrizione);
					
					// salva stato
					putInDB(sms, stato, descrizione);
					
					return new SmsSendTask.Result(stato, descrizione);
				} finally {
					if (sscSchedulerTaskSentDelay > 0) {
						lastSmsSent.put(sms.getNumero(), System.currentTimeMillis());
					}
					
					if (response != null) {
						try {response.close();} catch (IOException e) {};						
					}
				}
			} else {
			// se false invio reale disabilitato, se sono qui è una simulazione tramite dati a DB
				stato = 1;
				descrizione = "Invio simulato";
				// salva stato
				putInDB(sms, stato, descrizione);
				
				logger.debug("Simulato invio sms : " + sms.getId() + " " + sms.getDestinatario());
				
				return new SmsSendTask.Result(stato, descrizione);
			}
		}
		
		private boolean isInBlackList(SMS theSMS) throws SystemException {
			// se esiste il parametro
			if (blacklistParam != null) {			
				String valueBlackListParam = blacklistParam.getValore();
				
				// verifica se presente
				if (valueBlackListParam!=null && !"".equals(valueBlackListParam) && valueBlackListParam.contains(theSMS.getTipo())) {				
					return true;
				}
			}
			
			return false;
		}
		
		/**
		 * Prepara la httpPost, con relativo URL e parametri annessi, per la chiamata alla API di invio messaggi.
		 * 
		 * @param username
		 * @param password
		 * @param token
		 * @param alias
		 * @param msisdn
		 * @param testo
		 * @return
		 * @throws ClientProtocolException
		 * @throws IOException
		 */
		private HttpPost prepareHttpPostForService(String username, String password, String token, String alias, String msisdn, String testo) {
			// +-- config httpPost
			MultipartEntityBuilder builder = prepareBuilder(username, password, token, alias, msisdn, testo);
			HttpPost httpPost = new HttpPost(AllertaTracker.getAllertaSMSConfiguration().urlServizio() +	"send/sms/msisdn/static/immediate/single");
			httpPost.setHeader(HttpHeaders.ACCEPT, "application/json");			
			httpPost.setEntity(builder.build());
			
			return httpPost;
		}
		
		/**
		 * Prepara i parametri per la chiamata alla API di invio messaggi.
		 * 
		 * @param username
		 * @param password
		 * @param token
		 * @param alias
		 * @param msisdn
		 * @param testo
		 * @return
		 */
		private MultipartEntityBuilder prepareBuilder(String username, String password, String token, String alias, String msisdn, String testo) {		
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			
			builder.addTextBody("username", username).
					addTextBody("password", password).
					addTextBody("token",token).
					addTextBody("alias", alias).
					addTextBody("msisdn", msisdn).
					addTextBody("testo",testo).
					addTextBody("sr", "1").
					addTextBody("vp", "1440"); //validity period 
			
			return builder;
		}

		/**
		 * Ricava lo status dal body (JSON) della response.
		 * 
		 * @param body
		 * @param campo
		 * @param level
		 * @return
		 * @throws IOException
		 * @throws IllegalStateException
		 * @throws IllegalArgumentException
		 */
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
		
		/**
		 * Verifica la validità del numero di telefono.
		 * 
		 * @param phone
		 * @return
		 */
		private boolean validateNumber(String phone) {
			//	String regex = "^([+]39)?((38[{8,9}|0])|(34[{7-9}|0])|(36[6|8|0])|(33[{3-9}|0])|(32[{8,9}]))([\\d]{7})$";
			String regex = "^[+]{1}[0-9]{5,15}";
			
			if (phone.matches(regex)) {
				return true; // Valid international phone number
			} else {
				return false; // Invalid international phone number
			}
		}

		/**
		 * Pulisce, se serve, la stringa che contiene il numero di telefono.
		 * 
		 * @param s
		 * @return
		 */
		private String clearNumber(String s) {
			if (s == null) { 
				return null;
			}		
			s = s.replace(" ", "");
			s = s.trim();			
			//	s = s.replace("0039", "+39");
			if (!s.startsWith("+")) {
				s = "+39"+s;
			}
			
			return s;
		}		
	}
	// </SmsSendTask>
	
	// <var di classe>

	private static Log logger = LogFactoryUtil.getLog(SmsWebServiceSend.class);

	private static ServiceTracker<SmsSchedulerContextLocalService, SmsSchedulerContextLocalService> _serviceTracker1;
	private static SmsSchedulerContextLocalService smsSchedulerContextLocalService;
	private static ServiceTracker<SMSLocalService, SMSLocalService> _serviceTracker2;
	private static SMSLocalService smsLocalService;
	private static Bundle bundle1;
	private static Bundle bundle2;

	static {
		bundle1 = FrameworkUtil.getBundle(SmsSchedulerContextLocalService.class);
	
		ServiceTracker<SmsSchedulerContextLocalService, SmsSchedulerContextLocalService> serviceTracker1 =
				new ServiceTracker<SmsSchedulerContextLocalService, SmsSchedulerContextLocalService>(bundle1.getBundleContext(), SmsSchedulerContextLocalService.class, null);
		serviceTracker1.open();	
		_serviceTracker1 = serviceTracker1;		
		
		bundle2 = FrameworkUtil.getBundle(SmsSchedulerContextLocalService.class);
		
		ServiceTracker<SMSLocalService, SMSLocalService> serviceTracker2 =
				new ServiceTracker<SMSLocalService, SMSLocalService>(bundle2.getBundleContext(), SMSLocalService.class, null);
		serviceTracker2.open();	
		_serviceTracker2 = serviceTracker2;
	}
	
	private static String USERNAME;
	private static String PASSWORD;
	private static String TOKEN;
	private static String ALIAS;
	
	private static final String STATUS = "status";
	private static final String MESSAGE = "message";
	private static final String STR_OK = "OK";
	
	private static AllertaParametro blacklistParam;	
	private static int smsInviati = 0;
	private static boolean enableSendSMS = false; // false non invia sms, di default li simula
	private static long sscSchedulerTaskSentDelay; // ms

	private static CloseableHttpClient httpClient = null;
	private static List<SmsSendTaskFuture> smsSendTaskFutureList = Collections.emptyList();
	private static ConcurrentHashMap<String, Long> lastSmsSent = new ConcurrentHashMap<>();

	// <contructor>
	
	public SmsWebServiceSend() throws SystemException {
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
			smsSchedulerContextLocalService = _serviceTracker1.getService();
			smsLocalService = _serviceTracker2.getService();
		} catch (Throwable e) {
			String errMsg = "Errore nella creazione del SmsWebServiceSend, impossibile creare il Runnable di invio sms";
			logger.error(errMsg, e);
			
			smsSchedulerContextLocalService.sendMailWithPlainText(errMsg);		
			
			throw e;
		}
	}
	
	// metodi get/set
	
	public static int getSmsInviati() {
		return smsInviati;
	}

	public static void setSmsInviati(int _smsInviati) {
		smsInviati = _smsInviati;
	}

	public static boolean isSendSMS() {
		return enableSendSMS;
	}

	public static void setSendSMS(boolean _enableSendSMS) {
		enableSendSMS = _enableSendSMS;
	}
	
	// metodo run che verrà eseguito dal thread di scheduling
	@Override
	public void run() {
		boolean tryDeactivate = false;
		ExecutorService executorSmsSender = null;
		
		try {
			/*
			if (SmsManagerWebServices.getInstance()==null) {
				logger.warn("schedulerSend: SmsManagerWebServices momentaneamente non disponibile");
				return;
			}
			*/			
			tryDeactivate = SmsManagerWebServices.getInstance().isSmsSchedulerStateOneOf(SmsSchedulerState.FORCE_SHUTDOWN);
			
			if (tryDeactivate) {				
				SmsManagerWebServices.getInstance().forceShutdownSchedulerSend();
				logger.info("Stop forzato dello schedulerSend tramite lo stato FORCE_SHUTDOWN settato a DB");				
			}
			
			// non sono stato interrotto (shutdownNow dall'esterno)
 			if (!Thread.currentThread().isInterrupted() && !tryDeactivate) {
				logger.debug("schedulerSend loop restarted");
				/*
				if (SMSLocalServiceUtil.getService()==null) {
					//probabilmente deploy in corso, il service non è disponibile
					logger.warn("schedulerSend: SMSLocalService momentaneamente non disponibile");
					return;
				}
				*/
				// recupero la lista degli sms da inviare
				List<Object[]> smsFromDB = smsLocalService.ottieniPerSpedizione(null, null, 0, 1, 1, -1); // non porto lo stato in 2 ma lo faccio fare al Task quando lo prende in carico effettivamente
				
				// se ci sono sms da inviare
				if (smsFromDB.size() > 0) {
					logger.info("call query ottieniPerSpedizione -> Trovati " + smsFromDB.size() + " SMS da inviare");
					
					// creazione executorService con pool di Thread che gestiranno i task SmsSendTask
					executorSmsSender = Executors.newFixedThreadPool(1);
					// creo httpClient con cui verranno fatte le chiamate REST, è threadSafe
					httpClient = SmsUtility.getCloseableHttpClient(120);					
					smsSendTaskFutureList = new LinkedList<SmsWebServiceSend.SmsSendTaskFuture>();
					
					// li invio tramite dei task che verranno presi in carico da un ExecutoreService con un Pool di Thread
					for (Object[] o : smsFromDB) {
						SMS sms = null;
						long idSms = -1;						
						tryDeactivate = SmsManagerWebServices.getInstance().isSmsSchedulerStateOneOf(SmsSchedulerState.FORCE_SHUTDOWN);
						
						try {						
							// sono stato interrotto (shutdownNow dall'esterno) ?
							if (Thread.currentThread().isInterrupted() || tryDeactivate) {
								// se sì non creo nuovi task di invio, fermo executorSmsSender ed esco dal ciclo for
								executorSmsSender.shutdownNow();
								logger.info("schdulerSend loop interrupted");
								
								break; 
							}
							// recupero del singolo sms da inviare
							idSms = Long.parseLong(o[3].toString());
							sms = smsLocalService.fetchSMS(idSms);
							
							logger.info("creo il task per SMS con id = " + sms.getId());					
							// crea il task che invierà sms :
							// se i relativi controlli non vanno a buon fine va in exception e quindi non viene eseguito dal pool di thread
							SmsSendTask smsSendTask = new SmsSendTask(sms, httpClient, sscSchedulerTaskSentDelay);
							// submit del task al executorServie
							Future<SmsSendTask.Result> future = executorSmsSender.submit(smsSendTask);
							// recupero del future del task per elaborazione futura
							smsSendTaskFutureList.add(new SmsSendTaskFuture(future, smsSendTask));
						} catch (Throwable e) {
							String errMsg = "errore imprevisto nella fase di creazione/avvio task per l'invio sms : ";
							
							if (idSms != -1) {
								errMsg = errMsg + " id SMS = " + idSms + ", " + e.getMessage();
							} else {
								errMsg = errMsg + e.getMessage();
							}
							logger.error(errMsg, e);
							
							smsSchedulerContextLocalService.sendMailWithPlainText(errMsg);						
						}
					}				
					// attesa terminazione di tutti i task				
					for (SmsSendTaskFuture smsSendTaskFuture:smsSendTaskFutureList) {
						SmsSendTask.Result result = null;
						
						try {
							result = smsSendTaskFuture.get();							
						} catch (InterruptedException e) {
							logger.warn("eccezione a causa di una interruzione del task di invio SMS in attesa della sua terminazione ", e);
						} catch (ExecutionException e) {
							logger.error("eccezione esecutiva nell'attesa della fine del task di invio SMS", e);
						} catch (Throwable t) {
							logger.error("eccezione non prevista nell'attesa della fine del task di invio SMS", t);
						}
					}				
				}
			}
		} catch (Throwable t) {
			String errMsg = "schedulerSend andato in eccezione";		
			logger.error(errMsg, t);			
			
			/*
			if (ShutdownAction.isServerShutdown()) { // perchè il server è in shutdown
				Thread.currentThread().interrupt(); // quindi mi auto interrompo
			}
			*/			
			smsSchedulerContextLocalService.sendMailWithPlainText(errMsg);
		} finally {		
			String infoMsg = "schedulerSend loop ended";
			
			if (executorSmsSender != null) {
				infoMsg = infoMsg + "; eseguo lo shutdown del executorSmsSend";
				executorSmsSender.shutdownNow();			
			}			
			executorSmsSender = null;
			
			if (httpClient != null) {
				SmsUtility.closeResources(httpClient);
			}			
			logger.debug(infoMsg); 
		}
	}
	
	public static void initParamFromDB() {		
		try {			
			SmsSchedulerContext SSC_SCHEDULER_TASK_SENT_DELAY = SmsSchedulerContextLocalServiceUtil.fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_ID_SCHEDULER_TASK_SENT_DELAY_VALUE);
			sscSchedulerTaskSentDelay = Long.valueOf(SSC_SCHEDULER_TASK_SENT_DELAY.getValue()); // conversione da stringa a long
			SmsSchedulerContext SSC_SCHEDULER_SMS_SIMULATION_SEND = SmsSchedulerContextLocalServiceUtil.fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_ID_SCHEDULER_SMS_SIMULATION_SEND);
			enableSendSMS = !Boolean.valueOf(SSC_SCHEDULER_SMS_SIMULATION_SEND.getValue());					
			blacklistParam = AllertaParametroLocalServiceUtil.fetchAllertaParametro("SMS_BLACKLIST");
			
			if (enableSendSMS) {
				logger.info("Invio SMS abilitato");
			} else {
				logger.warn("Invio SMS simulato");
			}
		} catch (Throwable e) {		 
			String errMsg = "Errore nella inizializzazione del SmsWebServiceSend: impossibile settare i parametri letti da DB, verrano utilizzati dei default";
			logger.error(errMsg, e);			
			
			sscSchedulerTaskSentDelay = SmsSchedulerContextConstants.SCHEDULER_TASK_SENT_DELAY_VALUE;
			enableSendSMS = false;
			blacklistParam = null;	
		}
	}
	
	/**
	 * Cancella tutti i task interrompendoli se necessario
	 */
	public synchronized void cancelAllTask(boolean mayInterruptIfRunning) {
		if (smsSendTaskFutureList != null && !smsSendTaskFutureList.isEmpty()) {
			for (Future<Result> smsSendTask:smsSendTaskFutureList) {
				smsSendTask.cancel(mayInterruptIfRunning);
			}
		}
		SmsUtility.closeResources(httpClient);
	}
	
	
	// metodi private
	
	private synchronized void putInDB(SMS sms, int stato, String what) throws SystemException {		
		String logMsg = "PutInDB %s -> sms id = %s, stato = %s, motivo = %s";
		
		try {
			sms.setStato(stato);
			if (sms.getDescrizioneErrore()!=null && sms.getDescrizioneErrore().length()>195)
				sms.setDescrizioneErrore(sms.getDescrizioneErrore().substring(0, 194));
			
			smsLocalService.updateSMS(sms);
			
			if (logger.isDebugEnabled()) {
				logMsg = String.format(logMsg, "success", sms.getId(), stato,  what);
				logger.debug(logMsg);
			}
		} catch (SystemException e) {
			logMsg = String.format(logMsg, "fatal error", sms.getId(), stato,  what);
			logger.error(logMsg);
						
			smsSchedulerContextLocalService.sendMailWithPlainText(logMsg);
			
			throw e;
		}		
	}

}
