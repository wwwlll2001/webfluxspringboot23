package demo.webfluxspringboot23;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;

import java.time.Duration;

@AutoConfigureWebTestClient(timeout = "36000")
class WebfluxControllerTest extends ApiTestBase {

    @Test
    void should_get_travels() {
        webTestClient.get().uri("/travels?city=Peronne")
                     .accept(MediaType.APPLICATION_JSON)
                     .exchange()
                     .expectStatus().isOk()
                     .expectBodyList(Travel.class).hasSize(1);
    }
}