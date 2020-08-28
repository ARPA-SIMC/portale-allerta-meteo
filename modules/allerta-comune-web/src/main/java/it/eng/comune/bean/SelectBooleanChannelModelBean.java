package it.eng.comune.bean;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class SelectBooleanChannelModelBean {
	
	private Log _log = LogFactoryUtil.getLog(MessageModelBean.class);
	// CANALI DI COMUNICAZIONE 
	// le varibili sono state gestite come stringhe per alinerare l'interfaccia fatta da roberto 
	private String telefono;
	private String sms;
	private String social;
	private String mail;
	private String portale;
	
	public SelectBooleanChannelModelBean() {
		
		super();
		this.reset();
	}

	private void reset(){
		
		_log.info("RESET CANALE DI COMUNICAZIONE SCELTO");
		this.telefono="no";
		this.sms="no";
		this.social="no";
		this.mail="no";
		this.portale="no";
	}

	public final String getTelefono() {
		return telefono;
	}
	public final void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public final String getSms() {
		return sms;
	}
	public final void setSms(String sms) {
		this.sms = sms;
	}
	public final String getSocial() {
		return social;
	}
	public final void setSocial(String social) {
		this.social = social;
	}
	public final String getMail() {
		return mail;
	}
	public final void setMail(String mail) {
		this.mail = mail;
	}
	public final String getPortale() {
		return portale;
	}
	public final void setPortale(String portale) {
		this.portale = portale;
	}

}
