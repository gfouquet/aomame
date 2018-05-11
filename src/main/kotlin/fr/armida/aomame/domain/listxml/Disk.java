
package fr.armida.aomame.domain.listxml;

import fr.armida.aomame.xml.YesNoAdapter;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "disk")
// TODO migrate to kotlin
@Entity
public class Disk {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_disk")
    @SequenceGenerator(name = "seq_disk", sequenceName = "seq_disk", allocationSize = 1)
    @XmlTransient
    private Long id;

    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;

    @XmlAttribute(name = "sha1")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @Transient
    protected String sha1;

    @XmlAttribute(name = "merge")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String merge;

    @XmlAttribute(name = "region")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @Transient
    protected String region;

    @XmlAttribute(name = "index")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @Transient
    protected String index;

    @XmlAttribute(name = "writable")
    @XmlJavaTypeAdapter(YesNoAdapter.class)
    protected Boolean writable;

    @XmlAttribute(name = "status")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String status;

    @XmlAttribute(name = "optional")
    @XmlJavaTypeAdapter(YesNoAdapter.class)
    protected Boolean optional;

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
     * Obtient la valeur de la propriete sha1.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSha1() {
        return sha1;
    }

    /**
     * Definit la valeur de la propriete sha1.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSha1(String value) {
        this.sha1 = value;
    }

    /**
     * Obtient la valeur de la propriete merge.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMerge() {
        return merge;
    }

    /**
     * Definit la valeur de la propriete merge.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMerge(String value) {
        this.merge = value;
    }

    /**
     * Obtient la valeur de la propriete region.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRegion() {
        return region;
    }

    /**
     * Definit la valeur de la propriete region.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRegion(String value) {
        this.region = value;
    }

    /**
     * Obtient la valeur de la propriete index.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIndex() {
        return index;
    }

    /**
     * Definit la valeur de la propriete index.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIndex(String value) {
        this.index = value;
    }

    /**
     * Obtient la valeur de la propriete writable.
     *
     * @return possible object is
     * {@link String }
     */
    public Boolean getWritable() {
            return writable;
    }

    /**
     * Definit la valeur de la propriete writable.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setWritable(Boolean value) {
        this.writable = value;
    }

    /**
     * Obtient la valeur de la propriete status.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStatus() {
        if (status == null) {
            return "good";
        } else {
            return status;
        }
    }

    /**
     * Definit la valeur de la propriete status.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Obtient la valeur de la propriete optional.
     *
     * @return possible object is
     * {@link String }
     */
    public Boolean getOptional() {
        return optional;
    }

    /**
     * Definit la valeur de la propriete optional.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOptional(Boolean value) {
        this.optional = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
