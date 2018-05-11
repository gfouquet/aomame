
package fr.armida.aomame.domain.listxml;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "instance")
public class Instance {

    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "briefname", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String briefname;

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
     * Obtient la valeur de la propriete briefname.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBriefname() {
        return briefname;
    }

    /**
     * Definit la valeur de la propriete briefname.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBriefname(String value) {
        this.briefname = value;
    }

}
