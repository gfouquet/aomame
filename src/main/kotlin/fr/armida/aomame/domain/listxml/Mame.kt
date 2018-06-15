package fr.armida.aomame.domain.listxml

import fr.armida.aomame.xml.YesNoAdapter
import javax.persistence.*
import javax.persistence.CascadeType.ALL
import javax.validation.constraints.NotNull
import javax.xml.bind.annotation.*
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter


/**
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = arrayOf("game"))
@XmlRootElement(name = "mame")
@Entity
class Mame(
    /**
     * This PK is a FK on ListXml (one-to-one rel mapping)
     */
    @field: [
    Id
    XmlTransient
    ]
    var id: Long? = null,

    @field: [
    XmlAttribute
    XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    ]
    val build: String,

    @field: [
    XmlAttribute
    XmlJavaTypeAdapter(YesNoAdapter::class, type = Boolean::class)
    NotNull
    ]
    val debug: Boolean,

    @field: [
    XmlAttribute(required = true)
    XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    ]
    val mameconfig: String,

    @field: [
    OneToMany(cascade = [ALL])
    JoinTable
    XmlElement(required = true)
    ]
    val game: MutableList<Game>

) {
    @field: [
    OneToOne(mappedBy = "mame")
    MapsId
    JoinColumn(name = "id")
    XmlTransient
    ]
    lateinit var listXml: ListXml

    constructor() : this(null, "", false, "", mutableListOf())
}
