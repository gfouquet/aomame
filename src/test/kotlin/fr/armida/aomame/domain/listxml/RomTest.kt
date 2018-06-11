package fr.armida.aomame.domain.listxml

import com.winterbe.expekt.should
import fr.armida.aomame.domain.listxml.Status.*

internal class RomTest : JaxbBindingTest<Rom>() {
    init {
        `when` unmarshalling Rom::class.java

        then {
            res.name.should.equal("5092.prom-u1")
            res.size.should.equal(2048)
            res.crc.should.equal("29e10a81")
            res.sha1.should.equal("c4b4e6c75bcf276e53f39a456d8d633c83dcf485")
            res.region.should.equal("maincpu")
            res.offset.should.equal("800")
            res.status.should.equal(GOOD)
        }
    }
}

internal class RomNoDumpTest : JaxbBindingTest<Rom>() {
    init {
        `when` unmarshalling Rom::class.java from "rom.nodump"

        then {
            res.name.should.equal("bm.7k")
            res.size.should.equal(65536)
            res.status.should.equal(NODUMP)
            res.region.should.equal("mcu")
            res.offset.should.equal("0")
        }
    }
}
