package it.eng.radarMeteo.bean;

public class InfoValoreBean {
	private String valore;
	private String dataOra;
	
	public InfoValoreBean() {
	}
	public InfoValoreBean(String valore, String dataOra) {
		super();
		this.valore = valore;
		this.dataOra = dataOra;
	}
	public String getValore() {
		return valore;
	}
	public void setValore(String valore) {
		this.valore = valore;
	}
	public String getDataOra() {
		return dataOra;
	}
	public void setDataOra(String dataOra) {
		this.dataOra = dataOra;
	}
	
}
