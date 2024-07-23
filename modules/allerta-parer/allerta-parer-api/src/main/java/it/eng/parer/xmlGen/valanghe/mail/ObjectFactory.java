package it.eng.parer.xmlGen.valanghe.mail;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.eng.javaClass package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DatiSpecifici_QNAME = new QName("", "DatiSpecifici");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.eng.javaClass
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DatiSpecificiTypeMail }
     * 
     */
    public DatiSpecificiTypeValangheMail createDatiSpecificiType() {
        return new DatiSpecificiTypeValangheMail();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatiSpecificiTypeMail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DatiSpecifici")
    public JAXBElement<DatiSpecificiTypeValangheMail> createDatiSpecifici(DatiSpecificiTypeValangheMail value) {
        return new JAXBElement<DatiSpecificiTypeValangheMail>(_DatiSpecifici_QNAME, DatiSpecificiTypeValangheMail.class, null, value);
    }
    
}
