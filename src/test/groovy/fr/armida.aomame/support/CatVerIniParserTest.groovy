package fr.armida.aomame.support

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.io.Resource
import spock.lang.Specification
import spock.lang.Unroll

import java.util.function.Predicate

//import static fr.armida.aomame.support.PredicateLoggerExtension.log

/**
 * Created by gregory on 22/01/2017.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CatVerIniParserTest extends Specification {
    @Value("classpath:catver-short.ini")
    Resource catver

    @Autowired
    CatVerIniParser parser

    def "should parse categories"() {
        when:
        def categories = parser.parse(catver.file).first

        then:
        categories*.name as Set == ["Maze", "Driving", "Puzzle", "Casino"] as Set
        categories.find({ it.name == "Maze" }).genres*.name == ["Shooter Small"]
        categories.find({
            it.name == "Driving"
        }).genres*.name as Set == ["Generic", "Race (chase view) Bike"] as Set
        categories.find({ it.name == "Casino" }).genres*.name == ["Reels"]

    }

    def "should parse bindings"() {
        when:
        def bindings = parser.parse(catver.file).second

        then:
        bindings*.rom as Set == ["005", "18wheelr", "3kokushi", "500gp", "adults", "adustcm"] as Set
        bindings.find({ it.rom == "18wheelr" }).genre.name == "Generic"
        bindings.find({ it.rom == "adults" }).genre.name == "Reels"
        bindings.find({ it.rom == "adults" }).mature == true

    }

    def "line predicate should validate lines sequentially"() {
        given:
//        Predicate predicate = log(new CategoryLinePredicate())
        Predicate predicate = new CategoryLinePredicate()

        expect:
        with(predicate) {
            test("foo") == false
            test("[foo]") == false
            test("foo=bar") == false

            test("[Category]") == false
            test("") == false
            test("foo") == false
            test("foo=bar") == true
            test("foo=bar / baz") == true
            test("foo=bar / baz * mature *") == true
            test("foo=bar / baz (lol) yolo") == true
            test("[foo]") == false
            test("foo=bar") == false
            test("foo") == false
        }

    }

    @Unroll
    def "should parse line #line"() {
        when:
        CatVerLine res = parser.parseLine(line)

        then:
        with(res) {
            mature == mature
            rom == rom
            genre == genre
            cat == cat
        }

        where:
        line                                      | rom        | cat       | genre                        | mature
        "005 = Maze / Shooter (chase view) Small" | "005"      | "Maze"    | "Shooter (chase view) Small" | false
        "18wheelr=Driving"                        | "18wheelr" | "Driving" | "Generic"                    | false
        "3kokushi=Puzzle / Match * Mature *"      | "3kokushi" | "Puzzle"  | "Match"                      | true
    }
}
