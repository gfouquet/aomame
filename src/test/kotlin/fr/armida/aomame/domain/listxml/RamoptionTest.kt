package fr.armida.aomame.domain.listxml

import com.winterbe.expekt.should

internal class RamoptionTest : JaxbBindingTest<Ramoption>() {
    init {
        `when` unmarshalling Ramoption::class.java

        then {
            res.default.should.equal("1")
            res.value.should.equal("12288")
        }
    }
}
