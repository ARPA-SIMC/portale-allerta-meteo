package it.eng.allerta.utils;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;

import java.util.List;

public interface AllertaUtilsInterface {
	
	public Object invocaServizio(String nome, Object payload);
	public Object invocaServizioRefreshAllerta(long id);
	public Object invocaServizioRefreshMonitoraggio(long id);

	List<Group> getUserFavorities(User user);
	
	public boolean sendTelegramComune(long comuneId, String messaggio);
	public boolean postOnFacebook(long comuneId, String messaggio, String link);

}