package fr.armida.aomame.domain.listxml

import fr.armida.aomame.xml.YesNoAdapter
import javax.persistence.*
import javax.xml.bind.annotation.*
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter


/**
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "biosset")
// TODO migrate to kotlin
@Entity
class Biosset(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_biosset")
    @SequenceGenerator(name = "seq_biosset", sequenceName = "seq_biosset", allocationSize = 1)
    @XmlTransient
    private val id: Long? = null,


    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    val name: String,


    @XmlAttribute(name = "description", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    val description: String,


    @XmlAttribute(name = "default")
    @XmlJavaTypeAdapter(YesNoAdapter::class)
    @Column(name = "default")
    val default: Boolean

) {
    constructor() : this(null, "", "", false)
}
