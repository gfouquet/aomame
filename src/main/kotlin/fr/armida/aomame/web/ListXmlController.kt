@file:Suppress("UNNECESSARY_NOT_NULL_ASSERTION")

package fr.armida.aomame.web

import com.fasterxml.jackson.annotation.JsonView
import fr.armida.aomame.domain.listxml.ListXml
import fr.armida.aomame.domain.listxml.Mame
import fr.armida.aomame.domain.view.View
import fr.armida.aomame.extension.loggerFactory
import fr.armida.aomame.repository.ListXmlRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity
import org.springframework.http.codec.multipart.FilePart
import org.springframework.oxm.Unmarshaller
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.io.File
import java.io.FileInputStream
import javax.xml.transform.stream.StreamSource

/**
 * Created by gregory on 08/01/2017.
 */
@RestController
@RequestMapping("/listxmls")
class ListXmlsController {
    private val logger by loggerFactory()

    @Autowired
    private lateinit var unmarshaller: Unmarshaller

    @Autowired
    private lateinit var listXmlRepository: ListXmlRepository

    @PostMapping("/{name}")
    @ResponseStatus(CREATED)
    @Transactional
    fun addListXml(@RequestPart file: Mono<FilePart>, @PathVariable name: String, uriComponentsBuilder: UriComponentsBuilder): Mono<ResponseEntity<Any>> =
        Mono.just(listXmlRepository.countByName(name))
            // this check is somewhat rendered useless because of long processing time of file + not trnsactional nature
            // of the mono processing. on the other hand it may prevent from unnecessary unmarshalling
            .map { count ->
                logger.debug("There were {} listXmls named '{}'", count, name)

                if (count != 0) {
                    logger.info("A list named {} already exists", name)
                    throw ConflictingNameException(name, ListXml::class.java)
                }
                count
            }
            // when previous processing completes, we switch to another Mono
            .then(file)
            .map(this::partToTempFile)
            .map(this::unmarshall)
            .map { mame ->
                logger.debug("Mapping Mame into ListXml")
                val listXml = ListXml(mame)
                listXml.name = name

                mame.game.forEach { it.resolveInverseAssociations() }

                listXmlRepository.save(listXml)

                listXml
            }
            .map {
                val uriComponents = uriComponentsBuilder.path("/listxmls/{name}").buildAndExpand(name)
                ResponseEntity.created(uriComponents.toUri()).build<Any>()
            }
            // not too sure that's the best way to manage errors
            // @ControllerAdvice + @ExceptionHandler rendered useless because exception happens in another thread, not
            // actually in this controller's cflow
            .onErrorReturn({ ex -> ex is ConflictingNameException }, ResponseEntity.status(HttpStatus.CONFLICT).build<Any>())

    private fun unmarshall(file: File): Mame {
        logger.debug("Unmarshalling xml file")
        return unmarshaller.unmarshal(StreamSource(FileInputStream(file))) as Mame

    }

    private fun partToTempFile(part: FilePart): File {
        val f = File.createTempFile("listxml", "xml")
        part.transferTo(f)

        return f
    }

    @GetMapping
    @Transactional(readOnly = true)
    @JsonView(View.Summary::class)
    @ResponseStatus(OK)
    fun fetchListXmls(): Flux<ListXml> =
        Flux.fromIterable(listXmlRepository.findAll())

}
