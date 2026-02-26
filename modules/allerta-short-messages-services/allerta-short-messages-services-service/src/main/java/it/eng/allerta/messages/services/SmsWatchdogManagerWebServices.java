package it.eng.allerta.messages.services;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import it.eng.allerta.messages.services.model.SmsSchedulerContext;
import it.eng.allerta.messages.services.model.impl.SmsSchedulerContextImpl;
import it.eng.allerta.messages.services.scheduler.SmsSchedulerContextConstants;
import it.eng.allerta.messages.services.scheduler.SmsSchedulerContextException;
import it.eng.allerta.messages.services.service.SmsSchedulerContextLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


public class SmsWatchdogManagerWebServices {
	
	private static Log logger = LogFactoryUtil.getLog(SmsWatchdogManagerWebServices.class);
	
	private static final String BASE_MSG_SCHEDULER = "Scheduler Watchdog ";
	
	private static SmsWatchdogManagerWebServices INSTANCE;
	
	private ScheduledExecutorService schedulerWatchdog;
	private ScheduledFuture<?> scheduledFutureWatchdog;
	private SmsWebServiceWatchdog smsWebServiceWatchdog;

	private SmsWatchdogManagerWebServices() throws SmsSchedulerContextException {
		try {
			smsWebServiceWatchdog = new SmsWebServiceWatchdog();
		} catch (Throwable e) {
			String errMsg = "Errore grave, non è stato possibile creare l'oggetto che fa da Watchdog";
			
			throw new SmsSchedulerContextException(errMsg, e);
		}
	}
	
	// metodi public
	
	public static SmsWatchdogManagerWebServices getInstance() throws SmsSchedulerContextException {
		if (INSTANCE == null) {
			synchronized(SmsWatchdogManagerWebServices.class) {
				if (INSTANCE == null) {
					INSTANCE = new SmsWatchdogManagerWebServices();
				}
			}
		}
		
		return INSTANCE;
	}
	
	public synchronized ScheduledExecutorService getSchedulerWatchdog() {		
		return schedulerWatchdog;
	}
	
	public synchronized boolean tryStartWatchdog() {
		boolean tryStartSchedulerWatchdog = false;
		logger.info(BASE_MSG_SCHEDULER + " - tento l'avvio tramite metodo tryStartWatchdog sul nodo " + SmsUtility.nameJVM());
				
		// create Watchdog
		if (schedulerWatchdog == null) { // non esiste e quindi va creato
			schedulerWatchdog = Executors.newScheduledThreadPool(1);
			tryStartSchedulerWatchdog = true;
		} else {				
			if (schedulerWatchdog.isShutdown() || schedulerWatchdog.isTerminated()) { // non è attivo quindi va ricreato
				tryStartSchedulerWatchdog = true; 
				schedulerWatchdog = Executors.newScheduledThreadPool(1);
			}
		}
		
		if (!tryStartSchedulerWatchdog) {
			logger.info(BASE_MSG_SCHEDULER + " - non necessario l'avvio perchè lo scheduler di Watchdog non è ancora terminato");
		} else {
			TimeUnit sscWatchdogPeriodTimeunit = SmsSchedulerContextConstants.HEARTBEAT_PERIOD_TIMEUNIT;
			long sscWatchdogPeriodValue = SmsSchedulerContextConstants.HEARTBEAT_PERIOD_VALUE;
			SmsSchedulerContext SSC_WATCHDOG_PERIOD_TIMEUNIT;
			SmsSchedulerContext SSC_WATCHDOG_PERIOD_VALUE;
			
			// +-- leggo le costanti stringa da DB
			try {				
				SSC_WATCHDOG_PERIOD_TIMEUNIT = SmsSchedulerContextLocalServiceUtil.fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_ID_HEARTBEAT_PERIOD_TIMEUNIT);
				SSC_WATCHDOG_PERIOD_VALUE = SmsSchedulerContextLocalServiceUtil.fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_ID_HEARTBEAT_PERIOD);
							
				sscWatchdogPeriodTimeunit = TimeUnit.valueOf(SSC_WATCHDOG_PERIOD_TIMEUNIT.getValue());
				sscWatchdogPeriodValue = Long.valueOf(SSC_WATCHDOG_PERIOD_VALUE.getValue()); // conversione da stringa a long
			} catch (SystemException|NumberFormatException e) {
				logger.warn("Non è stato possibile leggere/convertire i valori WATCHDOG_PERIOD_TIMEUNIT/WATCHDOG_PERIOD_VALUE da DB, verranno settati i valori di default");
			}
			
			// avvia lo scheduler Watchdog con un ritardo pari al periodo SmsSchedulerContextConstants.HEARTBEAT_PERIOD_VALUE
			scheduledFutureWatchdog = schedulerWatchdog.scheduleWithFixedDelay(smsWebServiceWatchdog, sscWatchdogPeriodValue, sscWatchdogPeriodValue, sscWatchdogPeriodTimeunit);
			logger.info(BASE_MSG_SCHEDULER + " - avvio scheduler Watchdog avvenuto con successo");
		}		

		return tryStartSchedulerWatchdog;
	}
	
	public synchronized boolean tryShutdownWatchdog() {
		String logMsg = null;
		boolean isWatchdogShutdown = false;
		logger.info(BASE_MSG_SCHEDULER + " - tento lo shutdownNow tramite metodo tryShutdownWatchdog sul nodo " + SmsUtility.nameJVM());
		
		// controlla se è attivo
		if (schedulerWatchdog != null && 
			!(isWatchdogShutdown = schedulerWatchdog.isTerminated()) && !(isWatchdogShutdown = schedulerWatchdog.isShutdown())) 
		{
			schedulerWatchdog.shutdownNow();
			scheduledFutureWatchdog.cancel(true);
			isWatchdogShutdown = schedulerWatchdog.isShutdown();
			logMsg = " shutdown dello scheduler Watchdog avvenuto con successo ";
		} else {
			isWatchdogShutdown = true;
			logMsg = " non è attivo lo scheduler Watchdog, lo shutdown non serve";
		}
		
		String infoMsg = BASE_MSG_SCHEDULER + " - risultato del metodo tryShutdownWatchdog sul nodo " + SmsUtility.nameJVM() + " : " + logMsg;
		logger.info(infoMsg);
		
		return isWatchdogShutdown;
	}
	
	public synchronized boolean isWatchdogTerminated() {		
		return (schedulerWatchdog != null) ? schedulerWatchdog.isTerminated() : true;
	}
	
	public synchronized boolean isWatchdogShutdown() {		
		return (schedulerWatchdog != null) ? schedulerWatchdog.isShutdown() : true;
	}
	
	// metodi default
	
	boolean forceShutdownWatchdog() {
		if (scheduledFutureWatchdog == null) {
			return false;
		}
		if (schedulerWatchdog != null) {
			schedulerWatchdog.shutdownNow(); // fa lo shutdown dell'istanza corrente del thread in esecuzione ma non dello scheduler
		}
		
		return scheduledFutureWatchdog.cancel(true); // termina il thread dello scheduler 
	}

}
