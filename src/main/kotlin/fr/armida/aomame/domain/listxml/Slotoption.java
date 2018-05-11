
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
@XmlRootElement(name = "slotoption")
public class Slotoption {

    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "devname", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String devname;
    @XmlAttribute(name = "default")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String _default;

    /**
     * Obtient la valeur de la propriete name.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Definit la valeur de la propriete name.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtient la valeur de la propriete devname.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDevname() {
        return devname;
    }

    /**
     * Definit la valeur de la propriete devname.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDevname(String value) {
        this.devname = value;
    }

    /**
     * Obtient la valeur de la propriete default.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDefault() {
        if (_default == null) {
            return "no";
        } else {
            return _default;
        }
    }

    /**
     * Definit la valeur de la propriete default.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDefault(String value) {
        this._default = value;
    }

}
