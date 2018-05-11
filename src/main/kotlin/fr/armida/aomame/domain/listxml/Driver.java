
package fr.armida.aomame.domain.listxml;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "driver")
@Entity
// TODO migrate to kotlin
public class Driver {
    @Id
    @XmlTransient
    private Long id;

    @OneToOne(mappedBy = "driver")
    @MapsId
    @JoinColumn(name = "id")
    @XmlTransient
    Game game;

    @XmlAttribute(name = "status", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String status;
    @XmlAttribute(name = "emulation", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String emulation;
    @XmlAttribute(name = "color", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String color;
    @XmlAttribute(name = "sound", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String sound;
    @XmlAttribute(name = "graphic", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String graphic;
    @XmlAttribute(name = "cocktail")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cocktail;
    @XmlAttribute(name = "protection")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String protection;
    @XmlAttribute(name = "savestate", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String savestate;

    /**
     * Obtient la valeur de la propriete status.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * Definit la valeur de la propriete status.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Obtient la valeur de la propriete emulation.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEmulation() {
        return emulation;
    }

    /**
     * Definit la valeur de la propriete emulation.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEmulation(String value) {
        this.emulation = value;
    }

    /**
     * Obtient la valeur de la propriete color.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getColor() {
        return color;
    }

    /**
     * Definit la valeur de la propriete color.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setColor(String value) {
        this.color = value;
    }

    /**
     * Obtient la valeur de la propriete sound.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSound() {
        return sound;
    }

    /**
     * Definit la valeur de la propriete sound.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSound(String value) {
        this.sound = value;
    }

    /**
     * Obtient la valeur de la propriete graphic.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getGraphic() {
        return graphic;
    }

    /**
     * Definit la valeur de la propriete graphic.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setGraphic(String value) {
        this.graphic = value;
    }

    /**
     * Obtient la valeur de la propriete cocktail.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCocktail() {
        return cocktail;
    }

    /**
     * Definit la valeur de la propriete cocktail.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCocktail(String value) {
        this.cocktail = value;
    }

    /**
     * Obtient la valeur de la propriete protection.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getProtection() {
        return protection;
    }

    /**
     * Definit la valeur de la propriete protection.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setProtection(String value) {
        this.protection = value;
    }

    /**
     * Obtient la valeur de la propriete savestate.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSavestate() {
        return savestate;
    }

    /**
     * Definit la valeur de la propriete savestate.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSavestate(String value) {
        this.savestate = value;
    }

}
