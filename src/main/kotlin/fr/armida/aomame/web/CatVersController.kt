package fr.armida.aomame.web

import fr.armida.aomame.domain.catver.CatVer
import fr.armida.aomame.extension.loggerFactory
import fr.armida.aomame.repository.CatVerRepository
import fr.armida.aomame.support.CatVerIniParser
import org.slf4j.Logger
import org.springframework.http.HttpStatus.CONFLICT
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.ResponseEntity
import org.springframework.http.codec.multipart.FilePart
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Mono
import java.io.File
import java.io.IOException

/**
 * @author gfouquet
 */
@RestController
@RequestMapping("/catvers")
class CatVersController(private val catVerRepository: CatVerRepository, private val catVerIniParser: CatVerIniParser) {
    val logger : Logger by loggerFactory()

    @PostMapping("/{name}")
    @ResponseStatus(CREATED)
    @Transactional
    fun addCatver(@RequestPart file: Mono<FilePart>, @PathVariable name: String, uriComponentsBuilder: UriComponentsBuilder) =
        Mono.just(catVerRepository.countByName(name))
            .map { count ->
                logger.debug("There were {} catvers named '{}'", count, name)
                if (count !== 0) {
                    logger.info("A catver named {} already exists", name)
                    throw ConflictingNameException(name, CatVer::class.java)
                } else count
            }
            .then(file)
            .map(this::partToTempFile)
            .map(catVerIniParser::parse)
            .map { (cats, bindings) ->
                catVerRepository.save(CatVer(name = name, bindings = bindings, categories = cats))
            }
            .map {
                val uriComponents = uriComponentsBuilder.path("/catvers/{name}").buildAndExpand(name)
                ResponseEntity.created(uriComponents.toUri()).build<Any>()
            }
            .onErrorReturn(
                { it is ConflictingNameException },
                ResponseEntity.status(CONFLICT).build()
            )

    private fun partToTempFile(part: FilePart): File {
        try {
            val f = File.createTempFile("catver", "ini")
            part.transferTo(f)

            return f

        } catch (e: IOException) {
            throw RuntimeException(e)
        }

    }
}
