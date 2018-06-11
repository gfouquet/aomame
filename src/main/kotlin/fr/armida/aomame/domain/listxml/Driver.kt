package fr.armida.aomame.domain.listxml

import javax.persistence.*
import javax.xml.bind.annotation.*
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "driver")
@Entity
// TODO migrate to kotlin
data class Driver(
    @Id
    @XmlTransient
    // TODO hibernate id, how should we do ?
    val id: Long? = null,

    @XmlAttribute(name = "status", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter::class)
    val status: String,

    @XmlAttribute(name = "emulation", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter::class)
    val emulation: String,


    @XmlAttribute(name = "color", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter::class)
    val color: String,


    @XmlAttribute(name = "sound", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter::class)
    val sound: String,


    @XmlAttribute(name = "graphic", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter::class)
    val graphic: String,


    @XmlAttribute(name = "cocktail")
    @XmlJavaTypeAdapter(CollapsedStringAdapter::class)
    val cocktail: String,


    @XmlAttribute(name = "protection")
    @XmlJavaTypeAdapter(CollapsedStringAdapter::class)
    val protection: String,


    @XmlAttribute(name = "savestate", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter::class)
    val savestate: String
) {
    constructor(): this(null, "", "", "", "", "", "", "", "")

    @OneToOne(mappedBy = "driver")
    @MapsId
    @JoinColumn(name = "id")
    @XmlTransient
    internal lateinit var game: Game
}
