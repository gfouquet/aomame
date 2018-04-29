package fr.armida.aomame

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AmoameApplication

fun main(args: Array<String>) {
    runApplication<AmoameApplication>(*args)
}
