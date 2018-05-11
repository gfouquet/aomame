
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
@XmlRootElement(name = "rom")
@Entity
// TODO migrate to kotlin
public class Rom {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_rom")
    @SequenceGenerator(name = "seq_rom", sequenceName = "seq_rom", allocationSize = 1000)
    @XmlTransient
    private Long id;

    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;

    @XmlAttribute(name = "bios")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String bios;

    @XmlAttribute(name = "size", required = true)
    @Transient
    protected Long size;

    @XmlAttribute(name = "crc")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @Transient
    protected String crc;

    @XmlAttribute(name = "sha1")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @Transient
    protected String sha1;

    @XmlAttribute(name = "merge")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @Transient
    protected String merge;

    @XmlAttribute(name = "region")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @Transient
    protected String region;

    @XmlAttribute(name = "offset")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @Transient
    protected String offset;

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
     * Obtient la valeur de la propriete bios.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBios() {
        return bios;
    }

    /**
     * Definit la valeur de la propriete bios.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBios(String value) {
        this.bios = value;
    }

    /**
     * Obtient la valeur de la propriete size.
     *
     * @return possible object is
     * {@link String }
     */
    public Long getSize() {
        return size;
    }

    /**
     * Definit la valeur de la propriete size.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSize(Long value) {
        this.size = value;
    }

    /**
     * Obtient la valeur de la propriete crc.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCrc() {
        return crc;
    }

    /**
     * Definit la valeur de la propriete crc.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCrc(String value) {
        this.crc = value;
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
     * Obtient la valeur de la propriete offset.
     *
     * @return possible object is
     * {@link String }
     */
    public String getOffset() {
        return offset;
    }

    /**
     * Definit la valeur de la propriete offset.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOffset(String value) {
        this.offset = value;
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

}
