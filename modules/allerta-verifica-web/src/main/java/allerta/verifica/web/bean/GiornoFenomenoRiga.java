package allerta.verifica.web.bean;

import java.util.Date;
import java.util.List;

import allerta.catasto.model.Segnalazione;
import allerta.verifica.model.VerificaDato;

public class GiornoFenomenoRiga {
	
	long documento;
	Date giorno;
	long evento;
	String zona;
	
	List<VerificaDato> dati;
	List<Segnalazione> segnalazioni;

	public long getDocumento() {
		return documento;
	}

	public void setDocumento(long documento) {
		this.documento = documento;
	}

	public Date getGiorno() {
		return giorno;
	}

	public void setGiorno(Date giorno) {
		this.giorno = giorno;
	}

	public long getEvento() {
		return evento;
	}

	public void setEvento(long evento) {
		this.evento = evento;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public List<VerificaDato> getDati() {
		return dati;
	}

	public void setDati(List<VerificaDato> dati) {
		this.dati = dati;
	}
	
	public VerificaDato getDato(String nomeDato) {
		return VerificaAllertaBean.filtraDatiUnico(dati, giorno, zona, evento, nomeDato, null);
	}

	public List<Segnalazione> getSegnalazioni() {
		return segnalazioni;
	}

	public void setSegnalazioni(List<Segnalazione> segnalazioni) {
		this.segnalazioni = segnalazioni;
	}
	
	
	

}
