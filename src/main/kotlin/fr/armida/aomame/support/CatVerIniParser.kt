package fr.armida.aomame.support

import fr.armida.aomame.domain.catver.Cat
import fr.armida.aomame.domain.catver.CatRomBinding
import fr.armida.aomame.domain.catver.CatVer
import fr.armida.aomame.domain.catver.Genre
import fr.armida.aomame.extension.logNotMatching
import fr.armida.aomame.extension.loggerFactory
import org.springframework.stereotype.Component
import java.io.File
import java.nio.file.Files
import java.util.function.Function.identity
import java.util.function.Predicate
import java.util.regex.Pattern
import java.util.stream.Collectors.*

private val CAT_LINE_PATTERN = Pattern.compile("(?i)([A-z0-9_\\-]+?) *= *([A-z0-9_\\- ]+[A-z0-9_\\-])( */ * ([A-z0-9_\\- ()]+[A-z0-9_\\-)])( *\\* *Mature *\\* *)?)?")

/**
 * @author gfouquet
 */
@Component
class CatVerIniParser {

    fun parse(file: File): Pair<Set<Cat>, Set<CatRomBinding>> {

        val lines = Files.lines(file.toPath())
            .filter(categoryLinePredicate()) // filters out non cat lines
            .map(this::parseLine)
            .collect(toList<CatVerLine>())

        val linesByGenreByCat = lines.stream()
            .collect(groupingBy(CatVerLine::cat, groupingBy(CatVerLine::genre, mapping(identity<CatVerLine>(), toSet<CatVerLine>()))))

        val bindings = linesByGenreByCat.entries
            .flatMap { catEntry ->
                val cat = Cat(name = catEntry.key)

                catEntry.value.entries
                    .flatMap { genreEntry ->
                        val genre = Genre(name = genreEntry.key, category = cat)

                        genreEntry.value
                            .map { l ->
                                CatRomBinding(rom = l.rom, mature = l.mature, genre = genre)
                            }
                    }
            }.toSet()


        val cats = bindings
            .mapNotNull(CatRomBinding::genre)
            .map(Genre::category)
            .toSet()


        return Pair(cats, bindings)
    }

    private fun parseLine(line: String): CatVerLine {
        val matcher = CAT_LINE_PATTERN.matcher(line)

        if (!matcher.find()) {
            throw IllegalArgumentException("Unparsable line : $line")
        }

        val rom = matcher.group(1).trim()
        val cat = matcher.group(2).trim()
        val genre = (matcher.group(4) ?: "Generic").trim()
        val mature = matcher.group(5) != null

        return CatVerLine(rom, cat, genre, mature)
    }

    private fun categoryLinePredicate(): Predicate<String> =
        CategoryLinePredicate().logNotMatching()


}

// TODO rewrite with immutable sealed class or whatever
internal class CategoryLinePredicate : Predicate<String> {
    private val logger by loggerFactory()
    private var reachedStart: Boolean = false
    private var reachedEnd: Boolean = false

    override fun test(line: String): Boolean {
        if (reachedEnd) return false

        val tline = line.trim()

        if ("[Category]".equals(tline, ignoreCase = true)) {
            reachedStart = true
            logger.debug("Reached start of categories")
            return false
        }

        if (reachedStart) {
            if (isBlockHeader(tline)) {
                reachedEnd = true
                logger.debug("Reached end of categories")
                return false
            }

            return isCategoryLine(tline)
        }

        return false
    }

    private fun isCategoryLine(tline: String): Boolean {
        return CAT_LINE_PATTERN.matcher(tline).matches()
    }

    private fun isBlockHeader(tline: String): Boolean {
        return tline.indexOf('[') == 0 && tline.lastIndexOf(']') == tline.length - 1
    }
}
