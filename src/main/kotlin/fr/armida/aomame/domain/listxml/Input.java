
package fr.armida.aomame.domain.listxml;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;


/**
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "control"
})
@XmlRootElement(name = "input")
public class Input {

    @XmlAttribute(name = "service")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String service;
    @XmlAttribute(name = "tilt")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String tilt;
    @XmlAttribute(name = "players", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String players;
    @XmlAttribute(name = "buttons")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String buttons;
    @XmlAttribute(name = "coins")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String coins;
    protected List<Control> control;

    /**
     * Obtient la valeur de la propriete service.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getService() {
        if (service == null) {
            return "no";
        } else {
            return service;
        }
    }

    /**
     * Definit la valeur de la propriete service.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setService(String value) {
        this.service = value;
    }

    /**
     * Obtient la valeur de la propriete tilt.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTilt() {
        if (tilt == null) {
            return "no";
        } else {
            return tilt;
        }
    }

    /**
     * Definit la valeur de la propriete tilt.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTilt(String value) {
        this.tilt = value;
    }

    /**
     * Obtient la valeur de la propriete players.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPlayers() {
        return players;
    }

    /**
     * Definit la valeur de la propriete players.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPlayers(String value) {
        this.players = value;
    }

    /**
     * Obtient la valeur de la propriete buttons.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getButtons() {
        return buttons;
    }

    /**
     * Definit la valeur de la propriete buttons.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setButtons(String value) {
        this.buttons = value;
    }

    /**
     * Obtient la valeur de la propriete coins.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCoins() {
        return coins;
    }

    /**
     * Definit la valeur de la propriete coins.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCoins(String value) {
        this.coins = value;
    }

    /**
     * Gets the value of the control property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the control property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getControl().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Control }
     *
     *
     */
    public List<Control> getControl() {
        if (control == null) {
            control = new ArrayList<Control>();
        }
        return this.control;
    }

}
