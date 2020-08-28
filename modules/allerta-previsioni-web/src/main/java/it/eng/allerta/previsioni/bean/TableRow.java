package it.eng.allerta.previsioni.bean;

import java.io.Serializable;

public class TableRow implements Serializable {
	
	private static final long serialVersionUID = -4058769518307687899L;
	private	String header;
	private String tMin;
	private String tMax;
	private	String precipitazioni;
	private	String vento;
	
	
	public String gettMin() {
		return tMin;
	}
	public void settMin(String tMin) {
		this.tMin = tMin;
	}
	public String gettMax() {
		return tMax;
	}
	public void settMax(String tMax) {
		this.tMax = tMax;
	}
	public String getPrecipitazioni() {
		return precipitazioni;
	}
	public void setPrecipitazioni(String precipitazioni) {
		this.precipitazioni = precipitazioni;
	}
	public String getVento() {
		return vento;
	}
	public void setVento(String vento) {
		this.vento = vento;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}


}
