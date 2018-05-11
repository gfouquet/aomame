
package fr.armida.aomame.domain.listxml;

import fr.armida.aomame.xml.YesNoAdapter;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "biosset")
// TODO migrate to kotlin
@Entity
public class Biosset {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_biosset")
    @SequenceGenerator(name = "seq_biosset", sequenceName = "seq_biosset", allocationSize = 1)
    @XmlTransient
    private Long id;

    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "description", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String description;
    @XmlAttribute(name = "default")
    @XmlJavaTypeAdapter(YesNoAdapter.class)
    @Column(name = "default")
    protected Boolean _default;

    /**
     * Obtient la valeur de la propriete name.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Definit la valeur de la propriete name.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtient la valeur de la propriete description.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * Definit la valeur de la propriete description.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtient la valeur de la propriete default.
     *
     * @return possible object is
     * {@link String }
     */
    public Boolean getDefault() {
        return _default;
    }

    /**
     * Definit la valeur de la propriete default.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDefault(Boolean value) {
        this._default = value;
    }

}
