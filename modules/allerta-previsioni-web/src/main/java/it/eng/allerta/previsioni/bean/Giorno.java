package it.eng.allerta.previsioni.bean;

import java.io.Serializable;

public class Giorno implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nome;
	private String cielo;
	private String temperatura;
	private String vento;
	private String mare;

	public String getCielo() {
		return cielo;
	}
	public void setCielo(String cielo) {
		this.cielo = cielo;
	}
	public String getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}
	public String getVento() {
		return vento;
	}
	public void setVento(String vento) {
		this.vento = vento;
	}
	public String getMare() {
		return mare;
	}
	public void setMare(String mare) {
		this.mare = mare;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
