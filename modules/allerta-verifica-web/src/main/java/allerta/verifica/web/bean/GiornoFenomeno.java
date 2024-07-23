package allerta.verifica.web.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import allerta.verifica.model.VerificaDato;

public class GiornoFenomeno {
	
	long documento;
	Date giorno;
	long evento;
	List<VerificaDato> dati;
	
	List<GiornoFenomenoRiga> righe = new ArrayList<GiornoFenomenoRiga>();

	public long getDocumento() {
		return documento;
	}

	public void setDocumento(long documento) {
		this.documento = documento;
	}

	public Date getGiorno() {
		return giorno;
	}

	public void setGiorno(Date giorno) {
		this.giorno = giorno;
	}

	public long getEvento() {
		return evento;
	}

	public void setEvento(long evento) {
		this.evento = evento;
	}

	public List<GiornoFenomenoRiga> getRighe() {
		return righe;
	}

	public void setRighe(List<GiornoFenomenoRiga> righe) {
		this.righe = righe;
	}

	public List<VerificaDato> getDati() {
		return dati;
	}

	public void setDati(List<VerificaDato> dati) {
		this.dati = dati;
	}
	
	public VerificaDato getDato(String nomeDato) {
		return VerificaAllertaBean.filtraDatiUnico(dati, giorno, null, evento, nomeDato, null);
	}

}
