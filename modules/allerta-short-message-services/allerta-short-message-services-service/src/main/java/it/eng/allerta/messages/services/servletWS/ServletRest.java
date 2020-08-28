package it.eng.allerta.messages.services.servletWS;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.util.Asserts;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import it.eng.allerta.messages.services.SmsManagerWebServices;
import it.eng.allerta.messages.services.SmsUtility;
import it.eng.allerta.messages.services.SmsWatchdogManagerWebServices;
import it.eng.allerta.messages.services.action.StartupAction;
import it.eng.allerta.messages.services.model.impl.SmsSchedulerContextImpl.SmsSchedulerState;
import it.eng.allerta.messages.services.scheduler.SmsSchedulerContextException;
import it.eng.allerta.messages.services.scheduler.SmsSchedulerContextUtility;
import it.eng.allerta.messages.services.service.SmsSchedulerContextLocalService;
import it.eng.allerter.service.SMSLocalService;

import com.google.gson.Gson;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.util.PortalUtil;


/**
 * Servlet implementation class ServletRest
 */
/*@WebServlet(
		loadOnStartup = 1,
		urlPatterns = { 
			"/ServletRestWS"
		}, 
		initParams = { 
			@WebInitParam(name = "user", value = "admin", description = "d")
		})
@WebFilter()*/
@Component(
    //immediate = true,  
	immediate = false,
    property = {
        "osgi.http.whiteboard.context.path=/",
        "osgi.http.whiteboard.servlet.pattern=/ServletRestWS"
    },
    service = Servlet.class
)
public class ServletRest extends HttpServlet implements Filter {
	
	private static final long serialVersionUID = 5174216455126302695L;
	
	private static Log logger = LogFactoryUtil.getLog(ServletRest.class);

	//@Reference(cardinality=ReferenceCardinality.MANDATORY)
	//SmsSchedulerContextLocalService smsScheduler;
	
	//@Reference(cardinality=ReferenceCardinality.MANDATORY)
	//SMSLocalService smsService;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletRest() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		/*
		logger.warn(this.getClass().getName() + " INIT");
		
