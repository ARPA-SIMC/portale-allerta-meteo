package it.eng.parer.xmlGen.util;

public enum TipoDatoDaInviare {

	ALLERTA("A"),
	ALLERTA_MAIL("A_M"),
	ALLERTA_SMS("A_S"),
	ALLERTA_BOLLETTINO("A_B"),
	MONITORAGGIO("M"),
	MONITORAGGIO_MAIL("M_M"),
	MONITORAGGIO_SMS("M_S"),
	SUPERAMENTO_MAIL("S_M"),
	SUPERAMENTO_SMS("S_S"),
	VALANGHE("V"),
	VALANGHE_MAIL("V_M"),
	VALANGHE_SMS("V_S");
	
	public String tipoDatoDaInviare;
	
	TipoDatoDaInviare(String tipoDatoDaInviare)
	{
		this.tipoDatoDaInviare = tipoDatoDaInviare;
	}

	public String getTipoDatoDaInviare() {
		return tipoDatoDaInviare;
	}

	public void setTipoDatoDaInviare(String tipoDatoDaInviare) {
		this.tipoDatoDaInviare = tipoDatoDaInviare;
	}
	
}
