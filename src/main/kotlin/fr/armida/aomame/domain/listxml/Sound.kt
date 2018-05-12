package fr.armida.aomame.domain.listxml

import javax.xml.bind.annotation.*
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter


/**
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "sound")
data class Sound(

    @XmlAttribute(name = "channels", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter::class)
    val channels: String
) {
    constructor() : this("")
}
