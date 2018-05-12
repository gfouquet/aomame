package fr.armida.aomame.domain.listxml

import com.winterbe.expekt.should

internal class SampleTest : JaxbBindingTest<Sample>() {
    init {
        `when` unmarshalling Sample::class.java

        then {
            res.name.should.equal("missile")
        }
    }
}
