package fr.armida.aomame.domain.listxml;

import javax.xml.bind.annotation.*
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter


/**
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "analog")
data class Analog (

    @XmlAttribute(name = "mask", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    val mask: String

) {
    constructor() : this("")
}
