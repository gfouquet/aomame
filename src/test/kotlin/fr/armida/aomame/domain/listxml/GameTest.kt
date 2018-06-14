package fr.armida.aomame.domain.listxml

import com.winterbe.expekt.should

internal class GameTest : JaxbBindingTest<Game>() {
    init {
        `when` unmarshalling Game::class.java

        then {
            res.id.should.be.`null`
            res.name.should.equal("1944")
            res.sourcefile.should.equal("cps2.c")
            res.isbios.should.be.`true`
            res.isdevice.should.be.`true`
            res.ismechanical.should.be.`true`
            res.runnable.should.be.`true`
            res.cloneof.should.equal("")
            res.romof.should.equal("")
            res.sampleof.should.equal("")
            res.description.should.equal("1944!")
            res.year.should.equal(2000)
            res.manufacturer.should.equal("Eighting")
            res.biosset.size.should.equal(0)
            res.rom.size.should.equal(1)
            res.disk.size.should.equal(0)
            res.driver?.status.should.equal("good")
            
        }
    }
}
