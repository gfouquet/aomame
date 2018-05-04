package fr.armida.aomame.domain.listxml

import com.winterbe.expekt.should

internal class ChipTest : JaxbBindingTest<Chip>() {
    init {
        `when` unmarshalling Chip::class.java
        then {
            res.name.should.equal("Z80")
            res.type.should.equal("cpu")
            res.tag.should.equal("maincpu")
            res.clock.should.equal("4000000")
        }
    }
}
