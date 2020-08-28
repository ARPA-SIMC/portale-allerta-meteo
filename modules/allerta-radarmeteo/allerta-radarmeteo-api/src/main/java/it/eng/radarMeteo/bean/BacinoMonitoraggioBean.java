package it.eng.radarMeteo.bean;

import java.util.ArrayList;

public class BacinoMonitoraggioBean {
	
	private String nome_bacino;
	private ArrayList<SottoBacinoMonitoraggioBean> sottobacino = new ArrayList<SottoBacinoMonitoraggioBean>();
	private ArrayList<String> comuni = new ArrayList<>();
	private ArrayList<String> province = new ArrayList<>();

	public BacinoMonitoraggioBean() {
		super();
	}

	public String getNome_bacino() {
		return nome_bacino;
	}

	public void setNome_bacino(String nome_bacino) {
		this.nome_bacino = nome_bacino;
	}

	public ArrayList<SottoBacinoMonitoraggioBean> getSottobacino() {
		return sottobacino;
	}

	public void setSottobacino(ArrayList<SottoBacinoMonitoraggioBean> sottobacino) {
		this.sottobacino = sottobacino;
	}

	public ArrayList<String> getComuni() {
		return comuni;
	}

	public void setComuni(ArrayList<String> comuni) {
		this.comuni = comuni;
	}

	public ArrayList<String> getProvince() {
		return province;
	}

	public void setProvince(ArrayList<String> province) {
		this.province = province;
	}
	
	
}
