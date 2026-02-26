package it.eng.allerta.controlpanel.portlet;

public class InvioBean {
	
	String tipo;
	String sottotipo;
	long param;
	String testo;
	int inviati;
	int ricevuti;
	double tasso;
	String esempi;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSottotipo() {
		return sottotipo;
	}
	public void setSottotipo(String sottotipo) {
		this.sottotipo = sottotipo;
	}
	public long getParam() {
		return param;
	}
	public void setParam(long param) {
		this.param = param;
	}
	public int getInviati() {
		return inviati;
	}
	public void setInviati(int inviati) {
		this.inviati = inviati;
	}
	public int getRicevuti() {
		return ricevuti;
	}
	public void setRicevuti(int ricevuti) {
		this.ricevuti = ricevuti;
	}
	public double getTasso() {
		return tasso;
	}
	public void setTasso(double tasso) {
		this.tasso = tasso;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public String getEsempi() {
		return esempi;
	}
	public void setEsempi(String esempi) {
		this.esempi = esempi;
	}
	
	

}
