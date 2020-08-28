package it.eng.radarMeteo.bean;

public class SottoBacinoMonitoraggioBean {
	
	private String nomeSottobacino;
	private InfoValoreBean osservazione;
	private InfoValoreBean colmo_previsto;

	public String getNomeSottobacino() {
		return nomeSottobacino;
	}

	public void setNomeSottobacino(String nomeSottobacino) {
		this.nomeSottobacino = nomeSottobacino;
	}

	public InfoValoreBean getOsservazione() {
		return osservazione;
	}

	public void setOsservazione(InfoValoreBean osservazione) {
		this.osservazione = osservazione;
	}

	public InfoValoreBean getColmo_previsto() {
		return colmo_previsto;
	}

	public void setColmo_previsto(InfoValoreBean colmo_previsto) {
		this.colmo_previsto = colmo_previsto;
	}
	
}
