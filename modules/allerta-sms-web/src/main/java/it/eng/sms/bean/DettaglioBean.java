package it.eng.sms.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DettaglioBean {
	
	private String id;
	private String destinatario;
	private String numero;
	private String stato;
	private String testo;
	private String dataGenerazione;
	private String dataSpedizione;
	private String dataRicevuta;
	private String successoContatto;
	private String successoDestinatario;
	private long idDestinatario;
	
	SimpleDateFormat formatterFrom = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	SimpleDateFormat formatterTo = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public String getDataGenerazione() {
		try {
			return formatterTo.format(formatterFrom.parse(dataGenerazione));
		} catch (ParseException e) {
			return "";
		}
	}
	public void setDataGenerazione(String dataGenerazione) {
		this.dataGenerazione = dataGenerazione;
	}
	public String getDataSpedizione() {
		try {
			return formatterTo.format(formatterFrom.parse(dataSpedizione));
		} catch (ParseException e) {
			return "";
		}
	}
	public void setDataSpedizione(String dataSpedizione) {
		this.dataSpedizione = dataSpedizione;
	}
	public String getDataRicevuta() {
		try {
			return formatterTo.format(formatterFrom.parse(dataRicevuta));
		} catch (ParseException e) {
			return "";
		}
	}
	public void setDataRicevuta(String dataRicevuta) {
		
		this.dataRicevuta = dataRicevuta;
	}
	public String getSuccessoContatto() {
		return successoContatto.equals("true") ? "SI" : "NO";
	}
	public void setSuccessoContatto(String successoContatto) {
		this.successoContatto = successoContatto;
	}
	public String getSuccessoDestinatario() {
		return successoDestinatario.equals("true") ? "SI" : "NO";
	}
	public void setSuccessoDestinatario(String successoDestinatario) {
		this.successoDestinatario = successoDestinatario;
	}
	public long getIdDestinatario() {
		return idDestinatario;
	}
	public void setIdDestinatario(long idDestinatario) {
		this.idDestinatario = idDestinatario;
	}
	
	

}
