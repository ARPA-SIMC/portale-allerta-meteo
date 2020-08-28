package it.eng.radarMeteo.bean;

import java.sql.Timestamp;
import java.util.ArrayList;

public class BollettinoMonitoraggioBean {
	ArrayList<BacinoMonitoraggioBean> bacino = new ArrayList<BacinoMonitoraggioBean>();
	private String titolo;
	private Timestamp inizioMonitoraggio;
	private Timestamp fineMonitoraggio;
	private String note;
	private String link;
	
	public BollettinoMonitoraggioBean() {
	}

	public ArrayList<BacinoMonitoraggioBean> getBacino() {
		return bacino;
	}

	public void setBacino(ArrayList<BacinoMonitoraggioBean> bacino) {
		this.bacino = bacino;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Timestamp getInizioMonitoraggio() {
		return inizioMonitoraggio;
	}

	public void setInizioMonitoraggio(Timestamp inizioMonitoraggio) {
		this.inizioMonitoraggio = inizioMonitoraggio;
	}

	public Timestamp getFineMonitoraggio() {
		return fineMonitoraggio;
	}

	public void setFineMonitoraggio(Timestamp fineMonitoraggio) {
		this.fineMonitoraggio = fineMonitoraggio;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
}
