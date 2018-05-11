
package fr.armida.aomame.domain.listxml;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "control")
public class Control {

    @XmlAttribute(name = "type", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String type;
    @XmlAttribute(name = "minimum")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String minimum;
    @XmlAttribute(name = "maximum")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String maximum;
    @XmlAttribute(name = "sensitivity")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String sensitivity;
    @XmlAttribute(name = "keydelta")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String keydelta;
    @XmlAttribute(name = "reverse")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String reverse;
    @XmlAttribute(name = "ways")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String ways;
    @XmlAttribute(name = "ways2")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String ways2;
    @XmlAttribute(name = "ways3")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String ways3;

    /**
     * Obtient la valeur de la propriete type.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getType() {
        return type;
    }

    /**
     * Definit la valeur de la propriete type.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Obtient la valeur de la propriete minimum.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMinimum() {
        return minimum;
    }

    /**
     * Definit la valeur de la propriete minimum.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMinimum(String value) {
        this.minimum = value;
    }

    /**
     * Obtient la valeur de la propriete maximum.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMaximum() {
        return maximum;
    }

    /**
     * Definit la valeur de la propriete maximum.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMaximum(String value) {
        this.maximum = value;
    }

    /**
     * Obtient la valeur de la propriete sensitivity.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSensitivity() {
        return sensitivity;
    }

    /**
     * Definit la valeur de la propriete sensitivity.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSensitivity(String value) {
        this.sensitivity = value;
    }

    /**
     * Obtient la valeur de la propriete keydelta.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getKeydelta() {
        return keydelta;
    }

    /**
     * Definit la valeur de la propriete keydelta.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setKeydelta(String value) {
        this.keydelta = value;
    }

    /**
     * Obtient la valeur de la propriete reverse.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReverse() {
        if (reverse == null) {
            return "no";
        } else {
            return reverse;
        }
    }

    /**
     * Definit la valeur de la propriete reverse.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReverse(String value) {
        this.reverse = value;
    }

    /**
     * Obtient la valeur de la propriete ways.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWays() {
        return ways;
    }

    /**
     * Definit la valeur de la propriete ways.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWays(String value) {
        this.ways = value;
    }

    /**
     * Obtient la valeur de la propriete ways2.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWays2() {
        return ways2;
    }

    /**
     * Definit la valeur de la propriete ways2.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWays2(String value) {
        this.ways2 = value;
    }

    /**
     * Obtient la valeur de la propriete ways3.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWays3() {
        return ways3;
    }

    /**
     * Definit la valeur de la propriete ways3.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWays3(String value) {
        this.ways3 = value;
    }

}
