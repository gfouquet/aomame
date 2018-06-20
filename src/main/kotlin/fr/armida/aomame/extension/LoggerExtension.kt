package fr.armida.aomame.extension

import org.slf4j.Logger
import org.slf4j.LoggerFactory

fun <R: Any> R.loggerFactory(): Lazy<Logger> {
    return lazy { LoggerFactory.getLogger(this.javaClass) }
}
