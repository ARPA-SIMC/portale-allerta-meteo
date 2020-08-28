package it.eng.allerte.custom.jsonRubrica;

public class NominativeCSV {

	private Long id;
	private String nome;
	private String cognome;
	private String indirizzo;
	private String tipoContatto;
	private String contatto;
	private boolean allertamento;
	private Long disambiguatore;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getTipoContatto() {
		return tipoContatto;
	}
	public void setTipoContatto(String tipoContatto) {
		this.tipoContatto = tipoContatto;
	}
	public String getContatto() {
		return contatto;
	}
	public void setContatto(String contatto) {
		this.contatto = contatto;
	}
	public boolean isAllertamento() {
		return allertamento;
	}
	public void setAllertamento(boolean allertamento) {
		this.allertamento = allertamento;
	}
	public Long getDisambiguatore() {
		return disambiguatore;
	}
	public void setDisambiguatore(Long disambiguatore) {
		this.disambiguatore = disambiguatore;
	}
			
}
