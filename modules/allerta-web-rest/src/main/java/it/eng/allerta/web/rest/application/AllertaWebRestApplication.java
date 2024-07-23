package it.eng.allerta.web.rest.application;

import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import allerta.dewetra.service.HRWLocalService;

import com.google.gson.Gson;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONSerializer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

import it.eng.allerta.rest.application.service.AllertaRestService;
import it.eng.allerta.rest.application.service.ReportRefreshService;
import it.eng.allerter.service.AllertaService;
import it.eng.allerter.service.LogInternoLocalService;
import it.eng.allerter.service.LogInternoLocalServiceUtil;
import it.eng.allerter.service.SMSLocalService;
import it.eng.animaeteo.model.AnimeteoImg;
import it.eng.animaeteo.service.AnimeteoImgLocalServiceUtil;
import it.eng.animazione.image.exception.NoSuchPioggiaCumulativaException;
import it.eng.animazione.image.model.PioggiaCumulativa;
import it.eng.animazione.image.model.altezzaOnda;
import it.eng.animazione.image.model.altezzaOndaAdriac;
import it.eng.animazione.image.model.altezzaOndaSwanita;
import it.eng.animazione.image.service.PioggiaCumulativaLocalServiceUtil;
import it.eng.animazione.image.service.altezzaOndaAdriacLocalServiceUtil;
import it.eng.animazione.image.service.altezzaOndaLocalServiceUtil;
import it.eng.animazione.image.service.altezzaOndaSwanitaLocalServiceUtil;
import it.eng.bollettino.service.BollettinoService;
import it.eng.bollettino.service.RegolaAllarmeLocalService;
import it.eng.bollettino.service.ValoreSensoreLocalService;
import it.eng.bollettino.service.ValoreSensoreService;
import it.eng.cache.service.DatiLocalServiceUtil;
import it.eng.radarMeteo.model.Img;
import it.eng.radarMeteo.service.Comuni_bacini_wsServiceUtil;
import it.eng.radarMeteo.service.Comuni_wsLocalServiceUtil;
import it.eng.radarMeteo.service.Comuni_wsService;
import it.eng.radarMeteo.service.Comuni_wsServiceUtil;
import it.eng.radarMeteo.service.ImgLocalServiceUtil;
import it.eng.radarMeteo.service.ImgService;

/**
 * @author VLPMRC80B
 */
@Component(
	immediate = true,
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/api/allerta",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=AllertaWebRest"
	},
	service = Application.class
)
public class AllertaWebRestApplication extends Application {

