package it.eng.allerter.allerta;

import java.io.Serializable;
import java.util.List;

public class RigaManager implements Serializable{
	
	List<GrigliaManager> celle;
	String nomeRiga;
	boolean divisa = true;

	public List<GrigliaManager> getCelle() {
		return celle;
	}

	public void setCelle(List<GrigliaManager> celle) {
		this.celle = celle;
	}

	public String getNomeRiga() {
		return nomeRiga;
	}

	public void setNomeRiga(String nomeRiga) {
		this.nomeRiga = nomeRiga;
	}

	public boolean isDivisa() {
		return divisa;
	}

	public void setDivisa(boolean divisa) {
		this.divisa = divisa;
	}

	public String getRowspan() {
		if (divisa)
			return "1";
		else
			return "2";
	}


}
