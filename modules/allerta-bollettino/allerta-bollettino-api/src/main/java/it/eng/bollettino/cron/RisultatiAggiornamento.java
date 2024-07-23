package it.eng.bollettino.cron;

public class RisultatiAggiornamento {
	
	public int aggiunti = 0;
	public int rimossi = 0;
	public int modificati = 0;
	public String errore = null;
	public String nomiAggiunti = null;
	public String nomiRimossi = null;
	public String nomiModificati = null;
	
	public void aggiungi(String stazione) {
		if (nomiAggiunti==null) nomiAggiunti = stazione;
		else nomiAggiunti+=","+stazione;
	}
	
	public void modifica(String stazione) {
		if (nomiModificati==null) nomiModificati = stazione;
		else nomiModificati+=","+stazione;
	}
	
	public void rimuovi(String stazione) {
		if (nomiRimossi==null) nomiRimossi = stazione;
		else nomiRimossi+=","+stazione;
	}
	
	public String toString() {
		String s ="";
		if (nomiAggiunti!=null) {
			s+="record aggiunti: "+nomiAggiunti+"; ";
		}
		if (nomiModificati!=null) {
			s+="record modificati: "+nomiModificati+"; ";
		}
		if (nomiRimossi!=null) {
			s+="record rimossi: "+nomiRimossi+"; ";
		}
		
		return s;
	}

}
