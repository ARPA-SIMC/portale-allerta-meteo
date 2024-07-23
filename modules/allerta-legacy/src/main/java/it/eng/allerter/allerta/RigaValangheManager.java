package it.eng.allerter.allerta;

import java.io.Serializable;
import java.util.List;

public class RigaValangheManager implements Serializable {
	
	private static final long serialVersionUID = 319973041020337807L;
	
	List<GrigliaValangheManager> celle;
	String nomeRiga;
	boolean divisa = true;

	public List<GrigliaValangheManager> getCelle() {
		return celle;
	}

	public void setCelle(List<GrigliaValangheManager> celle) {
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
