package it.eng.allerter.allerta;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.bollettino.model.BollettinoSensore;
import it.eng.bollettino.model.Stazione;
import it.eng.bollettino.model.StazioneVariabile;
import it.eng.bollettino.model.ValoreSensore;

public class StazioneManager implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6710243607268367888L;
	
	Stazione stazione;
	StazioneVariabile stazioneVariabile;
	Double ultimoLivello;
	Double penultimoLivello;
	String oraUltimoLivello;
	BollettinoSensore sensore;
	BacinoManager parent;
	boolean selezionata;
	String tendenza;
	boolean osservato=false;
	
	String livelloPrevisto;
	String oraPrevista;
	String giornoPrevisto;
	
	boolean oraLegale;
	
	public StazioneManager() {
		oraLegale = TimeZone.getDefault().inDaylightTime( new Date() );

	}
	
	public Stazione getStazione() {
		return stazione;
	}
	public BollettinoSensore getSensore() {
		return this.sensore;
	}
	public void setStazione(Stazione stazione) {
		this.stazione = stazione;
	}
	public StazioneVariabile getStazioneVariabile() {
		return stazioneVariabile;
	}
	public void setStazioneVariabile(StazioneVariabile stazioneVariabile) {
		this.stazioneVariabile = stazioneVariabile;
	}
	public Double getUltimoLivello() {
		return ultimoLivello;
	}
	public void setUltimoLivello(Double ultimoLivello) {
		this.ultimoLivello = ultimoLivello;
	}
	public Double getPenultimoLivello() {
		return penultimoLivello;
	}
	public void setPenultimoLivello(Double penultimoLivello) {
		this.penultimoLivello = penultimoLivello;
	}
	public String getLivelloPrevisto() {
		return livelloPrevisto;
	}
	public void setLivelloPrevisto(String livelloPrevisto) {
		this.livelloPrevisto = livelloPrevisto;
	}
	public String getOraPrevista() {
		return oraPrevista;
	}
	public void setOraPrevista(String oraPrevista) {
		this.oraPrevista = oraPrevista;
	}
	
	public String getGiornoPrevisto() {
		return giornoPrevisto;
	}
	public void setGiornoPrevisto(String giornoPrevisto) {
		this.giornoPrevisto = giornoPrevisto;
	}
	public boolean isSelezionata() {
		//System.out.println("ISSEL " + stazione.getName() + " " +parent.bac.getNome() + " "+selezionata);
		return selezionata;
	}
	public void setSelezionata(boolean selezionata) {
		if (selezionata && parent!=null) parent.setSelezionato(true);
		//System.out.println("SEL " + stazione.getName() + " " +parent.bac.getNome() + " "+selezionata);
		this.selezionata = selezionata;
	}
	public boolean isOsservato() {
		return osservato;
	}
	public void setOsservato(boolean osservato) {
		this.osservato = osservato;
	}
	public String getOraLivelloOsservato(ValoreSensore vs) {
		if (vs==null) return ("N/D");
		return AllertaKeys.TimeFormat.format(processDate(vs.getDatetime()));
	}
	
	public String calcolaTendenza() {
		
		if (ultimoLivello==null || penultimoLivello==null) return "?";
		if (ultimoLivello>penultimoLivello) return "+";
		else if (ultimoLivello<penultimoLivello) return "-";
		else return "=";
		
		
	}
	public String getTendenza() {
		return tendenza;
	}
	public void setTendenza(String tendenza) {
		this.tendenza = tendenza;
	}
	
	
	
	public String getOraUltimoLivello() {
		return oraUltimoLivello;
	}

	public void setOraUltimoLivello(String oraUltimoLivello) {
		this.oraUltimoLivello = oraUltimoLivello;
	}

	public Date processDate(Date d) {
		if (d==null) return null;
		long l = d.getTime();
		if (oraLegale) l += 7200000; else l += 3600000;
		return new Date(l);
	}
	
}
