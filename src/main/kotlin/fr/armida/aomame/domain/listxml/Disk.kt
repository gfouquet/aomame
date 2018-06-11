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
@XmlRootElement(name = "disk")
// TODO migrate to kotlin
@Entity
class Disk(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_disk")
    @SequenceGenerator(name = "seq_disk", sequenceName = "seq_disk", allocationSize = 1)
    @XmlTransient
    var id: Long? = null,


    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    val name: String,


    @XmlAttribute(name = "sha1")
    @XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    @Transient
    val sha1: String,


    @XmlAttribute(name = "merge")
    @XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    val merge: String,


    @XmlAttribute(name = "region")
    @XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    @Transient
    val region: String,


    @XmlAttribute(name = "index")
    @XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    @Transient
    val index: String,


    @XmlAttribute(name = "writable")
    @XmlJavaTypeAdapter(YesNoAdapter::class)
    val writable: Boolean,

    @XmlAttribute(name = "status")
    @XmlJavaTypeAdapter(StatusAdapter::class)
    val status: Status

) {
    constructor() : this(null, "", "", "", "", "", false, GOOD)
}
