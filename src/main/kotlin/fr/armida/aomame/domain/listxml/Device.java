
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
    "instance",
    "extension"
})
@XmlRootElement(name = "device")
public class Device {

    @XmlAttribute(name = "type", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String type;
    @XmlAttribute(name = "tag")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String tag;
    @XmlAttribute(name = "mandatory")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String mandatory;
    @XmlAttribute(name = "interface")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String _interface;
    protected List<Instance> instance;
    protected List<Extension> extension;

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
     * Obtient la valeur de la propriete mandatory.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMandatory() {
        return mandatory;
    }

    /**
     * Definit la valeur de la propriete mandatory.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMandatory(String value) {
        this.mandatory = value;
    }

    /**
     * Obtient la valeur de la propriete interface.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getInterface() {
        return _interface;
    }

    /**
     * Definit la valeur de la propriete interface.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setInterface(String value) {
        this._interface = value;
    }

    /**
     * Gets the value of the instance property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the instance property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstance().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Instance }
     *
     *
     */
    public List<Instance> getInstance() {
        if (instance == null) {
            instance = new ArrayList<Instance>();
        }
        return this.instance;
    }

    /**
     * Gets the value of the extension property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extension property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtension().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Extension }
     *
     *
     */
    public List<Extension> getExtension() {
        if (extension == null) {
            extension = new ArrayList<Extension>();
        }
        return this.extension;
    }

}