		try {
			runStartupAction(new String[] {"20154"}); 
		} catch (Exception e) {
			logger.error(e);
		}
		*/		
	}
	
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		String password = request.getParameter("password");
		
		if (password.equals("admin")) {
			chain.doFilter(request, response); //sends request to next resource  
		} else {  
			out.print("username or password error!");  
			RequestDispatcher rd = request.getRequestDispatcher("index.html");  
			rd.include(request, response);  
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SmsManagerWebServices smsManagerWebServices;
		
		try {
			smsManagerWebServices = SmsManagerWebServices.getInstance();
		} catch (Exception e) {
			throw new ServletException("Errore grave, non è stato possibile recuperare l'istanza di SmsManagerWebServices", e);
		}
		
		String methodName = (String) request.getParameter("method_name");
		String callback = (String) request.getParameter("callback");
		String node_ip = (String) request.getParameter("node_ip");		
		
		Asserts.notNull(methodName, "il methodName non deve essere null");
		Asserts.notNull(callback, "il callback non deve essere null");
		Asserts.notNull(node_ip, "il node_ip non deve essere null");
		
		String logMsg = "Invocato metodo " + methodName + " da " + node_ip + " con esito ";
		Map<String,String> myMap = new HashMap<>();
		boolean isOk = true;
		SmsSchedulerState ssc;
		
		try {
			switch (methodName) {
				// <actions>
				case "tryStartScheduler":
					ssc = smsManagerWebServices.tryStartScheduler();
					boolean isSchedulerStarted = ssc.equals(SmsSchedulerState.STARTED);
					myMap.put("isSchedulerStarted", String.valueOf(isSchedulerStarted));
					
					break;
				case "tryShutdownScheduler":
					ssc = smsManagerWebServices.tryShutdownScheduler();
					boolean isSchedulerShutdown = ssc.equals(SmsSchedulerState.SHUTDOWN) || ssc.equals(SmsSchedulerState.FORCE_SHUTDOWN);
					myMap.put("isSchedulerShutdown", String.valueOf(isSchedulerShutdown));
					
					break;
				case "toggleSendOrSimulateSMS":					
					myMap.put("isSendSMS", String.valueOf(smsManagerWebServices.toggleSendOrSimulateSMS()));
					
					break;
				case "toggleVerifyIfServerIsEnable":
					myMap.put("isServerVerifyEnable", String.valueOf(smsManagerWebServices.toggleVerifyIfServerIsEnable()));
					
					break;
					
				// <properties contenute in InfoWS>
				case "nameJVM":
					myMap.put("nameJVM", String.valueOf(smsManagerWebServices.nameJVM()));
			
					break;
				case "getSmsInviati":
					myMap.put("smsInviati", String.valueOf(smsManagerWebServices.getSmsInviati()));
				
					break;
					
				case "isSendSMS":
					myMap.put("isSendSMS", String.valueOf(smsManagerWebServices.isSendSMS()));
					
					break;
				case "isServerVerifyEnable":
					myMap.put("isServerVerifyEnable", String.valueOf(smsManagerWebServices.isServerVerifyEnable()));
					
					break;
					
				case "isSchedulerTerminated":
					myMap.put("isSchedulerTerminated", String.valueOf(smsManagerWebServices.isSchedulerTerminated()));
					
					break;
				case "isNotSchedulerTerminated":
					myMap.put("isNotSchedulerTerminated", String.valueOf(!smsManagerWebServices.isSchedulerTerminated()));
					
					break;
				case "isSchedulerShutdown":
					myMap.put("isSchedulerShutdown", String.valueOf(smsManagerWebServices.isSchedulerShutdown()));
					
					break;
				case "isNotSchedulerShutdown":
					myMap.put("isNotSchedulerShutdown", String.valueOf(!smsManagerWebServices.isSchedulerShutdown()));
					
					break;
					
				case "isSchedulerSendTerminated":
					myMap.put("isSchedulerSendTerminated", String.valueOf(smsManagerWebServices.isSchedulerSendTerminated()));
					
					break;
				case "isSchedulerReceiveTerminated":
					myMap.put("isSchedulerReceiveTerminated", String.valueOf(smsManagerWebServices.isSchedulerReceiveTerminated()));
				
					break;
				case "isSchedulerSendShutdown":
					myMap.put("isSchedulerSendShutdown", String.valueOf(smsManagerWebServices.isSchedulerSendShutdown()));
				
					break;
				case "isSchedulerReceiveShutdown":
					myMap.put("isSchedulerReceiveShutdown", String.valueOf(smsManagerWebServices.isSchedulerReceiveShutdown()));
				
					break;					
				case "getLog":
					myMap.put("text", smsManagerWebServices.getLog());
					
					break;
					
				case "getInfo":					
					int localPort = request.getLocalPort();
					String scheme = request.getScheme();
					String myNodo = scheme+"://"+node_ip+":"+localPort;
					
					myMap.put("myIp", myNodo);
					myMap.put("nameJVM", smsManagerWebServices.nameJVM());
					myMap.put("smsInviati", String.valueOf(smsManagerWebServices.getSmsInviati()));
					
					myMap.put("isSendSMS", String.valueOf(smsManagerWebServices.isSendSMS()));
					myMap.put("isServerVerifyEnable", String.valueOf(smsManagerWebServices.isServerVerifyEnable()));
					myMap.put("isSchedulerTerminated", String.valueOf(smsManagerWebServices.isSchedulerTerminated()));
					myMap.put("isSchedulerShutdown", String.valueOf(smsManagerWebServices.isSchedulerShutdown()));					
					myMap.put("isShutdownSend", String.valueOf(smsManagerWebServices.isSchedulerSendShutdown()));
					myMap.put("isShutdownReceive", String.valueOf(smsManagerWebServices.isSchedulerReceiveShutdown()));
					myMap.put("isTerminatedSend", String.valueOf(smsManagerWebServices.isSchedulerSendTerminated()));
					myMap.put("isTerminatedReceive", String.valueOf(smsManagerWebServices.isSchedulerReceiveTerminated()));					
					
					myMap.put("getLog", smsManagerWebServices.getLog());
					
					break;
				default:
					logger.error("il metodo " + methodName + " richiamato non è tra quelli disponibili");
					isOk = false;
					
					break;
			}
			
			if (isOk) {
				myMap.put("result", "ok");
				logger.debug(logMsg + "positivo");
			} else {
				myMap.put("result", "ko");
				logger.debug(logMsg + "negativo");
			}
		} catch (Throwable t) {
			myMap.put("result", "ko");
			
			logger.error(logMsg + "negativo", t);
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(myMap);
		
		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType("application/javascript");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(callback+"("+json+")");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doOptions(HttpServletRequest, HttpServletResponse)
	 */
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	/*
	public void runStartupAction(String[] companyIds) throws ActionException {
		// Info company
		Long currentCompanyId = CompanyThreadLocal.getCompanyId();
		logger.info("Startup Portlet - current company id = " + currentCompanyId);
		
		for (String companyId:companyIds) {
			logger.info("Startup Portlet - company id = " + companyId);
		}
		
		// Info Host
		String infoHost = null;
		String hostIp = "unknown";
		String port = "";
		String nodeId = "unknown";
		
		try {
			nodeId = SmsUtility.getCurrentClusterId();
			hostIp = SmsUtility.getCurrentHostIp();
			port = SmsUtility.getCurrentHostPort();
			
			infoHost = System.lineSeparator() +
					   "Startup Portlet" + System.lineSeparator() +
					   "Computer name = " + PortalUtil.getComputerName() + System.lineSeparator() +
					   "Node id = " + nodeId + System.lineSeparator() +
					   "Node IP:Port = " + hostIp + ":" + port + System.lineSeparator();
		} catch (SystemException e) {
			logger.error("Startup Portlet - non è stato possibile recuperare info sul host", e);
		}
		if (infoHost != null) {
			logger.info(infoHost);
		}
		
		try {
			// se lo scheduler risulta morto all'avvio della portlet (ne posso avere piè di una attiva nei vari nodi) allora
			// prova a diventare lo scheduler
			if (SmsSchedulerContextUtility.ifDeadTryToBecomeScheduler(hostIp, port)) {
				// dato che ragionevolmente è morto, eseguo il reset dello stato dello Scheduler SMS a DEAD
				// e tento di diventare lo scheduler di invio/verifica SMS : usa la tecnica del lock esclusivo mettendo prima lo stato a SmsSchedulerState.DEAD.
				// Se ci riesce, lo scheduler sarè in esecuzione e il suo stato avrè il valore STARTED
				logger.info("il seguente host " + hostIp + ":" + port + " ha avviato l'istanza dello scheduler di invio/verifica SMS");
			// se non è in stato DEAD il nodo diventa un watchdog
			} else {
				if (!SmsSchedulerContextUtility.isSchedulerInThisHost()) {
					startWatchdogIfNecessary(hostIp, port);
				}
			}
		} catch (SmsSchedulerContextException ex) {
			String errMsg = "Errore grave, fase di avvio scheduler andata in errore, verificare che lo scheduler sia attivo : " + ex.getMessage();
			logger.error(errMsg, ex.getCause());
			
			SmsUtility.sendMailWithPlainText(errMsg);
		}
	}
	
	private void startWatchdogIfNecessary(String hostIp, String port) throws SmsSchedulerContextException {
		logger.info("il seguente host tenterèdi avviare l'istanza del watchdog di controllo dello scheduler di invio/verifica SMS");
		
		boolean result = SmsWatchdogManagerWebServices.getInstance().tryStartWatchdog();					
						
		if (!result) {
			String errMsg = "Attenzione!!! Watchdog non avviato per il seguente host : " + hostIp + ":" + port + " perchè già attivo";
			logger.error(errMsg);
			
			SmsUtility.sendMailWithPlainText(errMsg);
		} else {
			logger.info("Watchdog avviato per il seguente host : " + hostIp);
		}		
	}
	*/
}

