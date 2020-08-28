package it.eng.rubrica.portlet;

import java.util.Map;

import it.eng.allerte.model.RubricaContatto;
import it.eng.allerte.model.RubricaGruppo;
import it.eng.allerte.model.RubricaNominativo;

public class RubricaChange {
	
	public int index;
	public RubricaGruppo gruppo;
	public RubricaNominativo nominativo;
	public RubricaContatto contatto;
	
	public String tipoChange;
	
	//nuovi dati
	public String cognome;
	public String nome;
	public long ruolo;
	public String specificaRuolo;
	public long tipoContatto;
	public String infoContatto;

}
