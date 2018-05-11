package fr.armida.aomame.xml

import com.winterbe.expekt.should
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class YesNoAdapterTest {
    private lateinit var adapter: YesNoAdapter

    @BeforeEach
    fun setup() {
        adapter = YesNoAdapter()
    }

    @ParameterizedTest(name = "should marshall {0} into {1}")
    @MethodSource("marshall")
    fun should_marshall_bool_into_string(input: Boolean?, expected: String) {
        val res = adapter.marshal(input)

        res.should.equal(expected)
    }

    @ParameterizedTest(name = "should unmarshall {0} into {1}")
    @MethodSource("unmarshall")
    fun should_unmarshall_string_into_bool(input: String?, expected: Boolean) {
        val res = adapter.unmarshal(input)

        res.should.equal(expected)
    }

    companion object {
        @JvmStatic
        fun marshall() = listOf(
            Arguments.of(true, "yes"),
            Arguments.of(false, "no"),
            Arguments.of(null, "no")
        )

        @JvmStatic
        fun unmarshall() = listOf(
            Arguments.of("yes", true),
            Arguments.of("YES", true),
            Arguments.of(" yes ", true),
            Arguments.of("no", false),
            Arguments.of(" no ", false),
            Arguments.of("yolo", false),
            Arguments.of(null, false)
        )
    }
}
