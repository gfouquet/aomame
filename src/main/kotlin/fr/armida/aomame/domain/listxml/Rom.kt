package fr.armida.aomame.domain.listxml

import fr.armida.aomame.domain.listxml.Status.GOOD
import fr.armida.aomame.xml.StatusAdapter
import fr.armida.aomame.xml.YesNoAdapter
import javax.persistence.*
import javax.xml.bind.annotation.*
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "rom")
@Entity
data class Rom(
    @field: [
    Id
    GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_rom")
    SequenceGenerator(name = "seq_rom", sequenceName = "seq_rom", allocationSize = 1000)
    XmlTransient
    ]
    // TODO hibernate id
    val id: Long? = null,

    @field: [
    XmlAttribute(name = "name", required = true)
    XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    ]
    val name: String,

    @field: [
    XmlAttribute(name = "bios")
    XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    ]
    val bios: String,

    @field: [
    XmlAttribute(name = "size", required = true)
    Transient
    ]
    val size: Long?,

    @field: [
    XmlAttribute(name = "crc")
    XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    Transient
    ]
    val crc: String,

    @field: [
    XmlAttribute(name = "sha1")
    XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    Transient
    ]
    val sha1: String,

    @field: [
    XmlAttribute(name = "merge")
    XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    Transient
    ]
    val merge: String,

    @field: [
    XmlAttribute(name = "region")
    XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    Transient
    ]
    val region: String,

    @field: [
    XmlAttribute(name = "offset")
    XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    Transient
    ]
    val offset: String,

    @field: [
    XmlAttribute(name = "status")
    XmlJavaTypeAdapter(StatusAdapter::class)
    ]
    val status: Status,

    @field: [
    XmlAttribute(name = "optional")
    XmlJavaTypeAdapter(YesNoAdapter::class, type=Boolean::class)
    ]
    val optional: Boolean
) {
    constructor() : this(null, "", "", 0, "", "", "", "", "", GOOD, false)
}
