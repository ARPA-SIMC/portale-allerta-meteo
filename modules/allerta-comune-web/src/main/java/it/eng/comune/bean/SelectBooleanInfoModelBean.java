package it.eng.comune.bean;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class SelectBooleanInfoModelBean {
	
	private Log _log = LogFactoryUtil.getLog(SelectBooleanInfoModelBean.class);
	
	private String piene;
	private String frane;
	private String temporali;
	private String vento;
	private String mareggiate;
	private String neve;
	private String ghiaccio;
	private String ondateDiCalore;
	private String terremoto;	
	private String incendi;
	
	public SelectBooleanInfoModelBean() {
		super();
		this.reset();
	}
	
	private void reset(){		
		
		this.piene="no";
		this.frane="no";
		this.temporali= "no";
		this.vento="no";
		this.mareggiate="no";
		this.neve= "no";
		this.ghiaccio="no";
		this.ondateDiCalore="no";
		this.terremoto = "no";
		this.incendi="no";	
	}

	public  String getPiene() {
		return piene;
	}

	public  void setPiene(String piene) {
		this.piene = piene;
	}

	public  String getIncendi() {
		return incendi;
	}

	public  void setIncendi(String incendi) {
		this.incendi = incendi;
	}

	public  String getTemporali() {
		return temporali;
	}

	public  void setTemporali(String temporali) {
		this.temporali = temporali;
	}

	public  String getNeve() {
		return neve;
	}

	public  void setNeve(String neve) {
		this.neve = neve;
	}

	public  String getTerremoto() {
		return terremoto;
	}

	public  void setTerremoto(String terremoto) {
		this.terremoto = terremoto;
	}

	public final String getVento() {
		return vento;
	}

	public final void setVento(String vento) {
		this.vento = vento;
	}

	public final String getFrane() {
		return frane;
	}

	public final void setFrane(String frane) {
		this.frane = frane;
	}

	public final String getMareggiate() {
		return mareggiate;
	}

	public final void setMareggiate(String mareggiate) {
		this.mareggiate = mareggiate;
	}

	public final String getGhiaccio() {
		return ghiaccio;
	}

	public final void setGhiaccio(String ghiaccio) {
		this.ghiaccio = ghiaccio;
	}

	public final String getOndateDiCalore() {
		return ondateDiCalore;
	}

	public final void setOndateDiCalore(String ondateDiCalore) {
		this.ondateDiCalore = ondateDiCalore;
	}

}
