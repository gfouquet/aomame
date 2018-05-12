package fr.armida.aomame.domain.listxml

import com.winterbe.expekt.should

internal class SoundTest : JaxbBindingTest<Sound>() {
    init {
        `when` unmarshalling Sound::class.java

        then {
            res.channels.should.equal("1")
        }
    }
}
