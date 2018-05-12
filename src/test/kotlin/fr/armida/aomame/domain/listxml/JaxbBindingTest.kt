package fr.armida.aomame.domain.listxml

import org.junit.jupiter.api.Test
import org.springframework.core.io.ClassPathResource
import org.springframework.oxm.jaxb.Jaxb2Marshaller
import java.io.File
import java.io.FileInputStream
import javax.xml.transform.stream.StreamSource

/**
 * Base class for JAXB binding unit test.
 *
 * Usage : subclasses should configure the bound type and the test expectation through a DSL in an init block
 * @sample AdjusterTest
 */
internal abstract class JaxbBindingTest<T> {
    private lateinit var interaction: () -> T
    private lateinit var assertion: Res<T>.() -> Unit

    object `when` {
        // NOOP
    }

    infix fun `when`.unmarshalling(type: Class<T>) {
        interaction = {
            val unmarshaller = createUnmarshallerFor(type)
            val file = lookupXmlOf(type)

            unmarshaller.unmarshal(StreamSource(FileInputStream(file))) as T
        }
    }

    private fun lookupXmlOf(type: Class<T>): File {
        return ClassPathResource(type.simpleName.toLowerCase() + ".xml").file
    }

    private fun createUnmarshallerFor(type: Class<T>): Jaxb2Marshaller {
        val unmarshaller = Jaxb2Marshaller()
        unmarshaller.setClassesToBeBound(type)
        unmarshaller.isSupportDtd = true
        return unmarshaller
    }

    class Res<out U>(val res: U)

    fun then(_assertion: Res<T>.() -> Unit) {
        assertion = _assertion
    }

    @Test
    fun should_unmarshal_type() {
        Res(interaction()).assertion()
    }
}
