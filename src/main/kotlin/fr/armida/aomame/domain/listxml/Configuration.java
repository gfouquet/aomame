
package fr.armida.aomame.domain.listxml;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;


/**
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "confsetting"
})
@XmlRootElement(name = "configuration")
public class Configuration {

    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "tag", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String tag;
    @XmlAttribute(name = "mask", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String mask;
    protected List<Confsetting> confsetting;

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
     * Obtient la valeur de la propriete tag.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTag() {
        return tag;
    }

    /**
     * Definit la valeur de la propriete tag.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTag(String value) {
        this.tag = value;
    }

    /**
     * Obtient la valeur de la propriete mask.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMask() {
        return mask;
    }

    /**
     * Definit la valeur de la propriete mask.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMask(String value) {
        this.mask = value;
    }

    /**
     * Gets the value of the confsetting property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the confsetting property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConfsetting().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Confsetting }
     *
     *
     */
    public List<Confsetting> getConfsetting() {
        if (confsetting == null) {
            confsetting = new ArrayList<Confsetting>();
        }
        return this.confsetting;
    }

}
