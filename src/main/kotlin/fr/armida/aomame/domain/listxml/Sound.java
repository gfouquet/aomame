
package fr.armida.aomame.domain.listxml;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "sound")
public class Sound {

    @XmlAttribute(name = "channels", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String channels;

    /**
     * Obtient la valeur de la propriete channels.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getChannels() {
        return channels;
    }

    /**
     * Definit la valeur de la propriete channels.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setChannels(String value) {
        this.channels = value;
    }

}
