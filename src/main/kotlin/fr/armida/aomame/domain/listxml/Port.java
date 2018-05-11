
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
    "analog"
})
@XmlRootElement(name = "port")
public class Port {

    @XmlAttribute(name = "tag", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String tag;
    protected List<Analog> analog;

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
     * Gets the value of the analog property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the analog property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnalog().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Analog }
     *
     *
     */
    public List<Analog> getAnalog() {
        if (analog == null) {
            analog = new ArrayList<Analog>();
        }
        return this.analog;
    }

}
