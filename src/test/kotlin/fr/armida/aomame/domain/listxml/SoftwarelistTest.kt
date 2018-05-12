package fr.armida.aomame.domain.listxml

import com.winterbe.expekt.should

internal class SoftwarelistTest : JaxbBindingTest<Softwarelist>() {
    init {
        `when` unmarshalling Softwarelist::class.java

        then {
            res.name.should.equal("neogeo")
            res.status.should.equal("original")
            res.filter.should.equal("")
        }
    }
}
