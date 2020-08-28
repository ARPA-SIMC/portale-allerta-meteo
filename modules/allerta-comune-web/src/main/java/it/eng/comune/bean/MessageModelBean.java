package it.eng.comune.bean;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class MessageModelBean {

	private Log _log = LogFactoryUtil.getLog(MessageModelBean.class);

	// Dati inseriti dalla maschera 
	private String   obj_mail;
	private String   mex_pc;
	private String  subject;
	private Boolean  show_pc;
	
	public MessageModelBean() {
		
		super();
		this.reset();			
	}

	private void reset(){
		
		 _log.info("RESET MESSAGE MODEL BEAN");
		this.subject="";
		this.mex_pc="";
		this.obj_mail="";
	}

	public final String getSubject() {
		return subject;
	}
	public final void setSubject(String subject) {
		this.subject = subject;
	}
	public final String getMex_pc() {
		return mex_pc;
	}
	public final void setMex_pc(String mex_pc) {
		this.mex_pc = mex_pc;
	}

	public final Boolean getShow_pc() {
		return show_pc;
	}
	
	public final String getObj_mail() {
		return obj_mail;
	}

	public final void setObj_mail(String obj_mail) {
		this.obj_mail = obj_mail;
	}

	// Aggiungo metodi che mi permettono di capire se mostrare o meno i dati da interfaccia
	// in base al fatto che dati aggiuntivi sono inseriti 
	public final void setShow_pc(Boolean show_pc) {

		if(this.mex_pc!=null &&mex_pc.length()>0){
			this.show_pc = true;

		}else {
			this.show_pc = false;
		}

	}

}
