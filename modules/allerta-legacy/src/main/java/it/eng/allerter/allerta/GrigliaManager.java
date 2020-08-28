package it.eng.allerter.allerta;

import java.io.Serializable;
import java.util.List;

public class GrigliaManager implements Serializable  {

	List<CellaManager> valori;

	int riga;
	int colonna;

	String area;
	String nomeEvento;
	int idEvento;

	public List<CellaManager> getValori() {
		return valori;
	}

	public void setValori(List<CellaManager> valori) {
		this.valori = valori;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getRowspan() {
		if (valori != null && valori.size() > 1)
			return "1";
		else
			return "2";
	}

	public String getStyle1() {
		String s = "";
		if (colonna == 3 || colonna == 7)
			s += "bordodestro ";
		if (valori != null && valori.size() > 0)
			s += "cellaAllerta" + valori.get(0).valore;

		return s;
	}

	public String getStyle2() {
		String s = "";
		if (colonna == 3 || colonna == 7)
			s += "bordodestro ";
		if (valori != null && valori.size() > 1)
			s += "cellaAllerta" + valori.get(1).valore;

		return s;
	}

	public String getStringaColore1() {
		if (valori != null && valori.size() > 0)
			return valori.get(0).getStringaColore();
		return " ";
	}

	public String getStringaColore2() {
		if (valori != null && valori.size() > 1)
			return valori.get(1).getStringaColore();
		return " ";
	}

}
