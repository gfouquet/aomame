package fr.armida.aomame.domain.listxml

import javax.xml.bind.annotation.*
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "adjuster")
data class Adjuster(
    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    val name: String,

    @XmlAttribute(name = "default", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    val default: String
) {
    constructor() : this("", "")

}
