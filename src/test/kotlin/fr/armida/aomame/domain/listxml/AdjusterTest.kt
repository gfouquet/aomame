package fr.armida.aomame.domain.listxml

import com.winterbe.expekt.should

internal class AdjusterTest : JaxbBindingTest<Adjuster>() {
    init {
        `when` unmarshalling Adjuster::class.java
        then {
            res.name.should.equal("VR2 - DAC Volume")
            res.default.should.equal("90")

        }
    }
}

