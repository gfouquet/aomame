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
@XmlRootElement(name = "chip")
class Chip(

    @field: [
    XmlAttribute(name = "name", required = true)
    XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    ]
    val name: String,

    @field: [
    XmlAttribute(name = "tag")
    XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    ]
    val tag: String,

    @field: [
    XmlAttribute(name = "type", required = true)
    XmlJavaTypeAdapter(CollapsedStringAdapter::class)
    ]
    val type: String,


    @field: [
    XmlAttribute(name = "clock")
    XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    ]
    val clock: String

) {
    constructor() : this("", "", "", "")
}
