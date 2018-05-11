package fr.armida.aomame.domain.listxml;

import fr.armida.aomame.xml.YesNoAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
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
@XmlType(name = "", propOrder = {"description", "year", "manufacturer", "biosset", "rom", "disk", "driver"})
@XmlRootElement(name = "game")
@Entity// TODO migrate to kotlin
public class Game {
    private static final Logger LOGGER = LoggerFactory.getLogger(Game.class);

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_game")
    @SequenceGenerator(name = "seq_game", sequenceName = "seq_game", allocationSize = 1)
    @XmlTransient
    private Long id;

    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;

    @XmlAttribute(name = "sourcefile")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String sourcefile;

    @XmlAttribute(name = "isbios")
    @XmlJavaTypeAdapter(YesNoAdapter.class)
    protected Boolean isbios;

    @XmlAttribute(name = "isdevice")
    @XmlJavaTypeAdapter(YesNoAdapter.class)
    protected Boolean isdevice;

    @XmlAttribute(name = "ismechanical")
    @XmlJavaTypeAdapter(YesNoAdapter.class)
    protected Boolean ismechanical;

    @XmlAttribute(name = "runnable")
    @XmlJavaTypeAdapter(YesNoAdapter.class)
    protected Boolean runnable;

    @XmlAttribute(name = "cloneof")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String cloneof;

    @XmlAttribute(name = "romof")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String romof;

    @XmlAttribute(name = "sampleof")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String sampleof;

    @XmlElement(required = true)
    protected String description;

    protected Integer year;

    protected String manufacturer;

    @OneToMany(cascade = ALL)
    @JoinTable
    protected List<Biosset> biosset;

    @OneToMany(cascade = ALL)
    @JoinTable
    protected List<Rom> rom;

    @OneToMany(cascade = ALL)
    @JoinTable
    protected List<Disk> disk;

    @OneToOne(cascade = ALL)
    @PrimaryKeyJoinColumn
    protected Driver driver;

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
     * Obtient la valeur de la propriete sourcefile.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSourcefile() {
        return sourcefile;
    }

    /**
     * Definit la valeur de la propriete sourcefile.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSourcefile(String value) {
        this.sourcefile = value;
    }

    /**
     * Obtient la valeur de la propriete isbios.
     *
     * @return possible object is
     * {@link String }
     */
    public Boolean getIsbios() {
        return isbios;
    }

    /**
     * Definit la valeur de la propriete isbios.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIsbios(Boolean value) {
        this.isbios = value;
    }

    /**
     * Obtient la valeur de la propriete isdevice.
     *
     * @return possible object is
     * {@link String }
     */
    public Boolean getIsdevice() {
        return isdevice;
    }

    /**
     * Definit la valeur de la propriete isdevice.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIsdevice(Boolean value) {
        this.isdevice = value;
    }

    /**
     * Obtient la valeur de la propriete ismechanical.
     *
     * @return possible object is
     * {@link String }
     */
    public Boolean getIsmechanical() {
        return ismechanical;
    }

    /**
     * Definit la valeur de la propriete ismechanical.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIsmechanical(Boolean value) {
        this.ismechanical = value;
    }

    /**
     * Obtient la valeur de la propriete runnable.
     *
     * @return possible object is
     * {@link String }
     */
    public Boolean getRunnable() {
        return runnable;
    }

    /**
     * Definit la valeur de la propriete runnable.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRunnable(Boolean value) {
        this.runnable = value;
    }

    /**
     * Obtient la valeur de la propriete cloneof.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCloneof() {
        return cloneof;
    }

    /**
     * Definit la valeur de la propriete cloneof.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCloneof(String value) {
        this.cloneof = value;
    }

    /**
     * Obtient la valeur de la propriete romof.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRomof() {
        return romof;
    }

    /**
     * Definit la valeur de la propriete romof.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRomof(String value) {
        this.romof = value;
    }

    /**
     * Obtient la valeur de la propriete sampleof.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSampleof() {
        return sampleof;
    }

    /**
     * Definit la valeur de la propriete sampleof.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSampleof(String value) {
        this.sampleof = value;
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
     * Obtient la valeur de la propriete year.
     *
     * @return possible object is
     * {@link String }
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Definit la valeur de la propriete year.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setYear(Integer value) {
        this.year = value;
    }

    /**
     * Obtient la valeur de la propriete manufacturer.
     *
     * @return possible object is
     * {@link String }
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Definit la valeur de la propriete manufacturer.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setManufacturer(String value) {
        this.manufacturer = value;
    }

    /**
     * Gets the value of the biosset property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the biosset property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBiosset().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Biosset }
     */
    public List<Biosset> getBiosset() {
        if (biosset == null) {
            biosset = new ArrayList<Biosset>();
        }
        return this.biosset;
    }

    /**
     * Gets the value of the rom property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rom property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRom().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Rom }
     */
    public List<Rom> getRom() {
        if (rom == null) {
            rom = new ArrayList<Rom>();
        }
        return this.rom;
    }

    /**
     * Gets the value of the disk property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the disk property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisk().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Disk }
     */
    public List<Disk> getDisk() {
        if (disk == null) {
            disk = new ArrayList<Disk>();
        }
        return this.disk;
    }

    /**
     * Gets the value of the dipswitch property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dipswitch property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDipswitch().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Dipswitch }
     */
//    public List<Dipswitch> getDipswitch() {
//        if (dipswitch == null) {
//            dipswitch = new ArrayList<Dipswitch>();
//        }
//        return this.dipswitch;
//    }

    /**
     * Obtient la valeur de la propriete driver.
     *
     * @return possible object is
     * {@link Driver }
     */
    public Driver getDriver() {
        return driver;
    }

    /**
     * Definit la valeur de la propriete driver.
     *
     * @param value allowed object is
     *              {@link Driver }
     */
    public void setDriver(Driver value) {
        this.driver = value;
        value.game = this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * resolves inverse associations which were not set while unmarshalling from xml.
     */
    public void resolveInverseAssociations() {
        LOGGER.trace("Resolving associations for game {}", this.name);
        if (driver != null) driver.game = this;
    }
}
