package it.eng.parer.xmlGen.valanghe.sms;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for DatiSpecificiType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DatiSpecificiType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VersioneDatiSpecifici" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *         &lt;element name="NumeroAllerta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DataGenerazione" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="NumeroSMSGenerati" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="NumeroSMSInviati" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="NumeroNotificheDiRicezione" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="DenominazioneApplicativo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatiSpecificiType", namespace="vs", propOrder = {
    "versioneDatiSpecifici",
    "numeroComunicazione",
    "tipoComunicazione",
    "dataGenerazione",
    "numeroSMSGenerati",
    "numeroSMSInviati",
    "numeroNotificheDiRicezione",
    "denominazioneApplicativo"
})
public class DatiSpecificiTypeValangheSms {

    @XmlElement(name = "VersioneDatiSpecifici", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String versioneDatiSpecifici;
    @XmlElement(name = "NumeroComunicazione", required = true)
    protected String numeroComunicazione;
    @XmlElement(name = "TipoComunicazione", required = true)
    protected String tipoComunicazione;
    @XmlElement(name = "DataGenerazione", required = true)
    @XmlSchemaType(name = "dateTime")
    protected String dataGenerazione;
    @XmlElement(name = "NumeroSMSGenerati", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numeroSMSGenerati;
    @XmlElement(name = "NumeroSMSInviati", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numeroSMSInviati;
    @XmlElement(name = "NumeroNotificheDiRicezione", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numeroNotificheDiRicezione;
    @XmlElement(name = "DenominazioneApplicativo", required = true)
    protected String denominazioneApplicativo;

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

//    /**
//     * Gets the value of the numeroAllerta property.
//     * 
//     * @return
//     *     possible object is
//     *     {@link String }
//     *     
//     */
//    public String getNumeroAllerta() {
//        return numeroAllerta;
//    }
//
//    /**
//     * Sets the value of the numeroAllerta property.
//     * 
//     * @param value
//     *     allowed object is
//     *     {@link String }
//     *     
//     */
//    public void setNumeroAllerta(String value) {
//        this.numeroAllerta = value;
//    }

    /**
     * Gets the value of the dataGenerazione property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public String getDataGenerazione() {
        return dataGenerazione;
    }

    /**
     * Sets the value of the dataGenerazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataGenerazione(String value) {
        this.dataGenerazione = value;
    }

    /**
     * Gets the value of the numeroSMSGenerati property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumeroSMSGenerati() {
        return numeroSMSGenerati;
    }

    /**
     * Sets the value of the numeroSMSGenerati property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumeroSMSGenerati(BigInteger value) {
        this.numeroSMSGenerati = value;
    }

    /**
     * Gets the value of the numeroSMSInviati property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumeroSMSInviati() {
        return numeroSMSInviati;
    }

    /**
     * Sets the value of the numeroSMSInviati property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumeroSMSInviati(BigInteger value) {
        this.numeroSMSInviati = value;
    }

    /**
     * Gets the value of the numeroNotificheDiRicezione property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumeroNotificheDiRicezione() {
        return numeroNotificheDiRicezione;
    }

    /**
     * Sets the value of the numeroNotificheDiRicezione property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumeroNotificheDiRicezione(BigInteger value) {
        this.numeroNotificheDiRicezione = value;
    }

    /**
     * Gets the value of the denominazioneApplicativo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominazioneApplicativo() {
        return denominazioneApplicativo;
    }

    /**
     * Sets the value of the denominazioneApplicativo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominazioneApplicativo(String value) {
        this.denominazioneApplicativo = value;
    }
    /**
     * Gets the value of the numeroComunicazione property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroComunicazione() {
        return numeroComunicazione;
    }

    /**
     * Sets the value of the numeroComunicazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroComunicazione(String value) {
        this.numeroComunicazione = value;
    }

    /**
     * Gets the value of the tipoComunicazione property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoComunicazione() {
        return tipoComunicazione;
    }

    /**
     * Sets the value of the tipoComunicazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoComunicazione(String value) {
        this.tipoComunicazione = value;
    }

}
