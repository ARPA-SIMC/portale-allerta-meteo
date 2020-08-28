package it.eng.sms.bean;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import it.eng.allerta.messages.services.model.Nodo;
import it.eng.allerta.messages.services.model.Parametro;
import it.eng.allerta.messages.services.service.NodoLocalServiceUtil;
import it.eng.allerta.messages.services.service.ParametroLocalServiceUtil;
import it.eng.allerter.service.SMSLocalServiceUtil;
import it.eng.sms.utility.SMSUtility;

public class SMSManager {
	
	/* DELETE CLASS ?
	private static Log _log = LogFactoryUtil.getLog(SMSManager.class);
	
	private static SMSManager INSTANCE = null;
	static ExecutorService pool;
	private static List<Future<String>> futures = new ArrayList<Future<String>>(1);
	//	private static String infoAvvio = "Not connected";
	private static SMSAction smsAction;
	private static SMSUtility smsUtility = new SMSUtility();
	private static List<Nodo> findByip;
	
	public SMSManager(){
		try {
			findByip = NodoLocalServiceUtil.getNodos(0, 2);
		} catch (SystemException e) {
			_log.error(e);
		}
		
		INSTANCE = this;
	}

	public static SMSManager getInstance() {
		return INSTANCE;
	}

	public static boolean isShutdown(){
		
		if( pool == null)
			return true;
		
		return pool.isShutdown();
	}

	public static void startOrStopThread(){
		boolean shutdown = isShutdown();
		if(shutdown){
			start();
		}else{
			//shutdown();
			shutdown();
		}
	}

	private static void start(){
		_log.info("Start pool thread");
		smsUtility.sendMailWithPlainText("Start pool thread "+ smsUtility.nameJVM());
		pool = Executors.newSingleThreadExecutor();
	}

	private static void shutdown(){
		_log.info("Shutdown pool thread");
		smsUtility.sendMailWithPlainText("Shutdown pool thread "+ smsUtility.nameJVM());
		//		infoAvvio = "Not connected";

		smsAction=null;

		pool.shutdownNow();
	}

	public static void startOrStopSocket(){
		if(smsAction!=null && smsAction.getLoopS())
			changeToFalse();
		else
			startSocket();
	}

	private static void startSocket(){
		Parametro findBynodo = null;
		try {
			findBynodo = ParametroLocalServiceUtil.findBynodo(getIp()).get(0);
			_log.info("Sono dentro il metodo startVPN; ip estratto da db x vpn "+findBynodo.getIp());
			//			if(findBynodo==null)
			//				return;
		} catch (SystemException | IOException e) {
			// TODO Auto-generated catch block
			_log.error(e.getMessage());
		}
		//		infoAvvio = "metodo startVPN invocato";
		smsUtility.sendMailWithPlainText("Invocato metodo start socket "+ smsUtility.nameJVM());
		smsAction = new SMSAction(findBynodo.getIp(),findBynodo.getPorta(),findBynodo.getUsername(),findBynodo.getPassword());
		futures.add(pool.submit(smsAction));
	}
	
	private static void changeToFalse(){
		smsAction.setLoopS(false);
		_log.info("Stop socket");
		//		infoAvvio = "Impostato a false la variabile di loop";
		smsUtility.sendMailWithPlainText(" Invocato metodo di richiesta interruzione loop socket "+ smsUtility.nameJVM());
	}

	public static boolean getLoopSValue(){
		return smsAction.getLoopS();
	}

	//	public static String isConnected(){
	//		return infoAvvio;
	//	}

	public static int getNumeroSmsSpeditiFromLastStart(){
		if(smsAction!=null)
			return smsAction.getSmsSpeditiFromLastStart();
		else
			return -1;
	}

	public static String getLog(){
		String getenv = System.getenv("PWD");
		//		Map<String, String> getenv2 = System.getenv();
		//		logger.info(getenv2.toString());
		//		logger.info(getenv.toString());
		if( getenv== null)
			getenv = "F:/temp/";
		File file = new File(getenv+"/logs/SmsService/logging.log");
		//		logger.info("esiste il file "+file.exists());
		String tail = smsUtility.tail(file, 10);
		return tail;
	}

	//da capire come funge
	public static final String RESOURCE_NAME = "com.liferay.docs.guestbook.model";
	public static void check(PermissionChecker permissionChecker, long groupId,
			String actionId) throws PortalException {

		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long groupId, String actionId) {

		return permissionChecker.hasPermission(groupId, RESOURCE_NAME, groupId,
				actionId);
	}

	public static int getSmsInStato(Long stato){
		return SMSLocalServiceUtil.getSmsInStato(stato);
	}

	public void resetSMSFaseTwo(){
		//ParametroLocalServiceUtil.resetSMSFaseTwo();
	}
	//
	//	public static String isShutdownString(){
	//		return String.valueOf(isShutdown());
	//	}

	public static String nameJVM(){
		return smsUtility.nameJVM();
	}

	public static boolean isSocketOn() {
		if(smsAction!=null)
			return smsAction.isSocketConneted();
		else
			return false;
	}

	public static String getIp() throws UnknownHostException {
		return InetAddress.getLocalHost().getHostAddress();
	}

	public static int getSmsBeanSize() {
		if(smsAction !=null)
			return smsAction.getSmsBean().size();
		else
			return -1;
	}

	public static int getTrnSize() {
		if(smsAction !=null)
			return smsAction.getTrn().size();
		else
			return -1;
	}

	public static void startOrStopThreadOther(HttpServletRequest request){
		callServlet(request, "startOrStopThread");
	}

	public static void startOrStopSocketOther(HttpServletRequest request){
		callServlet(request, "startOrStopSocket");
	}

	public static boolean isSocketOnOther(HttpServletRequest request) {
		String callServlet = callServlet(request, "isSocketOn");
		Gson gson = new Gson();
		IsSocketOnBean fromJson = gson.fromJson(callServlet, IsSocketOnBean.class);
		return fromJson.getSocketOn();
	}

	public static boolean isShutdownOther(HttpServletRequest request){
		
		String callServlet = callServlet(request, "isShutdown");
		Gson gson = new Gson();
		IsShutdownBean fromJson = gson.fromJson(callServlet,IsShutdownBean.class);
		return fromJson.getIsShutdown();
	}

	public static boolean isShutdownOtherR(HttpServletRequest request){
		String callServlet = callServlet(request, "isShutdown");
		Gson gson = new Gson();
		IsShutdownBean fromJson = gson.fromJson(callServlet,IsShutdownBean.class);
		return fromJson.getIsShutdown();
	}

	public static ArrayList<String> getInfo(HttpServletRequest request){
		//		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		String callServlet = callServlet(request, "info");
		ArrayList<String> line = new ArrayList<>();
		line.add(callServlet);
		return line;
	}

	public static String getLogOther(HttpServletRequest request){
		//		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		String callServlet = callServlet(request, "getLog");
		Gson gson = new Gson();
		LogBean fromJson = gson.fromJson(callServlet,LogBean.class);
		return fromJson.getText();
	}

	private static String callServlet(HttpServletRequest request, String parameter){
		
		String requestScheme = request.getScheme();
		String requestServerName = request.getServerName();
		int requestServerPort = request.getServerPort();
		
		if(findByip == null)
			findByip = NodoLocalServiceUtil.getNodos(0, 2);
		
		BufferedReader in = null;
		//		logger.info("invocato metodo callservlet con parametro "+parameter);
		String ip = null;
		try {
			ip = getIp();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			_log.error(e1);
		}
		try {
			//			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
			//			String currentNode = requestScheme+"://"+requestServerName+":"+requestServerPort;
			//			logger.info("nodo corrente: "+requestScheme+"://"+requestServerName+":"+requestServerPort);
			for(Nodo n:findByip){
			
				if(!(ip+(requestServerPort%100)).equals(n.getIp()+(n.getPorta()%100) ) ){
					//					logger.info("nodo chiamato: "+n.getNodoConnesso()+":"+n.getPorta());
					URL url = new URL("http://localhost:8080/o/api/allerta/SMSService?parameter="+parameter+"&token=XG8ub2SNXoil5LWmdWUu");
							//new URL(n.getNodoConnesso()+":"+n.getPorta()+"/o/api/allerta/SMSService?parameter="+parameter+"&token=XG8ub2SNXoil5LWmdWUu");
					HttpURLConnection huc = (HttpURLConnection) url.openConnection();
					HttpURLConnection.setFollowRedirects(false);
					huc.setConnectTimeout(15 * 1000);
					huc.setRequestMethod("GET");
					huc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2 (.NET CLR 3.5.30729)");
					huc.connect();
					in = new BufferedReader(new InputStreamReader(huc.getInputStream()));
					String readLine = in.readLine();
					huc.disconnect();
					return readLine;
					//return readLine.substring(2, readLine.length()-1);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			_log.error(e);
		}
		finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				_log.error(e);
			}
		}
		return null;
	}

	//	HttpWebRequest request =  (HttpWebRequest)WebRequest.Create("http://www.blogger.com/feeds/12345/posts/default");
	//	 
	//	request.Method = "GET";
	//	HttpWebResponse response = (HttpWebResponse)request.GetResponse();
	//	 
	//	if (response.StatusCode == HttpStatusCode.OK) {
	//	    Stream responseStream = response.GetResponseStream();
	//	    DecodeResource(responseStream);
	//	}
	//	response.Close()

	//	public static boolean isSmsAction() {
	//	if(smsAction==null)
	//		return false;
	//	else
	//		return true;
	//}


	//	public String getAllServer(){
	//		ArrayList<String> server =  new ArrayList<>();
	//		try {
	//			List<Nodo> nodos = NodoLocalServiceUtil.getNodos(0, 2);
	//			for(Nodo n:nodos)
	//				server.add(n.getNodoConnesso().concat(":").concat(String.valueOf(n.getPorta())));
	//		} catch (SystemException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		return new Gson().toJson(server);
	//	}

	//	public String isShutdownAction(){
	//		return stato;
	//	}

	//	public static void test(){
	//		System.out.println(pool.isShutdown());
	//		try {
	//			System.out.println(InetAddress.getLocalHost().getHostAddress());
	//			logger.info(InetAddress.getLocalHost().getHostAddress());
	//			System.out.println(InetAddress.getLoopbackAddress().isSiteLocalAddress());
	//		} catch (UnknownHostException e1) {
	//			// TODO Auto-generated catch block
	//			logger.error(e1);
	//		}
	//		int i = 0;
	//		for(;i<10;i++){
	//			//		while(true){
	//			futures.add(pool.submit(new StringTask()));
	//			//			pool.submit(new StringTask());
	//			//			i++;
	//			//			if(i==10000){
	//			//				System.out.println(Runtime.getRuntime().maxMemory()+" --> "+Runtime.getRuntime().freeMemory());
	//			//				i=0;
	//			//			}
	//
	//		}
	//
	//		for(Future<String> future : futures){
	//			try {
	//				String result = future.get();
	//				System.out.println(result);
	//			} catch (InterruptedException | ExecutionException e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
	//			}
	//
	//			//Compute the result
	//		}
	//		pool.shutdown();
	//		System.out.println(pool.isShutdown());
	//		pool = Executors.newFixedThreadPool(4);
	//		System.out.println(pool.isShutdown());
	//	}

	//codice per il controllo dei permessi
	//		try{
	//		ThemeDisplay themeDisplay = LiferayFacesContext.getInstance().getThemeDisplay();
	//		logger.info("a --> "+themeDisplay.getUser()!=null?themeDisplay.getUser().getScreenName():"not logged");
	//		}
	//		catch(Exception e){
	//			logger.error(e);
	//		}
*/
}
