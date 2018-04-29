package fr.armida.aomame.domain.listxml

import com.winterbe.expekt.should
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.core.io.Resource
import org.springframework.oxm.Unmarshaller
import org.springframework.oxm.jaxb.Jaxb2Marshaller
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.io.FileInputStream
import javax.xml.transform.stream.StreamSource

@ExtendWith(SpringExtension::class)
internal class AdjusterTest {
    @TestConfiguration
    internal class Configuration {

        @Bean
        fun jaxb2Marshaller(): Jaxb2Marshaller {
            val bean = Jaxb2Marshaller()
            bean.setClassesToBeBound(Adjuster::class.java!!)
            bean.isSupportDtd = true

            return bean
        }
    }

    @Autowired
    private lateinit var unmarshaller: Unmarshaller

    @Value("classpath:adjuster.xml")
    private lateinit var xml: Resource

    @Test
    fun should_unmarshall_adjuster() {
        // given
        val file = xml.file

        // when
        val res = unmarshaller.unmarshal(StreamSource(FileInputStream(file))) as Adjuster

        // then
        res.name.should.equal("VR2 - DAC Volume")
        res.default.should.equal("90")
    }
}

