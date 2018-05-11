
package fr.armida.aomame.domain.listxml;

import fr.armida.aomame.xml.YesNoAdapter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;


/**
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "game"
})
@XmlRootElement(name = "mame")
@Entity
public class Mame {
    /**
     * This PK is a FK on ListXml (one-to-one rel mapping)
     */
    @Id
    @XmlTransient
    private Long id;

    @OneToOne(mappedBy = "mame")
    @MapsId
    @JoinColumn(name = "id")
    @XmlTransient
    ListXml listXml;

    @XmlAttribute
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String build;

    @XmlAttribute
    @XmlJavaTypeAdapter(YesNoAdapter.class)
    @NotNull
    protected Boolean debug;

    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String mameconfig;

    @OneToMany(cascade = ALL)
    @JoinTable
    @XmlElement(required = true)
    protected List<Game> game;

    /**
     * Obtient la valeur de la propriete build.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBuild() {
        return build;
    }

    /**
     * Definit la valeur de la propriete build.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBuild(String value) {
        this.build = value;
    }

    /**
     * Obtient la valeur de la propriete debug.
     *
     * @return possible object is
     * {@link String }
     */
    public Boolean getDebug() {
        return debug;
    }

    /**
     * Definit la valeur de la propriete debug.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDebug(Boolean value) {
        this.debug = value;
    }

    /**
     * Obtient la valeur de la propriete mameconfig.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMameconfig() {
        return mameconfig;
    }

    /**
     * Definit la valeur de la propriete mameconfig.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMameconfig(String value) {
        this.mameconfig = value;
    }

    /**
     * Gets the value of the game property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the game property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGame().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Game }
     */
    public List<Game> getGame() {
        if (game == null) {
            game = new ArrayList<Game>();
        }
        return this.game;
    }
}
