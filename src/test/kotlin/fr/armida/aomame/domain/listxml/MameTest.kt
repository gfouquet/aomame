package fr.armida.aomame.domain.listxml

import com.winterbe.expekt.should

internal class MameTest : JaxbBindingTest<Mame>() {
    init {
        `when` unmarshalling Mame::class.java

        then {
            res.id.should.be.`null`
            res.build.should.equal("0.154 (Jul 23 2014)")
            res.debug.should.equal(true)
            res.mameconfig.should.equal("10")
        }
    }
}
