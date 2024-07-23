package allerta.verifica.web.bean;

import java.util.Date;
import java.util.List;

import allerta.verifica.model.VerificaDato;

public class RigaPrecipitazioni {
	
	String zona;
	Date giorno;
	VerificaDato osservate;
	VerificaDato previste;
	VerificaDato note;
	
	public RigaPrecipitazioni(Date g, String z, List<VerificaDato> l) {
		giorno = g;
		zona = z;
		
		osservate = VerificaAllertaBean.filtraDatiUnico(l, null, null, null, 
				"precipitazioni_osservate", null);
		previste = VerificaAllertaBean.filtraDatiUnico(l, null, null, null, 
				"precipitazioni_previste", null);
		note = VerificaAllertaBean.filtraDatiUnico(l, null, null, null, 
				"precipitazioni_note", null); 
		
		if (osservate==null)
			osservate = VerificaAllertaBean.nuovoVerificaDato
			(null, g, z, null, "precipitazioni_osservate", null);
		
		if (previste==null)
			previste = VerificaAllertaBean.nuovoVerificaDato
			(null, g, z, null, "precipitazioni_previste", null);
		
		if (note==null)
			previste = VerificaAllertaBean.nuovoVerificaDato
			(null, g, z, null, "precipitazioni_note", null);
	}
	
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public Date getGiorno() {
		return giorno;
	}
	public void setGiorno(Date giorno) {
		this.giorno = giorno;
	}
	public VerificaDato getOsservate() {
		return osservate;
	}
	public void setOsservate(VerificaDato osservate) {
		this.osservate = osservate;
	}
	public VerificaDato getPreviste() {
		return previste;
	}
	public void setPreviste(VerificaDato previste) {
		this.previste = previste;
	}
	public VerificaDato getNote() {
		return note;
	}
	public void setNote(VerificaDato note) {
		this.note = note;
	}
	
	

}
