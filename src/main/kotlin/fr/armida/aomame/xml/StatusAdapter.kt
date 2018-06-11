package fr.armida.aomame.xml

import fr.armida.aomame.domain.listxml.Status
import fr.armida.aomame.domain.listxml.Status.*
import org.slf4j.LoggerFactory
import javax.xml.bind.annotation.adapters.XmlAdapter

class StatusAdapter : XmlAdapter<String, Status>() {
    private val logger = LoggerFactory.getLogger(YesNoAdapter::class.java)

    override fun unmarshal(v: String?): Status {
        val normalized = v?.trim()?.toUpperCase()
        return when (normalized) {
            NODUMP.name, BADDUMP.name, GOOD.name -> Status.valueOf(normalized)

            else -> {
                logger.debug("Unmarshalling unexpected value '{}' to GOOD", v)
                GOOD
            }
        }
    }

    override fun marshal(v: Status?): String {
        return when (v) {
            NODUMP, BADDUMP, GOOD -> v.name.toLowerCase()
            else -> "good"
        }
    }
}
