package it.eng.allerter.allerta;

import java.io.Serializable;

import it.eng.allerter.model.AllertaStato;

public class CellaManager implements Serializable {

	int riga;
	int colonna;
	int sottoriga;
	int valore = 1000;
	AllertaStato stato;

	public AllertaStato getStato() {
		return stato;
	}

	public void setStato(AllertaStato stato) {
		this.stato = stato;
	}

	public int getRiga() {
		return riga;
	}

	public void setRiga(int riga) {
		this.riga = riga;
	}

	public int getColonna() {
		return colonna;
	}

	public void setColonna(int colonna) {
		this.colonna = colonna;
	}

	public int getSottoriga() {
		return sottoriga;
	}

	public void setSottoriga(int sottoriga) {
		this.sottoriga = sottoriga;
	}

	public int getValore() {
		return valore;
	}

	public void setValore(int valore) {
		this.valore = valore;
	}

	public String getStringaColore() {

		if (valore == 1000)
			return "";
		if (valore == 0)
			return "VERDE";
		if (valore == 1)
			return "GIALLO";
		if (valore == 2)
			return "ARANCIONE";
		if (valore == 3)
			return "ROSSO";
		return "";
	}

}
