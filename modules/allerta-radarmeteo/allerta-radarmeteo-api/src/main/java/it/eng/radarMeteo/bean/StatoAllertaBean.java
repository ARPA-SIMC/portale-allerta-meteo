package it.eng.radarMeteo.bean;

import java.util.ArrayList;

public class StatoAllertaBean {
	private String nome;
	private String idraulica;
	private String idrogeologica;
	private String temporali;
	private String vento;
	private String temperature_estreme;
	private String neve;
	private String ghiaccio_pioggia_gela;
	private String stato_mare;
	private String mareggiate;
	
	ArrayList<String> comuni = new ArrayList<>();
	ArrayList<String> province = new ArrayList<>();
	
	public StatoAllertaBean() {
	}

	public StatoAllertaBean(String idraulica, String idrogeologica, String temporali,
			String vento, String temperature_estreme, String neve, String ghiaccio_pioggia_gela, String stato_mare,
			String mareggiate) {
		super();
		this.idraulica = idraulica;
		this.idrogeologica = idrogeologica;
		this.temporali = temporali;
		this.vento = vento;
		this.temperature_estreme = temperature_estreme;
		this.neve = neve;
		this.ghiaccio_pioggia_gela = ghiaccio_pioggia_gela;
		this.stato_mare = stato_mare;
		this.mareggiate = mareggiate;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdraulica() {
		return idraulica;
	}

	public void setIdraulica(String idraulica) {
		this.idraulica = idraulica;
	}

	public String getIdrogeologica() {
		return idrogeologica;
	}

	public void setIdrogeologica(String idrogeologica) {
		this.idrogeologica = idrogeologica;
	}

	public String getTemporali() {
		return temporali;
	}

	public void setTemporali(String temporali) {
		this.temporali = temporali;
	}

	public String getVento() {
		return vento;
	}

	public void setVento(String vento) {
		this.vento = vento;
	}

	public String getTemperature_estreme() {
		return temperature_estreme;
	}

	public void setTemperature_estreme(String temperature_estreme) {
		this.temperature_estreme = temperature_estreme;
	}

	public String getNeve() {
		return neve;
	}

	public void setNeve(String neve) {
		this.neve = neve;
	}

	public String getGhiaccio_pioggia_gela() {
		return ghiaccio_pioggia_gela;
	}

	public void setGhiaccio_pioggia_gela(String ghiaccio_pioggia_gela) {
		this.ghiaccio_pioggia_gela = ghiaccio_pioggia_gela;
	}

	public String getStato_mare() {
		return stato_mare;
	}

	public void setStato_mare(String stato_mare) {
		this.stato_mare = stato_mare;
	}

	public String getMareggiate() {
		return mareggiate;
	}

	public void setMareggiate(String mareggiate) {
		this.mareggiate = mareggiate;
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
