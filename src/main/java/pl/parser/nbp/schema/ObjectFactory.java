
package pl.parser.nbp.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the schema package. 
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

    private final static QName _TabelaKursow_QNAME = new QName("", "tabela_kursow");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TabelaKursowType }
     * 
     */
    public TabelaKursowType createTabelaKursowType() {
        return new TabelaKursowType();
    }

    /**
     * Create an instance of {@link PozycjaType }
     * 
     */
    public PozycjaType createPozycjaType() {
        return new PozycjaType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TabelaKursowType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "tabela_kursow")
    public JAXBElement<TabelaKursowType> createTabelaKursow(TabelaKursowType value) {
        return new JAXBElement<TabelaKursowType>(_TabelaKursow_QNAME, TabelaKursowType.class, null, value);
    }

}