	private Log logger = LogFactoryUtil.getLog(AllertaWebRestApplication.class);
	
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ITALY);
	
	@Context private HttpServletRequest servletRequest;
	
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}
	
	
	

	@GET
	@Path("/group/search-groups")
	@Produces("application/json")
	public String searchGroups(
			@QueryParam("placeName") String placeName) {

		JSONArray json = JSONFactoryUtil.createJSONArray();
		
		if (Validator.isNull(placeName))
			placeName = "";
		
		if (placeName.length() < 3) {
			return json.toString();
		}
		
		try {
			
			json = allertaRestService.getPlace(placeName);
			
		} catch (Exception e) {
			_log.error(e);
		}
		 
		
		return json.toString();
	}
	/*
	@POST
	@Path("/SMSServiceRest")
	@Produces("application/json; charset=UTF-8")
	public String smsServiceRestPost(
			@QueryParam("parameter") String parameter) {
		
		return smsServiceRest(parameter);
		
	}
	
	@GET
	@Path("/SMSServiceRest")
	@Produces("application/json; charset=UTF-8")
	public String smsServiceRest(
			@QueryParam("parameter") String parameter) {
	
		Map<String,String> myMap = new HashMap<>();
		int localPort;
		String scheme;
		boolean shutdown;
		boolean socketOn;
		String myNodo;
		String address;

		String ip = null;
		try {
			ip = SMSManagerWebServices.getIp();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		
		Gson gson = new Gson();
		switch (parameter) {
		case "info":
			localPort = servletRequest.getLocalPort();
			scheme = servletRequest.getScheme();
//			shutdown = SmsManagerWebServices.isShutdown();
			myNodo = scheme+"://"+ip+":"+localPort;
			_log.info("Invocato metodo info da "+ip);
			myMap.put("nameJVM", SMSManagerWebServices.nameJVM());
			myMap.put("myIp", myNodo);
			myMap.put("smsInviati",String.valueOf(SMSManagerWebServices.smsInviati()));
			myMap.put("isShutdown", String.valueOf(SMSManagerWebServices.getPoolWeb().isShutdown()));
			myMap.put("isTerminated", String.valueOf(SMSManagerWebServices.getPoolWeb().isTerminated()));
			break;
		case "startOrStopWS":
			SMSManagerWebServices.startOrStopWebServer();
			myMap.put("result", "ok");
			_log.info("Invocato metodo startOrStopWS da "+ip);
			break;
		case "log":
			String log = SMSManagerWebServices.getLog();
			myMap.put("text", log);
			_log.info("Invocato metodo getLog da "+ip);
			break;
		case "isEnable":
			boolean enableOther = SMSManagerWebServices.isEnable();
			myMap.put("isEnable", String.valueOf(enableOther));
			_log.info("Invocato metodo isEnable da "+ip);
			break;
		case "changeEnableOther":
			SMSManagerWebServices.changeEnable();
			_log.info("Invocato metodo changeEnableOther da "+ip);
			break;			
//		case "isShutdown":
//			shutdown = SmsManagerWebServices.isShutdown();
//			myMap.put("isShutdown", String.valueOf(shutdown));
//			_log.info("Invocato metodo isShutdown da "+ip);
//			break;
		default:
			break;
		}
		
		myMap.put("result", "Ok");
		
		JSONSerializer serializer = JSONFactoryUtil.createJSONSerializer();
		String jsonData = serializer.serialize(myMap);
		return jsonData;
	}
	
	
	@POST
	@Path("/SMSService")
	@Produces("application/json; charset=UTF-8")
	public String smsServicePost(
			@QueryParam("parameter") String parameter) {
		
		return smsService(parameter);
		
	}
	
	@GET
	@Path("/SMSService")
	@Produces("application/json; charset=UTF-8")
	public String smsService(
			@QueryParam("parameter") String parameter) {
		
		Map<String,String> myMap = new HashMap<>();
		int localPort;
		String scheme;
		boolean shutdown;
		boolean socketOn;
		String myNodo;
		String address;
		
		String ip = null;
		try {
			ip = SMSManager.getIp();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		//Gson gson = new Gson();
		switch (parameter) {
		case "info":
			
			localPort = servletRequest.getLocalPort();
			scheme = servletRequest.getScheme();
			shutdown = SMSManager.isShutdown();
			socketOn = SMSManager.isSocketOn();
			myNodo = scheme+"://"+ip+":"+localPort;
			_log.info("Invocato metodo info da "+ip);
			myMap.put("nameJVM", SMSManager.nameJVM());
			myMap.put("myIp", myNodo);
			myMap.put("isShutdown", String.valueOf(shutdown));
			myMap.put("socketConnected",String.valueOf(socketOn));
			myMap.put("numeroSMSSpeditiParziale", String.valueOf(SMSManager.getNumeroSmsSpeditiFromLastStart()));
			myMap.put("smsBeanSize", String.valueOf(SMSManager.getSmsBeanSize()));
			myMap.put("trnSize", String.valueOf(SMSManager.getTrnSize()));
//			_log.info("mynodo" +myNodo);
//			String line = null;
//			try {
//				TrustCertificate.doTrustToCertificates();
//				List<Nodo> findByip = NodoLocalServiceUtil.getNodos(0, 2);
//				//URL url = new URL(scheme+"://"+ip+":"+localPort+"/sms-service-portlet/ServletRest?parameter=isShutdown2");
//				//URL url = new URL("https://vm184lnx.ente.regione.emr.it:"+localPort+"/sms-service-portlet/ServletRest?parameter=isShutdownOther");
//				myMap.put("nodoSize", String.valueOf(NodoLocalServiceUtil.getNodosCount()));
//				for(Nodo n: findByip) {
//					String nodoConcat = scheme+"://"+n.getIp()+":"+n.getPorta();
//					if(!nodoConcat.equals(myNodo)){
//						_log.info("nodoConcat" +nodoConcat);
//						url = new URL(n.getNodoConnesso()+":"+n.getPorta()+"/sms-service-portlet/ServletRest?parameter=isShutdownOther&token=XG8ub2SNXoil5LWmdWUu");
//						myMap.put("nodoOther", n.getNodoConnesso()+":"+n.getPorta());
//						in = new BufferedReader(new InputStreamReader(url.openStream()));
//						line = in.readLine();
//						myMap2 = gson.fromJson(line, Map.class);
//						myMap.putAll(myMap2);
//					}
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			break;
		case "startOrStopSocket":
			SMSManager.startOrStopSocket();
			myMap.put("result", "ok");
			_log.info("Invocato metodo startOrStopSocket da "+ip);
			break;
		case "isSocketOn":
			socketOn = SMSManager.isSocketOn();
			myMap.put("socketOn", String.valueOf(socketOn));
			_log.info("Invocato metodo isSocketOn da "+ip);
			break;
		case "getLog":
			String log = SMSManager.getLog();
			myMap.put("text", log);
			_log.info("Invocato metodo getLog da "+ip);
			break;
		case "startOrStopThread":
			SMSManager.startOrStopThread();
			myMap.put("result", "ok");
			_log.info("Invocato metodo startOrStopThread da "+ip);
			break;
		case "isShutdown":
			shutdown = SMSManager.isShutdown();
			myMap.put("isShutdown", String.valueOf(shutdown));
			_log.info("Invocato metodo isShutdown da "+ip);
			break;
		default:
			break;
		}
		myMap.put("result", "Ok");
		
		JSONSerializer serializer = JSONFactoryUtil.createJSONSerializer();
		String jsonData = serializer.serialize(myMap);
		return jsonData;
		
		//return gson.toJson(myMap);

	}*/
	
	@POST
	@Path("/subscriptions")
	@Produces("application/json; charset=UTF-8")
	public String subscriptionsPost(
			@QueryParam("cmd") String cmd,
			@QueryParam("groupId") long groupId,
			@QueryParam("userId") long userId) {
		
		return subscriptions(cmd, groupId, userId);
		
	}
	
	@GET
	@Path("/subscriptions")
	@Produces("application/json; charset=UTF-8")
	public String subscriptions(
			@QueryParam("cmd") String cmd,
			@QueryParam("groupId") long groupId,
			@QueryParam("userId") long userId) {
		
		if( cmd.equals("subscribe")) {
			
			UserLocalServiceUtil.addGroupUser(groupId, userId);
			
		} else {
			
			UserLocalServiceUtil.deleteGroupUser(groupId, userId);
		}
		
		return "[]";
	}
	
	@POST
	@Path("/deleteArticle")
	@Produces("application/json; charset=UTF-8")
	public String deleteArticlePost(
			@QueryParam("groupId") long groupId,
			@QueryParam("articleId") String articleId) {
		
		return deleteArticle(groupId, articleId);
		
	}
	
	@GET
	@Path("/deleteArticle")
	@Produces("application/json; charset=UTF-8")
	public String deleteArticle(
			@QueryParam("groupId") long groupId,
			@QueryParam("articleId") String articleId) {
		
		JournalArticle journalArticleObj = null;
		
		 try {
			journalArticleObj = JournalArticleLocalServiceUtil.getArticle(groupId, articleId);
		} catch (PortalException e) {
			
			e.printStackTrace();
		}
		 
		 if( Validator.isNotNull(journalArticleObj)) {
			 
			 try {
				JournalArticleLocalServiceUtil.deleteArticle( journalArticleObj);
			} catch (PortalException e) {
				e.printStackTrace();
			}
		 }
		 
		
		return "[]";
		
	}
	
	@GET
	@Path("/deleteBlog")
	@Produces("application/json; charset=UTF-8")
	public String deleteBlog(
			@QueryParam("entryId") long entryId) {
		BlogsEntry b = null;
		
			 b = BlogsEntryLocalServiceUtil.fetchBlogsEntry(entryId);
		
		 
		 if( Validator.isNotNull(b)) {
			 
	
				 BlogsEntryLocalServiceUtil.deleteBlogsEntry( b);
			
		 }
		 
		
		return "[]";
		
	}
	
	
	@POST
	@Path("/getlastimages")
	@Produces("application/json; charset=UTF-8")
	public String getLastImagesPost() {
		return getLastImages();
		
	}
	
	@GET
	@Path("/getlastimages")
	@Produces("application/json; charset=UTF-8")
	public String getLastImages() {
		
		try {
			
			JSONSerializer serializer = JSONFactoryUtil.createJSONSerializer();
			String jsonData = serializer.serialize(imagesService.getlastimages());
			return jsonData;
			//return JSONFactoryUtil.createJSONArray(jsonData).toString();
			
		} catch (Exception e) {
			
			_log.debug("Error to get-last-images");
			_log.error(e);
			
			return "[]" ;
		}
		
		
	}
	
	@POST
	@Path("/get-sensor-values-no-time")
	@Produces("application/json; charset=UTF-8")
	public String getSensorValuesNotimePost(
			@QueryParam("time") long time,
			@QueryParam("variabile") String var) {
		
		return getSensorValuesNotime(time, var);
	}
	
	
	@GET
	@Path("/legacy-get-monitoraggio")
	@Produces("application/json; charset=UTF-8")
	public String legacyGetMonitoraggio() {
		Map<String,Object> m = Comuni_bacini_wsServiceUtil.getBollettinoMonitoraggio();
		return JSONFactoryUtil.serialize(m);
	}
	
	@GET
	@Path("/legacy-get-meteomont")
	@Produces("application/json; charset=UTF-8")
	public String legacyGetMeteomont() {
		ArrayList<HashMap<String,String>>  m = Comuni_wsServiceUtil.getMeteomont();
		
		return JSONFactoryUtil.createJSONArray(m).toString();
	}
	
	@GET
	@Path("/legacy-get-allerta")
	@Produces("application/json; charset=UTF-8")
	public String legacyGetAllerta(String data) {
		Date d = new Date();
		if (data!=null) {
			try {
			d = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(data);
			} catch (Exception e) {}
		}
		
		Timestamp t = new Timestamp(d.getTime());
		JSONSerializer serializer = JSONFactoryUtil.createJSONSerializer();
		
		Map<String,Object> m = Comuni_wsServiceUtil.getStatoAllerta(t);
		return serializer.serialize(m);
	}
	
	@GET
	@Path("/get-sensor-values-no-time")
	@Produces("application/json; charset=UTF-8")
	public String getSensorValuesNotime(
				@QueryParam("time") long time,
				@QueryParam("variabile") String var
				) {
		
		if( var == "undefined") var = "";
		try {
			
			String cacheName = "sensorvaluesnotime_"+time+"_"+var;
			String jsonData = null;
			
			try {
				jsonData = (String) DatiLocalServiceUtil.getDato(cacheName);
			} catch (Exception ee) {};
			
			if (jsonData==null) {
				JSONSerializer serializer = JSONFactoryUtil.createJSONSerializer();
				jsonData = serializer.serialize(imagesService.getsensorvaluesnotime(var, time));
				try {
					DatiLocalServiceUtil.putDato(cacheName, jsonData);
				} catch (Exception eeee) {}
			}
			
			return JSONFactoryUtil.createJSONArray(jsonData).toString();
			
		} catch (Exception e) {
			_log.debug("Error to getSensorValuesNotime");
			_log.error(e);
			
			return "[]" ;
		}
	}
	
	@POST
	@Path("/get-sensor-values")
	@Produces("application/json; charset=UTF-8")
	public String getSensorValuesPost(
			@QueryParam("time") long time,
			@QueryParam("variabile") String var) {
		
		return getSensorValues(time, var);
	}
	
	@GET
	@Path("/get-sensor-values")
	@Produces("application/json; charset=UTF-8")
	public String getSensorValues(
				@QueryParam("time") long time,
				@QueryParam("variabile") String var
				) {
		
		if( var == "undefined") var = "";
		try {
			String cacheName = "sensorvalues_"+time+"_"+var;
			String jsonData = null;
			
			try {
				jsonData = (String) DatiLocalServiceUtil.getDato(cacheName);
			} catch (Exception ee) {}
			
			if (jsonData==null) {
				JSONSerializer serializer = JSONFactoryUtil.createJSONSerializer();
				jsonData = serializer.serialize(imagesService.getSensorValues(var, time));
				try {
					DatiLocalServiceUtil.putDato(cacheName, jsonData);
				} catch (Exception eee) {}
			}
			
			
			return JSONFactoryUtil.createJSONArray(jsonData).toString();
			
		} catch (Exception e) {
			_log.debug("Error to getSensorValuesNotime");
			_log.error(e);
			
			return "[]" ;
		}
	}
	
	@POST
	@Path("/get-pioggia-cumulata-24")
	@Produces("application/json; charset=UTF-8")
	public String getPioggiaCumulata24Post() {
		return  getPioggiaCumulata24();
	}
	
	@GET
	@Path("/get-pioggia-cumulata-24")
	@Produces("application/json; charset=UTF-8")
	public String getPioggiaCumulata24() {
		
		Calendar calendar = Calendar.getInstance();
		
		List<PioggiaCumulativa> cumulativa24 = null;
		
		try {
			
			cumulativa24 = PioggiaCumulativaLocalServiceUtil.findByCumulazione("24h");
			
			for(PioggiaCumulativa cumulativa : cumulativa24) {
				
				calendar.setTime(cumulativa.getInzioCumulazione());
//				calendar.add(Calendar.MONTH, -1);
				cumulativa.setInzioCumulazione(calendar.getTime());

				calendar.setTime(cumulativa.getFineCumulazione());
//				calendar.add(Calendar.MONTH, -1);
				cumulativa.setFineCumulazione(calendar.getTime());
			}
		} catch (SystemException | NoSuchPioggiaCumulativaException e) {
			// TODO Auto-generated catch block
			_log.error(e);
		}
	
		return new Gson().toJson(cumulativa24);
		
	}
	
	@POST
	@Path("/get-pioggia-cumulata-48")
	@Produces("application/json; charset=UTF-8")
	public String getPioggiaCumulata48Post() {
		return  getPioggiaCumulata48();
	}
	
	@GET
	@Path("/get-pioggia-cumulata-48")
	@Produces("application/json; charset=UTF-8")
	public String getPioggiaCumulata48() {
		
		Calendar calendar = Calendar.getInstance();
		
		List<PioggiaCumulativa> cumulativa48 = null;
		
		try {
			
			cumulativa48 = PioggiaCumulativaLocalServiceUtil.findByCumulazione("48h");
			
			for(PioggiaCumulativa cumulativa : cumulativa48) {
				
				calendar.setTime(cumulativa.getInzioCumulazione());
//				calendar.add(Calendar.MONTH, -1);
				cumulativa.setInzioCumulazione(calendar.getTime());

				calendar.setTime(cumulativa.getFineCumulazione());
//				calendar.add(Calendar.MONTH, -1);
				cumulativa.setFineCumulazione(calendar.getTime());
			}
		} catch (SystemException | NoSuchPioggiaCumulativaException e) {
			// TODO Auto-generated catch block
			_log.error(e);
		}
	
		return new Gson().toJson(cumulativa48);
		
	}
	
	@POST
	@Path("/get-pioggia-cumulata-6")
	@Produces("application/json; charset=UTF-8")
	public String getPioggiaCumulata6Post() {
		return getPioggiaCumulata6();
	}
	
	@GET
	@Path("/get-pioggia-cumulata-6")
	@Produces("application/json; charset=UTF-8")
	public String getPioggiaCumulata6() {
		
		Calendar calendar = Calendar.getInstance();
		
		List<PioggiaCumulativa> cumulativa6 = null;
		
		try {
			
			cumulativa6 = PioggiaCumulativaLocalServiceUtil.findByCumulazione("6h");
			
			for(PioggiaCumulativa cumulativa : cumulativa6) {
				
				calendar.setTime(cumulativa.getInzioCumulazione());
//				calendar.add(Calendar.MONTH, -1);
				cumulativa.setInzioCumulazione(calendar.getTime());

				calendar.setTime(cumulativa.getFineCumulazione());
//				calendar.add(Calendar.MONTH, -1);
				cumulativa.setFineCumulazione(calendar.getTime());
			}
		} catch (SystemException | NoSuchPioggiaCumulativaException e) {
			// TODO Auto-generated catch block
			_log.error(e);
		}
	
		return new Gson().toJson(cumulativa6);

	}
	
	@POST
	@Path("/get-all-radar-images")
	@Produces("application/json; charset=UTF-8")
	public String getAllRadarImagesPost() {
		return getAllRadarImages();
	}
	
	@GET
	@Path("/get-all-radar-images")
	@Produces("application/json; charset=UTF-8")
	public String getAllRadarImages() {
		
		 List<Img> allImagesList = null;
		 HashMap<Long,String> imgMap = new HashMap<Long,String>();
		 String bounds;
		
		try {
			
			allImagesList = ImgLocalServiceUtil.getImgs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			
			for(Img current:allImagesList){
				
				imgMap.put(current.getId(),current.getData());
			}
			
			bounds = allImagesList.get(0).getCoord();
			
			JSONSerializer serializer = JSONFactoryUtil.createJSONSerializer();
			
			String jsonData =  serializer.serialize(imgMap) ;
			
			String imagesArray = "\"images\":" + JSONFactoryUtil.createJSONObject(jsonData).toString();
			
			return "{" + imagesArray + ", \"bounds\":[" + bounds + "] }";
			
		} catch (Exception e) {
			_log.error(e);
		}
		
		return "[]" ;
		
	}
	
	@POST
	@Path("/get-all-animeteo-preci")
	@Produces("application/json; charset=UTF-8")
	public String getAllAnimeteoPreciPost() {
		return getAllAnimeteoPreciImages();
	}
	
	@GET
	@Path("/get-all-animeteo-preci")
	@Produces("application/json; charset=UTF-8")
	public String getAllAnimeteoPreciImages() {
		return getAllAnimeteoImages("preci");
	}
	
	@POST
	@Path("/get-all-animeteo-nuv")
	@Produces("application/json; charset=UTF-8")
	public String getAllAnimeteoNuvPost() {
		return getAllAnimeteoNuvImages();
	}
	
	@GET
	@Path("/get-all-animeteo-nuv")
	@Produces("application/json; charset=UTF-8")
	public String getAllAnimeteoNuvImages() {
		return getAllAnimeteoImages("nuv");
	}
	
	@POST
	@Path("/get-all-animeteo-wind")
	@Produces("application/json; charset=UTF-8")
	public String getAllAnimeteoWindPost() {
		return getAllAnimeteoWindImages();
	}
	
	@GET
	@Path("/get-all-animeteo-wind")
	@Produces("application/json; charset=UTF-8")
	public String getAllAnimeteoWindImages() {
		return getAllAnimeteoImages("wind");
	}
	
	private String getAllAnimeteoImages(String tipo) {
		
		 List<AnimeteoImg> allImagesList = null;
		 HashMap<Long,String> imgMap = new HashMap<Long,String>();
		 String bounds;
		
		try {
			allImagesList = AnimeteoImgLocalServiceUtil.findByType(tipo);
			for(AnimeteoImg current:allImagesList){
				
				imgMap.put(current.getInserted().getTime()/1000,current.getData());
			}
			
			bounds = "7,43,14,46.5";
			
			JSONSerializer serializer = JSONFactoryUtil.createJSONSerializer();
			
			String jsonData =  serializer.serialize(imgMap) ;
			
			String imagesArray = "\"images\":" + JSONFactoryUtil.createJSONObject(jsonData).toString();
			
			return "{" + imagesArray + ", \"bounds\":[" + bounds + "] }";
			
		} catch (Exception e) {
			_log.error(e);
		}
		
		return "[]" ;
		
	}
	
	@POST
	@Path("/get-nowcasting")
	@Produces("application/json; charset=UTF-8")
	public String getNowcastingPost() {
		return getNowcasting();
	}
	
	@GET
	@Path("/get-nowcasting")
	@Produces("application/json; charset=UTF-8")
	public String getNowcasting() {
		
		 HashMap<Long,String> imgMap = new HashMap<Long,String>();
		 String bounds;
		 
		
		try {
			
			it.eng.previsioni.meteo.model.Img i = it.eng.previsioni.meteo.service.ImgLocalServiceUtil.getByPartDayProvincia("immagineRadar", "Nowcasting", "ND");
			

			imgMap.put(i.getId(),i.getData());
			
			
			bounds = "5.00129,40.999,17.0188,48.216";
			
			JSONSerializer serializer = JSONFactoryUtil.createJSONSerializer();
			
			String jsonData =  serializer.serialize(imgMap) ;
			
			String imagesArray = "\"images\":" + JSONFactoryUtil.createJSONObject(jsonData).toString();
			
			return "{" + imagesArray + ", \"bounds\":[" + bounds + "] }";
			
		} catch (Exception e) {
			_log.error(e);
		}
		
		return "[]" ;
		
	}
	
	@POST
	@Path("/get-altezza-onda")
	@Produces("application/json; charset=UTF-8")
	public String getAltezzaOndaPost() {
		return getAltezzaOnda();
	}
	
	@GET
	@Path("/get-altezza-onda")
	@Produces("application/json; charset=UTF-8")
	public String getAltezzaOnda() {
		HashMap<Long,String> imgMap = new HashMap<Long,String>();
		 String bounds;
		 
		 try {
		List<altezzaOnda> al = altezzaOndaLocalServiceUtil.getaltezzaOndas(-1, -1);
		
		for(altezzaOnda current:al){
			
			imgMap.put(current.getTs_UTC(),current.getImgData());
		}
		
		bounds = "12,43.8,13,45";
		
		JSONSerializer serializer = JSONFactoryUtil.createJSONSerializer();
		
		String jsonData =  serializer.serialize(imgMap) ;
		
		String imagesArray = "\"images\":" + JSONFactoryUtil.createJSONObject(jsonData).toString();
		
		return "{" + imagesArray + ", \"bounds\":[" + bounds + "] }";
		
		
		 } catch (Exception e) {
				_log.error(e);
			}
			
			return "[]" ;
	}
	
	@POST
	@Path("/get-altezza-onda-swanita")
	@Produces("application/json; charset=UTF-8")
	public String getAltezzaOndaSwanitaPost() {
		return getAltezzaOndaSwanita();
	}
	
	@GET
	@Path("/get-altezza-onda-swanita")
	@Produces("application/json; charset=UTF-8")
	public String getAltezzaOndaSwanita() {
		HashMap<Long,String> imgMap = new HashMap<Long,String>();
		 String bounds;
		 
		 try {
		List<altezzaOndaSwanita> al = altezzaOndaSwanitaLocalServiceUtil.getaltezzaOndaSwanitas(-1, -1);
		
		for(altezzaOndaSwanita current:al){
			
			imgMap.put(current.getTs_UTC(),current.getImgData());
		}
		
		bounds = "6,36,20,47";
		
		JSONSerializer serializer = JSONFactoryUtil.createJSONSerializer();
		
		String jsonData =  serializer.serialize(imgMap) ;
		
		String imagesArray = "\"images\":" + JSONFactoryUtil.createJSONObject(jsonData).toString();
		
		return "{" + imagesArray + ", \"bounds\":[" + bounds + "] }";
		
		
		 } catch (Exception e) {
				_log.error(e);
			}
			
			return "[]" ;
	}
	
	@POST
	@Path("/get-altezza-onda-adriac")
	@Produces("application/json; charset=UTF-8")
	public String getAltezzaOndaAdriacPost() {
		return getAltezzaOndaAdriac();
	}
	
	@GET
	@Path("/get-altezza-onda-adriac")
	@Produces("application/json; charset=UTF-8")
	public String getAltezzaOndaAdriac() {
		HashMap<Long,String> imgMap = new HashMap<Long,String>();
		 String bounds;
		 
		 try {
		List<altezzaOndaAdriac> al = altezzaOndaAdriacLocalServiceUtil.getaltezzaOndaAdriacs(-1, -1);
		
		for(altezzaOndaAdriac current:al){
			
			imgMap.put(current.getTs_UTC(),current.getImgData());
		}
		
		bounds = "12,40,20,46";
		
		JSONSerializer serializer = JSONFactoryUtil.createJSONSerializer();
		
		String jsonData =  serializer.serialize(imgMap) ;
		
		String imagesArray = "\"images\":" + JSONFactoryUtil.createJSONObject(jsonData).toString();
		
		return "{" + imagesArray + ", \"bounds\":[" + bounds + "] }";
		
		
		 } catch (Exception e) {
				_log.error(e);
			}
			
			return "[]" ;
	}
	
	
	@POST
	@Path("/get-allarmi")
	@Produces("application/json; charset=UTF-8")
	public String getAllarmiPost() {
		return getAllarmi();
	}
	
	
	@GET
	@Path("/get-allarmi")
	@Produces("application/json; charset=UTF-8")
	public String getAllarmi() {
		
		try {
			
			JSONSerializer serializer = JSONFactoryUtil.createJSONSerializer();
			String jsonData = serializer.serialize(bollettinoService.getAllarmi());
			return JSONFactoryUtil.createJSONArray(jsonData).toString();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "[]" ;
		
		
	}
	
	@POST
	@Path("/get-stato-allerta-domani")
	@Produces("application/json; charset=UTF-8")
	public String getStatoAllertaDomaniPost() {
		return getStatoAllertaDomani();
	}
	

	@GET
	@Path("/get-stato-allerta-domani")
	@Produces("application/json; charset=UTF-8")
	public String getStatoAllertaDomani() {
		
		try {
			
			JSONSerializer serializer = JSONFactoryUtil.createJSONSerializer();
			String jsonData = serializer.serialize(allertaService.getStatoAllertaDomani());
			return JSONFactoryUtil.createJSONArray(jsonData).toString();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "[]" ;
		
	}
	
	@POST
	@Path("/get-stato-allerta")
	@Produces("application/json; charset=UTF-8")
	public String getStatoAllertaPost(@QueryParam("days") Integer days) {
		return getStatoAllerta(days);
	}
	
	
	@GET
	@Path("/get-stato-allerta")
	@Produces("application/json; charset=UTF-8")
	public String getStatoAllerta(@QueryParam("days") Integer days) {
		
		try {
			
			if (days == null)
				days = new Integer(0);
			
			JSONSerializer serializer = JSONFactoryUtil.createJSONSerializer();
			String jsonData = serializer.serialize(allertaService.getStatoAllertaDays(days));
			return JSONFactoryUtil.createJSONArray(jsonData).toString();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "[]" ;
		
		
		/*
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		try {
			String parameter = "2019-06-01 12:00";
			
			Map<String, Object> statoAllerta = null;
			
			if(parameter!=null){
				_log.info("Parametro data --> "+parameter);
				try {
					Date parsedDate = dateFormat.parse(parameter);
					Timestamp timestamp = new Timestamp(parsedDate.getTime());
					statoAllerta = comuni_wsService.getStatoAllerta(timestamp);
				} catch(Exception e) {
					_log.info("Data non valida "+parameter);
					statoAllerta = new HashMap<String, Object>();
					statoAllerta.put("errore", "Data non valida. Formato corretto: yyyy-MM-dd HH:mm");
					_log.error(e);
				}
			}
			else
				statoAllerta = comuni_wsService.getStatoAllerta();

			JSONSerializer serializer = JSONFactoryUtil.createJSONSerializer();
			String jsonData = serializer.serialize(statoAllerta);
			json = JSONFactoryUtil.createJSONObject(jsonData);
			 
			
		} catch (Exception e) {
			_log.error(e);
		}
		
		
		return json.toString();
		
		*/
	}
	
	@GET
	@Path("/get-time-series")
	@Produces("application/json; charset=UTF-8")
	public String getTimeSeries(@QueryParam("stazione") String stazione, @QueryParam("variabile") String var) {
		
		try {
			
			JSONSerializer serializer = JSONFactoryUtil.createJSONSerializer();
			String jsonData = serializer.serialize(imagesService.getTimeSeries(stazione, var));
			return jsonData;

		} catch (Exception e) {
			
			_log.debug("Error to get-last-images");
			_log.error(e);
			
			return "[]" ;
		}
	}
	
	@GET
	@Path("/get-stations")
	@Produces("application/json; charset=UTF-8")
	public String getStations() {
		
		try {
			
			JSONSerializer serializer = JSONFactoryUtil.createJSONSerializer();
			String jsonData = serializer.serialize(imagesService.getStations());
			return jsonData;

		} catch (Exception e) {
			
			_log.debug("Error to get-stations");
			_log.error(e);
			
			return "[]" ;
		}

	}

	
	@GET
	@Path("/buildAllertaPdf")
	@Produces("application/json; charset=UTF-8")
	public void buildAllertaPdf(
			@QueryParam("tipo") String tipo, 
			@QueryParam("id") String id,
			@QueryParam("scope") String scope) {
		
		LogInternoLocalServiceUtil.log("buildAllertaPdf", "buildAllertaPdf", tipo, "");

		
		try {
			
			reportService.refreshPdf(null, tipo, id, scope, servletRequest);
			
		} catch (Exception e) {
			_log.error(e);
			LogInternoLocalServiceUtil.log("buildAllertaPdf", "buildAllertaPdf", e, "");
		}
		
	}
	
	@POST
	@Path("/aggiorna-dati-osservati")
	@Produces("application/json; charset=UTF-8")
	public String aggiornaDatiOsservati(String dati) {
		
		DatiLocalServiceUtil.removeDatiByPrefix("sensorvalues%");
		
		Map<String,Object> a = valoreSensoreService.aggiornaDatiOsservati(dati);
		int v = 0;
		if (a.get("valori")!=null) {
			v = (int)a.get("valori");
			if (v>0) {
				logInternoService.log("dati osservati", "Aggiornamento dati osservati", "Comunicati "+v+" dati", "");
			}
		}
		
		//logInternoService.log("dati osservati", "Aggiornamento dati osservati", "Comunicati 0 dati", "");
		
		logger.error(dati);
		
		if (1==1) return "{\"result\":\"ok\", \"data\":"+v+"}";
		
		boolean idro = (boolean)a.get("idro");
		boolean pluvio = (boolean)a.get("pluvio");
		
		if (pluvio) {
			boolean attivazioneMonitoraggio = valoreSensoreService.controlloPioggiaMonitoraggio();
			if (attivazioneMonitoraggio)
				logInternoService.log("datiOss", "Accensione monitoraggio", "Accensione automatica per pioggia", "");
		}
		
		if (pluvio || idro) {
			Map result = regolaAllarmeService.regoleAllarme();
			List<String> supIdro = (List<String>)result.get("superamentiIdro");
			List<String> supPluvio = (List<String>)result.get("superamentiPluvio");
			List<String> supCessati = (List<String>)result.get("superamentiCessati");
			List<Object[]> spike = (List<Object[]>)result.get("spike");
			
			for (String s : supIdro) {
				logInternoService.log("datiOss", "Nuovo superamento idro", s, "");
			}
			
			for (String s : supPluvio) {
				logInternoService.log("datiOss", "Nuovo superamento pluvio", s, "");
			}
			
			for (String s : supCessati) {
				logInternoService.log("datiOss", "Superamento cessato", s, "");
			}
			
			for (Object[] s : spike) {
				logInternoService.log("datiOss", "Spike", s[0].toString()+
						" ("+s[1].toString()+"), delta="+s[3].toString()+"m", "");
				notificaSpike(s[0].toString(),s[1].toString(),(Date)s[2],(Double)s[3],
						(Double)s[4]);
			}
		}
		
		return "{\"result\":\"ok\", \"data\":"+v+"}";
	}
	
	@POST
	@Path("/dewetra-hrw")
	@Produces("application/json; charset=UTF-8")
	public String aggiornaDewetra(String dati) {
		
		
		Map<String,Object> a = hrwService.aggiornaDewetra(dati);
		int v = 0;
		if (a.get("valori")!=null) {
			v = (int)a.get("valori");
			if (v>0) {
				logInternoService.log("aggiornaDewetra", "Aggiornamento Dewetra", "Comunicati "+v+" dati", "");
			}
		}
		
		//logInternoService.log("dati osservati", "Aggiornamento dati osservati", "Comunicati 0 dati", "");
		
		logger.error(dati);
		
		return "{\"result\":\"ok\",  \"data\":"+v+"}";
		
		
	}
	
	private void notificaSpike(String s, String nom, Date d, double delta, double soglia) {
		// TODO Auto-generated method stub
		try {
			long ts = new Date().getTime();
			DecimalFormat df = new DecimalFormat("#.##");
		String ora = new SimpleDateFormat("HH:mm").format(d);
		String sms = "Attenzione: rilevato spike ("+df.format(delta )+" metri, soglia "+df.format(soglia )+" metri) su "+nom+" alle ore "+ora+". Non viene considerato superamento.";
		long org = 0;
		
			long canale[] = new long[1];
			//canale[0] = 1; //solo email
			smsLocalService.creaNotificaGruppoRubrica(null, "AllerteER", "", "spike", s, ts, 20198, "Rubrica spike", true, null);
			//smsLocalService.creaSMSOrganization("AllerteER", sms, "spike", s, ts, org);
			smsLocalService.eliminaDuplicati("spike", s, ts);
			smsLocalService.eliminaDuplicatiEmail("spike", s, ts);
			smsLocalService.inviaSMS("spike", s, ts);
			smsLocalService.inviaEmail("spike", s, ts,
					"Portale Web allerte: spike "+nom, sms, "no-reply@regione.emilia-romagna.it");
			
		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("caricaDbTask.notificaSpike", "", e, "");
			return;
		}
		
	}
	
	
	@Reference
	private AllertaRestService allertaRestService;
	
	@Reference
	private AllertaService allertaService;
	
	@Reference
	private BollettinoService bollettinoService;
	
	@Reference
	private ImgService imagesService;
	
	@Reference
	private Comuni_wsService comuni_wsService;
	
	@Reference
	private ReportRefreshService reportService;
	
	@Reference
	private ValoreSensoreLocalService valoreSensoreService;
	
	@Reference
	private HRWLocalService hrwService;
	
	@Reference
	private LogInternoLocalService logInternoService;
	
	@Reference
	private RegolaAllarmeLocalService regolaAllarmeService;
	
	@Reference
	private SMSLocalService smsLocalService;
	
	private Log _log = LogFactoryUtil.getLog(AllertaWebRestApplication.class);


}