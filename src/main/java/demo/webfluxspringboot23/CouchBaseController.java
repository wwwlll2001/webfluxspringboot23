package demo.webfluxspringboot23;

import demo.webfluxspringboot23.repo.TravelReactiveRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

@RestController
@Slf4j
public class CouchBaseController {

    private final TravelReactiveRepository travelReactiveRepository;
    private Random random = new Random();

    public CouchBaseController(TravelReactiveRepository travelReactiveRepository) {
        this.travelReactiveRepository = travelReactiveRepository;
    }

    @GetMapping("/travels")
    public Flux<Travel> getTravel() {
        String city = "City-" + random.nextInt(20000000);
        log.info(city);
        return travelReactiveRepository.findByCity(city);
    }

    @GetMapping(value = "/travels", params = {"icao"})
    public Flux<Travel> getTravelByCityAndCallSign(String city, String icao) {
        return travelReactiveRepository.findByCityAndIcao(city, icao);
    }

    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("1");
    }

}
