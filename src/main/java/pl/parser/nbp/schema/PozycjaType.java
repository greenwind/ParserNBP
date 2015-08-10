
package pl.parser.nbp.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pozycjaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pozycjaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nazwa_waluty" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="przelicznik">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="kod_waluty" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="kurs_kupna" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="kurs_sprzedazy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pozycjaType", propOrder = {
    "nazwaWaluty",
    "przelicznik",
    "kodWaluty",
    "kursKupna",
    "kursSprzedazy"
})
public class PozycjaType {

    @XmlElement(name = "nazwa_waluty", required = true)
    protected String nazwaWaluty;
    @XmlElement(required = true)
    protected String przelicznik;
    @XmlElement(name = "kod_waluty", required = true)
    protected String kodWaluty;
    @XmlElement(name = "kurs_kupna", required = true)
    protected String kursKupna;
    @XmlElement(name = "kurs_sprzedazy", required = true)
    protected String kursSprzedazy;

    /**
     * Gets the value of the nazwaWaluty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazwaWaluty() {
        return nazwaWaluty;
    }

    /**
     * Sets the value of the nazwaWaluty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazwaWaluty(String value) {
        this.nazwaWaluty = value;
    }

    /**
     * Gets the value of the przelicznik property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrzelicznik() {
        return przelicznik;
    }

    /**
     * Sets the value of the przelicznik property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrzelicznik(String value) {
        this.przelicznik = value;
    }

    /**
     * Gets the value of the kodWaluty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKodWaluty() {
        return kodWaluty;
    }

    /**
     * Sets the value of the kodWaluty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKodWaluty(String value) {
        this.kodWaluty = value;
    }

    /**
     * Gets the value of the kursKupna property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKursKupna() {
        return kursKupna;
    }

    /**
     * Sets the value of the kursKupna property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKursKupna(String value) {
        this.kursKupna = value;
    }

    /**
     * Gets the value of the kursSprzedazy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKursSprzedazy() {
        return kursSprzedazy;
    }

    /**
     * Sets the value of the kursSprzedazy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKursSprzedazy(String value) {
        this.kursSprzedazy = value;
    }

}
