package it.eng.parer.xmlGen.valanghe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatiSpecificiType", namespace="v", propOrder = {
    "versioneDatiSpecifici",
    "bollettinoValangheID",
    "dataCreazione",
    "compilatoreARPAE",
    "dataInizioValidita",
    "dataFineValidita",
    "approvatoreProtezioneCivile",
    "dataFirmaProtezioneCivile",
    "invioResponsabiliTerritorio",
    "repertoriazione",
    "dataRepertoriazione"
})
public class DatiSpecificiTypeValanghe {

    @XmlElement(name = "VersioneDatiSpecifici", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String versioneDatiSpecifici;
    @XmlElement(name = "BollettinoValangheID", required = true)
    protected String bollettinoValangheID;
    @XmlElement(name = "DataCreazione", required = true)
    @XmlSchemaType(name = "dateTime")
    protected String dataCreazione;
    @XmlElement(name = "Compilatore", required = true)
    protected String compilatoreARPAE;
    @XmlElement(name = "DataInizioValidita", required = true)
    @XmlSchemaType(name = "dateTime")
    protected String dataInizioValidita;
    @XmlElement(name = "DataFineValidita", required = true)
    @XmlSchemaType(name = "dateTime")
    protected String dataFineValidita;
    @XmlElement(name = "FirmatarioProtezioneCivile", required = true)
    protected String approvatoreProtezioneCivile;
    @XmlElement(name = "DataFirmaProtezioneCivile", required = true)
    @XmlSchemaType(name = "dateTime")
    protected String dataFirmaProtezioneCivile;
    @XmlElement(name = "InvioResponsabiliTerritorio", required = true)
    protected String invioResponsabiliTerritorio;
    @XmlElement(name = "Repertoriazione", required = true)
    protected String repertoriazione="SI";
    @XmlElement(name = "DataRepertoriazione", required = true)
    @XmlSchemaType(name = "dateTime")
    protected String dataRepertoriazione="";

    /**
     * Gets the value of the versioneDatiSpecifici property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersioneDatiSpecifici() {
        return versioneDatiSpecifici;
    }

    /**
     * Sets the value of the versioneDatiSpecifici property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersioneDatiSpecifici(String value) {
        this.versioneDatiSpecifici = value;
    }

    /**
     * Gets the value of the allertaID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBollettinoValangheID() {
        return bollettinoValangheID;
    }

    /**
     * Sets the value of the allertaID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBollettinoValangheID(String value) {
        this.bollettinoValangheID = value;
    }

    /**
     * Gets the value of the dataCreazione property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public String getDataCreazione() {
        return dataCreazione;
    }

    /**
     * Sets the value of the dataCreazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataCreazione(String value) {
        this.dataCreazione = value;
    }

    /**
     * Gets the value of the compilatoreARPAE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompilatoreARPAE() {
        return compilatoreARPAE;
    }

    /**
     * Sets the value of the compilatoreARPAE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompilatoreARPAE(String value) {
        this.compilatoreARPAE = value;
    }



  

    /**
     * Gets the value of the dataInizioValidita property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public String getDataInizioValidita() {
        return dataInizioValidita;
    }

    /**
     * Sets the value of the dataInizioValidita property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataInizioValidita(String value) {
        this.dataInizioValidita = value;
    }

    /**
     * Gets the value of the dataFineValidita property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public String getDataFineValidita() {
        return dataFineValidita;
    }

    /**
     * Sets the value of the dataFineValidita property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataFineValidita(String value) {
        this.dataFineValidita = value;
    }









    /**
     * Gets the value of the approvatoreProtezioneCivile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApprovatoreProtezioneCivile() {
        return approvatoreProtezioneCivile;
    }

    /**
     * Sets the value of the approvatoreProtezioneCivile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApprovatoreProtezioneCivile(String value) {
        this.approvatoreProtezioneCivile = value;
    }

    /**
     * Gets the value of the dataFirmaProtezioneCivile property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public String getDataFirmaProtezioneCivile() {
        return dataFirmaProtezioneCivile;
    }

    /**
     * Sets the value of the dataFirmaProtezioneCivile property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataFirmaProtezioneCivile(String value) {
        this.dataFirmaProtezioneCivile = value;
        this.dataRepertoriazione = value;
    }

    /**
     * Gets the value of the invioResponsabiliTerritorio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvioResponsabiliTerritorio() {
        return invioResponsabiliTerritorio;
    }

    /**
     * Sets the value of the invioResponsabiliTerritorio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvioResponsabiliTerritorio(String value) {
        this.invioResponsabiliTerritorio = value;
    }

	public String getRepertoriazione() {
		return repertoriazione;
	}

	public void setRepertoriazione(String repertoriazione) {
		this.repertoriazione = repertoriazione;
	}

	public String getDataRepertoriazione() {
		return dataRepertoriazione;
	}

	public void setDataRepertoriazione(String dataRepertoriazione) {
		this.dataRepertoriazione = dataRepertoriazione;
	}
    
    
    
}

