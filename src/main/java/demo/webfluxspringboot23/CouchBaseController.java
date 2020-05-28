package demo.webfluxspringboot23;

import demo.webfluxspringboot23.repo.TravelReactiveRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@Slf4j
public class CouchBaseController {

    private final TravelReactiveRepository travelReactiveRepository;

    public CouchBaseController(TravelReactiveRepository travelReactiveRepository) {
        this.travelReactiveRepository = travelReactiveRepository;
    }

    @GetMapping("/travels")
    public Flux<Travel> getTravel(String city) {
        log.error("city=" + city);
        return travelReactiveRepository.findByCity(city);
    }
}
