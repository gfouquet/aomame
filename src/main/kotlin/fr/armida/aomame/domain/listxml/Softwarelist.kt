package fr.armida.aomame.domain.listxml

import javax.xml.bind.annotation.*
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter


/**
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "softwarelist")
//@Entity
data class Softwarelist(

    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    val name: String,

    @XmlAttribute(name = "status", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter::class)
    val status: String,

    @XmlAttribute(name = "filter")
    @XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    val filter: String

) {
    constructor() : this("", "", "")
}
