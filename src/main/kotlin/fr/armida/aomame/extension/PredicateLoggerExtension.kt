package fr.armida.aomame.extension


import org.slf4j.LoggerFactory
import java.util.function.Predicate

/**
 * @author gfouquet
 */
private val LOGGER = LoggerFactory.getLogger("package fr.armida.aomame.support.PredicateLoggerExtension")

fun <R : Predicate<T>, T : Any> R.log(): Predicate<T> =
    this.logMatching().logNotMatching()

fun <R : Predicate<T>, T : Any> R.logMatching(): Predicate<T> =
// syntax below : Single Abstract Method (SAM) conversion of a lambda into a func interface impl
    Predicate {
        val res = this.test(it)
        if (res) LOGGER.trace("Match : '{}'", it)
        res
    }


fun <R : Predicate<T>, T : Any> R.logNotMatching(): Predicate<T> =
    Predicate {
        val res = this.test(it)
        if (!res) LOGGER.trace("Don't match : '{}'", it)
        res
    }
