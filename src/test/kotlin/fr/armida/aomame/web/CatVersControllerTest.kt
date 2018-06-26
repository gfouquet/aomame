package fr.armida.aomame.web

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.PathResource
import org.springframework.core.io.Resource
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.MediaType.MULTIPART_FORM_DATA
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.reactive.function.BodyInserters.fromMultipartData
import org.springframework.web.util.UriComponentsBuilder.fromPath
import java.nio.file.Paths
import java.time.Duration.ofMinutes

/**
 * @author gfouquet
 */
@SpringBootTest
@ExtendWith(SpringExtension::class)
@AutoConfigureWebTestClient
class CatVersControllerTest {
    @Autowired
    internal lateinit var client: WebTestClient

    private fun longTimeoutClient(): WebTestClient {
        // Default client timeout is 5 secs which is not enough for listxml processing
        // We rebuild a client thanks to a WebTestClientConfigurer written as a lambda.
        // Maybe there's an automatic way to apply WTCC but I couldn't find it.
        return client.mutateWith { builder, _, _ -> builder.responseTimeout(ofMinutes(2)) }

    }

    @Test
    fun _01_should_post_catver() {
        // given
        val catver = Paths.get("target", "test-classes", "catver.ini")
        val file = PathResource(catver)

        // when
        longTimeoutClient().post().uri("catvers/{name}", "catver test")
            .contentType(MULTIPART_FORM_DATA)
            .body(fromMultipartData(multipart(file)))
            .exchange()

            //then
            // the "fromPath" is a probly overkill way to percent-encode the URI
            .expectHeader().valueMatches("Location", fromPath("/catvers/catver test").toUriString())
    }

    private fun multipart(file: Resource): MultiValueMap<String, *> {
        val parts = LinkedMultiValueMap<String, Any>()

        val headers = HttpHeaders()
        headers.contentType = MediaType.TEXT_XML

        parts.add("file", HttpEntity(file, headers))

        return parts
    }

    @Test
    fun _02_should_fetch_catver() {
        // expect
        client.get().uri("/catvers")
            .exchange()
            .expectStatus().isOk
            .expectBody().json("[{name:'catver test'}]")
    }


    @Test
    fun _03_should_not_post_catver_twice() {
        // given
        val file = FileSystemResource(createTempFile("empty", "xml"));

        // when
        client.post().uri("catvers/{name}", "catver test")
            .contentType(MULTIPART_FORM_DATA)
            .body(fromMultipartData(multipart(file)))
            .exchange()

            //then
            .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }
}
