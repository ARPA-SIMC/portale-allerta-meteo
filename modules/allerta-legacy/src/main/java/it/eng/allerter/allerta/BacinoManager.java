package it.eng.allerter.allerta;

import java.io.Serializable;
import java.util.List;

import it.eng.allerter.allerta.StazioneManager;
import it.eng.bollettino.model.Bacino;
import it.eng.bollettino.model.BollettinoBacino;

public class BacinoManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8574024203940587884L;
	boolean selezionato;
	Bacino bac;
	BollettinoBacino bacino;
	List<StazioneManager> stazioni;
	
	
	String note;
	String ore;
	
//	public void panelListener(PanelToggleEvent pte) {
//		selezionato = pte.getExpanded();
//	}

	public Bacino getBac() {
		return bac;
	}

	public void setBac(Bacino bac) {
		this.bac = bac;
	}

	public BollettinoBacino getBacino() {
		return bacino;
	}

	public void setBacino(BollettinoBacino bacino) {
		this.bacino = bacino;
	}

	public List<StazioneManager> getStazioni() {
		return stazioni;
	}

	public void setStazioni(List<StazioneManager> stazioni) {
		this.stazioni = stazioni;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getOre() {
		return ore;
	}

	public void setOre(String ore) {
		this.ore = ore;
	}

	public boolean isSelezionato() {
		return selezionato;
	}

	public void setSelezionato(boolean selezionato) {
		this.selezionato = selezionato;
	}
	
	
}
