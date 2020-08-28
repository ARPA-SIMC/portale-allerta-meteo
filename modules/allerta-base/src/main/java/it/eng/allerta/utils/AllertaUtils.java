package it.eng.allerta.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBus;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;

@Component(
		immediate = true,
		service = AllertaUtilsInterface.class
		)
public class AllertaUtils implements AllertaUtilsInterface {
	
	
	public Object invocaServizio(String nome, Object payload) {
		Message message = new Message();
		message.put("servizio",nome);	
		message.put("parametro", payload);
		_messageBus.sendMessage(AllertaMessageBusDestination.ALLERTA_BUS_DESTINATION_NAME,message);
		return message.getResponse();
	}
	
	public Object invocaServizioRefreshAllerta(long id) {
		return invocaServizio("refreshAllerta",id);
	}
	
	public Object invocaServizioRefreshMonitoraggio(long id) {
		return invocaServizio("refreshMonitoraggio",id);
	}

	/* (non-Javadoc)
	 * @see it.eng.allerta.utils.AllertaUtilsInterface#getUserFavorities(com.liferay.portal.kernel.model.User)
	 */
	public List<Group> getUserFavorities(User user) {
		
		List<Group> favorities = user.getGroups();
		favorities.removeIf(x -> x.getGroupKey().equals("Guest"));
				
		return favorities;
			
	}
	
	public boolean sendTelegramComune(long comuneId, String messaggio) {
		Group g = GroupLocalServiceUtil.fetchGroup(comuneId);
		if (g==null) return false;
		String bot = (String) g.getExpandoBridge().getAttribute("telegram-bot");
		String chat = (String) g.getExpandoBridge().getAttribute("telegram-chat");
		if (bot==null || chat==null || messaggio==null) return false;
		String api = "https://api.telegram.org/"+bot+"/sendMessage?chat_id="+chat+"&text="+messaggio;
		return openUrl(api,false);
	}
	
	public boolean postOnFacebook(long comuneId, String messaggio, String link) {
		
		if (messaggio==null) messaggio="";
		
		Group g = GroupLocalServiceUtil.fetchGroup(comuneId);
		if (g==null) return false;
		String id = (String) g.getExpandoBridge().getAttribute("facebook-page-id");
		String token = (String) g.getExpandoBridge().getAttribute("facebook-token");
		if (id==null || token==null || messaggio==null) return false;
		String api = "https://graph.facebook.com/"+id+"/feed?message="+messaggio+
		(link!=null?"&link="+link:"")+
		"&access_token="+token;
		return openUrl(api,true);	
	}
	
	
	private boolean openUrl(String u, boolean post) {
		URL url;
		HttpURLConnection conn = null;
		try {
			url = new URL(u);
			conn = (HttpURLConnection) url.openConnection();
			if (post) conn.setRequestMethod("POST");
			conn.getInputStream().close();
			return true;
		} catch (IOException e) {
			return false;
		} finally {
			if (conn != null)
				conn.disconnect();
		}
	}
	
	@Reference
    private MessageBus _messageBus;
	
}
