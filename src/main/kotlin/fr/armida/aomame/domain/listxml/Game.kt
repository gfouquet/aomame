package fr.armida.aomame.domain.listxml

import fr.armida.aomame.xml.YesNoAdapter
import org.slf4j.LoggerFactory
import javax.persistence.*
import javax.persistence.CascadeType.ALL
import javax.xml.bind.annotation.*
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["description", "year", "manufacturer", "biosset", "rom", "disk", "driver"])
@XmlRootElement(name = "game")
@Entity
class Game(

    @field: [
    Id
    GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_game")
    SequenceGenerator(name = "seq_game", sequenceName = "seq_game", allocationSize = 1)
    XmlTransient
    ]
    val id: Long? = null,


    @field: [
    XmlAttribute(name = "name", required = true)
    XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    ]
    val name: String,


    @field: [
    XmlAttribute(name = "sourcefile")
    XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    ]
    val sourcefile: String,


    @field: [
    XmlAttribute(name = "isbios")
    XmlJavaTypeAdapter(YesNoAdapter::class, type = Boolean::class)
    ]
    val isbios: Boolean,


    @field: [
    XmlAttribute(name = "isdevice")
    XmlJavaTypeAdapter(YesNoAdapter::class, type = Boolean::class)
    ]
    val isdevice: Boolean,


    @field: [
    XmlAttribute(name = "ismechanical")
    XmlJavaTypeAdapter(YesNoAdapter::class, type = Boolean::class)
    ]
    val ismechanical: Boolean,


    @field: [
    XmlAttribute(name = "runnable")
    XmlJavaTypeAdapter(YesNoAdapter::class, type = Boolean::class)
    ]
    val runnable: Boolean,


    @field: [
    XmlAttribute(name = "cloneof")
    XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    ]
    val cloneof: String,


    @field: [
    XmlAttribute(name = "romof")
    XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    ]
    val romof: String,


    @field: [
    XmlAttribute(name = "sampleof")
    XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    ]
    val sampleof: String,


    @field: [
    XmlElement(required = true)
    ]
    val description: String,


    val year: Int? = null,


    val manufacturer: String,

    @field: [
    OneToMany(cascade = [ALL])
    JoinTable
    ]
    val biosset: MutableList<Biosset>,

    @field: [
    OneToMany(cascade = [ALL])
    JoinTable
    ]
    val rom: List<Rom>,

    @field: [
    OneToMany(cascade = [ALL])
    JoinTable
    ]
    val disk: List<Disk>,

    @field: [
    OneToOne(cascade = [ALL])
    PrimaryKeyJoinColumn
    ]
    val driver: Driver? = null

) {
    @XmlTransient
    @Transient
    private val logger = LoggerFactory.getLogger(Game::class.java)

    constructor() : this(null, "", "", false, false, false, false, "", "", "", "", null, "", mutableListOf(), mutableListOf(), mutableListOf(), null)

    fun resolveInverseAssociations() {
        logger.trace("Resolving associations for game {}", this.name)
        driver?.let { it.game = this }
    }


    // TODO assess if required
//    fun setDriver(value: Driver) {
//        driver = value,
//        value.game = this,
//    }
}
