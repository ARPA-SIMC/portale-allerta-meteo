package allerta.verifica.web.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import allerta.verifica.model.VerificaDato;

public class GiornoPrecipitazioni {
	
	public static String[] righe = {"A","B","C","D","E","F","G","H"};
	
	List<RigaPrecipitazioni> precipitazioni;
	Date giorno;
	VerificaDato fenomeniGiorno;
	
	public GiornoPrecipitazioni(Date g, List<VerificaDato> dati, Long allerta) {
		giorno = g;
		
		precipitazioni = new ArrayList<RigaPrecipitazioni>();
		fenomeniGiorno = VerificaAllertaBean.filtraDatiUnico(dati,allerta,giorno,null,null,"precipitazioni_fenom",null);
		
		for (String riga : righe)
			precipitazioni.add(new RigaPrecipitazioni(giorno,riga,VerificaAllertaBean.filtraDati(dati, allerta, null, riga, null, null, null)));
		
	}

	public Date getGiorno() {
		return giorno;
	}

	public void setGiorno(Date giorno) {
		this.giorno = giorno;
	}

	public List<RigaPrecipitazioni> getPrecipitazioni() {
		return precipitazioni;
	}

	public void setPrecipitazioni(List<RigaPrecipitazioni> precipitazioni) {
		this.precipitazioni = precipitazioni;
	}

	public VerificaDato getFenomeniGiorno() {
		return fenomeniGiorno;
	}

	public void setFenomeniGiorno(VerificaDato fenomeniGiorno) {
		this.fenomeniGiorno = fenomeniGiorno;
	}
	
	

}
