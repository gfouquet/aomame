package fr.armida.aomame.xml

import org.slf4j.LoggerFactory
import javax.xml.bind.annotation.adapters.XmlAdapter

/**
 * Created by gregory on 13/01/2017.
 */
class YesNoAdapter : XmlAdapter<String, Boolean>() {
    private val logger = LoggerFactory.getLogger(YesNoAdapter::class.java)

    override fun unmarshal(v: String?): Boolean {
        return when (v?.trim()?.toLowerCase()) {
            "yes" -> true
            "no" -> false
            else -> {
                logger.debug("Unmarshalling unexpected value '{}' to false", v)
                false
            }
        }
    }

    override fun marshal(v: Boolean?): String {
        return when (v) {
            true -> "yes"
            else -> "no"
        }
    }
}
