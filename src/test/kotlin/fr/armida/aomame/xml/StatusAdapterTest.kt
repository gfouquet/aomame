package fr.armida.aomame.xml

import com.winterbe.expekt.should
import fr.armida.aomame.domain.listxml.Status
import fr.armida.aomame.domain.listxml.Status.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class StatusAdapterTest {
    private lateinit var adapter: StatusAdapter

    @BeforeEach
    fun setup() {
        adapter = StatusAdapter()
    }

    @ParameterizedTest(name = "should marshall {0} into {1}")
    @MethodSource("marshall")
    fun should_marshall_status_into_string(input: Status?, expected: String) {
        val res = adapter.marshal(input)

        res.should.equal(expected)
    }

    @ParameterizedTest(name = "should unmarshall {0} into {1}")
    @MethodSource("unmarshall")
    fun should_unmarshall_string_into_status(input: String?, expected: Status) {
        val res = adapter.unmarshal(input)

        res.should.equal(expected)
    }

    companion object {
        @JvmStatic
        fun marshall() = values()
            .map { Arguments.of(it, it.name.toLowerCase()) }
            .plus(Arguments.of(null, "good"))


        @JvmStatic
        fun unmarshall() =
            values()
                .map { Arguments.of(it.name.toLowerCase(), it) }
                .plus(listOf(
                    Arguments.of("NODUMP", NODUMP),
                    Arguments.of(" nodump ", NODUMP),
                    Arguments.of("yolo", GOOD),
                    Arguments.of(null, GOOD)
                ))
    }
}
