package fr.armida.aomame.support

import fr.armida.aomame.domain.catver.CatVer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.io.Resource
import spock.lang.Specification
import spock.lang.Unroll

import java.util.function.Predicate

//import static fr.armida.aomame.support.PredicateLogger.log

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
        CatVer res = parser.parse(catver.file)

        then:
        res.categories*.name as Set == ["Maze", "Driving", "Puzzle", "Casino"] as Set
        res.categories.find({ it.name == "Maze" }).genres*.name == ["Shooter Small"]
        res.categories.find({
            it.name == "Driving"
        }).genres*.name as Set == ["Generic", "Race (chase view) Bike"] as Set
        res.categories.find({ it.name == "Casino" }).genres*.name == ["Reels"]

    }

    def "should parse bindings"() {
        when:
        CatVer res = parser.parse(catver.file)

        then:
        res.bindings*.rom as Set == ["005", "18wheelr", "3kokushi", "500gp", "adults", "adustcm"] as Set
        res.bindings.find({ it.rom == "18wheelr" }).genre.name == "Generic"
        res.bindings.find({ it.rom == "adults" }).genre.name == "Reels"
        res.bindings.find({ it.rom == "adults" }).mature == true

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
