package fr.armida.aomame.domain.listxml

import com.winterbe.expekt.should
import org.junit.jupiter.api.Assertions.*

internal class AnalogTest : JaxbBindingTest<Analog>() {
    init {
        `when` unmarshalling Analog::class.java
        then {
            res.mask.should.equal("65280")
        }
    }
}
