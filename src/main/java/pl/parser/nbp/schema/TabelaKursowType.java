
package pl.parser.nbp.schema;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tabela_kursowType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tabela_kursowType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numer_tabeli" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="data_notowania" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="data_publikacji" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pozycja" type="{}pozycjaType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="typ" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tabela_kursowType", propOrder = {
    "numerTabeli",
    "dataNotowania",
    "dataPublikacji",
    "pozycja"
})
public class TabelaKursowType {

    @XmlElement(name = "numer_tabeli", required = true)
    protected String numerTabeli;
    @XmlElement(name = "data_notowania", required = true)
    protected String dataNotowania;
    @XmlElement(name = "data_publikacji", required = true)
    protected String dataPublikacji;
    protected List<PozycjaType> pozycja;
    @XmlAttribute(name = "typ")
    protected String typ;

    /**
     * Gets the value of the numerTabeli property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumerTabeli() {
        return numerTabeli;
    }

    /**
     * Sets the value of the numerTabeli property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumerTabeli(String value) {
        this.numerTabeli = value;
    }

    /**
     * Gets the value of the dataNotowania property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataNotowania() {
        return dataNotowania;
    }

    /**
     * Sets the value of the dataNotowania property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataNotowania(String value) {
        this.dataNotowania = value;
    }

    /**
     * Gets the value of the dataPublikacji property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataPublikacji() {
        return dataPublikacji;
    }

    /**
     * Sets the value of the dataPublikacji property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataPublikacji(String value) {
        this.dataPublikacji = value;
    }

    /**
     * Gets the value of the pozycja property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pozycja property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPozycja().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PozycjaType }
     * 
     * 
     */
    public List<PozycjaType> getPozycja() {
        if (pozycja == null) {
            pozycja = new ArrayList<PozycjaType>();
        }
        return this.pozycja;
    }

    /**
     * Gets the value of the typ property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTyp() {
        return typ;
    }

    /**
     * Sets the value of the typ property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTyp(String value) {
        this.typ = value;
    }

}
