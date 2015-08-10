package pl.parser.nbp.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * @author Piotr Janik
 */
@XmlEnum
public enum Currency {
    @XmlEnumValue("USD")
    USD,

    @XmlEnumValue("EUR")
    EUR,

    @XmlEnumValue("CHF")
    CHF,

    @XmlEnumValue("GBP")
    GBP
}
