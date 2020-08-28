package it.eng.sms.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EventiBean {

	private String id;
	private String evento;
	private String tipoEvento;
	private String dataGenerazione;
	private String smsGenerati;
	private String smsSpediti;
	private String smsConsegnati;
	private String percSuccesso;
	private String ultimoAggiornamento;
	private String link;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEvento() {
		return evento;
	}
	public void setEvento(String evento) {
		this.evento = evento;
	}
	public String getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public String getDataGenerazione() {
		
		SimpleDateFormat formatterFrom = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat formatterTo = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try {
			return formatterTo.format(formatterFrom.parse(dataGenerazione));
		} catch (ParseException e) {
			return "";
		}
	}
	public void setDataGenerazione(String dataGenerazione) {
		this.dataGenerazione = dataGenerazione;
	}
	public String getSmsGenerati() {
		return smsGenerati;
	}
	public void setSmsGenerati(String smsGenerati) {
		this.smsGenerati = smsGenerati;
	}
	public String getSmsSpediti() {
		return smsSpediti;
	}
	public void setSmsSpediti(String smsSpediti) {
		this.smsSpediti = smsSpediti;
	}
	public String getSmsConsegnati() {
		return smsConsegnati;
	}
	public void setSmsConsegnati(String smsConsegnati) {
		this.smsConsegnati = smsConsegnati;
	}
	public String getPercSuccesso() {
		return  String.format("%.2f", Double.valueOf( percSuccesso));
	}
	public void setPercSuccesso(String percSuccesso) {
		this.percSuccesso = percSuccesso;
	}
	public String getUltimoAggiornamento() {
		SimpleDateFormat formatterFrom = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat formatterTo = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try {
			return formatterTo.format(formatterFrom.parse(ultimoAggiornamento));
		} catch (ParseException e) {
			return "";
		}
	}
	public void setUltimoAggiornamento(String ultimoAggiornamento) {
		this.ultimoAggiornamento = ultimoAggiornamento;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
}
