package fr.armida.aomame.domain.listxml

import javax.xml.bind.annotation.*
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter


/**
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = arrayOf("value"))
@XmlRootElement(name = "ramoption")
data class Ramoption(

    @field: [
    XmlAttribute(name = "default")
    XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    ]
    val default: String,

    @field: [
    XmlValue
    ]
    val value: String

) {
    constructor() : this("", "")
}

