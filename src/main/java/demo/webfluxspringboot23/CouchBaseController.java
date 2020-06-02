package demo.webfluxspringboot23;

import demo.webfluxspringboot23.repo.TravelReactiveRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class CouchBaseController {

    private final TravelReactiveRepository travelReactiveRepository;

    public CouchBaseController(TravelReactiveRepository travelReactiveRepository) {
        this.travelReactiveRepository = travelReactiveRepository;
    }

    @GetMapping("/travels")
    public Flux<Travel> getTravel(String city) {
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
