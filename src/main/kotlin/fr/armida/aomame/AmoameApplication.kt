package fr.armida.aomame

import fr.armida.aomame.domain.listxml.Mame
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.oxm.jaxb.Jaxb2Marshaller

@SpringBootApplication
class AmoameApplication {
    @Bean
    fun jaxb2Marshaller(): Jaxb2Marshaller {
        val bean = Jaxb2Marshaller()
        bean.setClassesToBeBound(Mame::class.java)
        bean.isSupportDtd = true

        return bean
    }
}

fun main(args: Array<String>) {
    runApplication<AmoameApplication>(*args)
}
