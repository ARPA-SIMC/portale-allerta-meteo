package it.eng.parer.bean;

import java.util.ArrayList;
import java.util.List;

import it.eng.parer.model.DatiSpecificiInvio;
import it.eng.parer.model.DocumentiCollegati;
import it.eng.parer.model.ComponentiInvio;;

public class DatiSpecificiBean {

	private DatiSpecificiInvio datiSpecifici;
	private List<DocumentiCollegati> documentiCollegati = new ArrayList<>();
	private List<ComponentiInvio> componenti = new ArrayList<>();
	
	public DatiSpecificiInvio getDatiSpecifici() {
		return datiSpecifici;
	}
	public void setDatiSpecifici(DatiSpecificiInvio datiSpecifici) {
		this.datiSpecifici = datiSpecifici;
	}
	
	public List<DocumentiCollegati> getDocumentiCollegati() {
		return documentiCollegati;
	}
	public void setDocumentiCollegati(List<DocumentiCollegati> documentiCollegati) {
		this.documentiCollegati = documentiCollegati;
	}
	
	public List<ComponentiInvio> getComponenti() {
		return componenti;
	}
	public void setComponenti(List<ComponentiInvio> componenti) {
		this.componenti = componenti;
	}
	
}
