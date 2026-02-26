package it.eng.allerta.controlpanel.action;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Component;

import it.eng.allerta.controlpanel.constants.AllertaControlPanelPortletKeys;
import it.eng.allerta.utils.AllertaTracker;
import it.eng.allerter.model.AllertaParametro;
import it.eng.allerter.service.AllertaParametroLocalServiceUtil;
import it.eng.allerter.service.LogInternoLocalServiceUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + AllertaControlPanelPortletKeys.ALLERTACONTROLPANEL,
		"mvc.command.name=/controlpanel/inviasms" }, service = MVCActionCommand.class)
public class InviaSMSAction extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		System.out.println("InviaSMSAction");
		actionRequest.getParameterMap().forEach(
				(key,value)->System.out.println(key+" -> "+value));
		Map<String, String> ris = new HashMap<String, String>();

		String numero = ParamUtil.getString(actionRequest, "testInvioNumero");
		String testo = ParamUtil.getString(actionRequest, "testInvioTesto");
		String redirect = ParamUtil.getString(actionRequest, "redirect");

		//actionResponse.setRenderParameter("id", "SMS");
		

		if (numero == null || "".equals(numero)) {
			System.out.println("Numero vuoto");
			ris.put("inviosms_error", "Numero vuoto");
			actionResponse.sendRedirect(redirect);
			return;
		}
		if (testo == null || "".equals(testo)) {
			System.out.println("Testo vuoto");
			ris.put("inviosms_error", "Testo vuoto");
			actionResponse.sendRedirect(redirect);
			return;
		}

		System.out.println("Invio il messaggio");
		ris.putAll(inviaSMS(numero, testo));
		System.out.println("Messaggio inviato");
		//redirect(actionRequest, actionResponse,ris);
		actionResponse.setRenderParameter("id","SMS");
		actionResponse.setRenderParameter("redirect",redirect);
	}

	public static Map<String, String> inviaSMS(String numero, String testo) {

		HashMap<String, String> out = new HashMap<String, String>();

		try {

			out.put("inviosms_attempt", "true");

			String USERNAME = AllertaTracker.getAllertaSMSConfiguration().username();
			String PASSWORD = AllertaTracker.getAllertaSMSConfiguration().password();
			String TOKEN = AllertaTracker.getAllertaSMSConfiguration().token();
			String ALIAS = AllertaTracker.getAllertaSMSConfiguration().alias();

			HttpPost p = prepareHttpPostForService(USERNAME, PASSWORD, TOKEN, ALIAS, numero, testo);
			CloseableHttpClient httpClient = getCloseableHttpClient(60);
			CloseableHttpResponse response = httpClient.execute(p);

			out.put("inviosms_code", "" + response.getStatusLine().getStatusCode());
			out.put("inviosms_reason", response.getStatusLine().getReasonPhrase());

			String content = EntityUtils.toString(response.getEntity());

			out.put("inviosms_content", content);
			out.put("inviosms_response", getStatus(content, "status", 0));

			String message = getStatus(content, "message", 0);
			if (message == null)
				message = "";

			out.put("inviosms_message", message);

			String timestamp = message.substring(message.lastIndexOf("CODE:") + 5);

			out.put("inviosms_timestamp", timestamp);

		} catch (Exception e) {
			out.put("inviosms_error", e.toString());
		}
		return out;
	}
	
	public static Map<String, String> ricevutaSMS(String timestamp) {

		HashMap<String, String> out = new HashMap<String, String>();

		try {

			out.put("inviosms_attempt", "true");

			String USERNAME = AllertaTracker.getAllertaSMSConfiguration().username();
			String PASSWORD = AllertaTracker.getAllertaSMSConfiguration().password();
			String TOKEN = AllertaTracker.getAllertaSMSConfiguration().token();
			String ALIAS = AllertaTracker.getAllertaSMSConfiguration().alias();

			HttpPost p = prepareHttpPostForService2(USERNAME, PASSWORD, TOKEN, timestamp);
			CloseableHttpClient httpClient = getCloseableHttpClient(60);
			CloseableHttpResponse response = httpClient.execute(p);

			out.put("inviosms_code", "" + response.getStatusLine().getStatusCode());
			out.put("inviosms_reason", response.getStatusLine().getReasonPhrase());

			String content = EntityUtils.toString(response.getEntity());

			out.put("inviosms_content", content);
			out.put("inviosms_response", getStatus(content, "status", 0));

			String message = getStatus(content, "message", 0);
			if (message == null)
				message = "";

			out.put("inviosms_message", message);

			//String timestamp = message.substring(message.lastIndexOf("CODE:") + 5);

			out.put("inviosms_timestamp", timestamp);
			
			String date = getStatus(content, "dataRicezione", 1);
			String esito = getStatus(content, "esito", 1);
			
			out.put("inviosms_dataricezione",date);
			out.put("inviosms_esitoricezione",esito);

		} catch (Exception e) {
			out.put("inviosms_error", e.toString());
		}
		return out;
	}

	private static HttpPost prepareHttpPostForService(String username, String password, String token, String alias,
			String msisdn, String testo) {
		// +-- config httpPost
		MultipartEntityBuilder builder = prepareBuilder(username, password, token, alias, msisdn, testo);
		HttpPost httpPost = new HttpPost(
				AllertaTracker.getAllertaSMSConfiguration().urlServizio() + "send/sms/msisdn/static/immediate/single");
		httpPost.setHeader(HttpHeaders.ACCEPT, "application/json");
		httpPost.setEntity(builder.build());

		return httpPost;
	}
	
	private static HttpPost prepareHttpPostForService2(String username, String password, String token, String codiceOperazione) throws UnsupportedEncodingException {
		// +-- config httpPost
		List<BasicNameValuePair> params = prepareParams(username, password, token, codiceOperazione);
		HttpPost httpPost = new HttpPost(AllertaTracker.getAllertaSMSConfiguration().urlServizio() + "search");
		httpPost.setEntity(new UrlEncodedFormEntity(params));
		httpPost.setHeader(HttpHeaders.ACCEPT, "application/json");
		
		return httpPost;
	}
	
	private static List<BasicNameValuePair> prepareParams(String username, String password, String token, String codiceOperazione) {		
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

	private static MultipartEntityBuilder prepareBuilder(String username, String password, String token, String alias,
			String msisdn, String testo) {
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();

		builder.addTextBody("username", username).addTextBody("password", password).addTextBody("token", token)
				.addTextBody("alias", alias).addTextBody("msisdn", msisdn).addTextBody("testo", testo)
				.addTextBody("sr", "1").addTextBody("vp", "1440"); // validity period

		return builder;
	}

	public static CloseableHttpClient getCloseableHttpClient(int timeout_s) {
		// return new HttpClient();
		RequestConfig config = RequestConfig.custom().setConnectTimeout(120 * 1000).build();
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(config).build();

		return httpClient;
	}

	private static String getStatus(String body, String campo, int level) {
		final String msgError = "Impossibile recuperare lo status";

		if (body != null && !"".equals(body)) {
			if (level == 0) {
				try {
					ObjectMapper mapper = new ObjectMapper();
					JsonNode root = mapper.readTree(body);

					return root.path(campo).textValue();
				} catch (IOException e) {
					return "";
				}
			} else if (level == 1) {
				try {
					ObjectMapper mapper = new ObjectMapper();
					JsonNode root = mapper.readTree(body).get("items");

					if (root.isArray()) {
						return root.get(0).path(campo).textValue();
					} else {
						throw new IllegalStateException(
								"Impossibile valutare lo status, il root JsonNode non è un Array");
					}
				} catch (IOException e) {
					return "";
				}
			} else {
				throw new IllegalArgumentException(
						"Impossibile valutare lo status, il level non è tra quelli disponibili");
			}
		} else {
			throw new IllegalArgumentException(
					"Impossibile valutare lo status, il body della response non è valorizzato");
		}
	}

	void redirect(ActionRequest actionRequest, ActionResponse actionResponse, Map<String, String> m) {
		
		try {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		Long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(),
				AllertaControlPanelPortletKeys.ALLERTACONTROLPANEL);

		PortletURL compilaURL = PortletURLFactoryUtil.create(actionRequest,
				AllertaControlPanelPortletKeys.ALLERTACONTROLPANEL, plid, PortletRequest.RENDER_PHASE);

		Map<String, String[]> compilaParameters = new HashMap<String, String[]>(0);
		compilaParameters.put("mvcRenderCommandName", new String[] { "/controlpanel/render" });
		compilaParameters.put("id", new String[] { "SMS" });
		
		for (String k : m.keySet()) {
			System.out.println("Inserisco "+k+" -> "+m.get(k));
			compilaParameters.put(k, new String[] {m.get(k) });
		}

		compilaURL.setParameters(compilaParameters);
		System.out.println("URL: "+compilaURL.toString());
		actionResponse.sendRedirect(compilaURL.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
