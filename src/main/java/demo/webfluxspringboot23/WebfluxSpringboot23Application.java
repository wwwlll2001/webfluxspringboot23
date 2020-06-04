package demo.webfluxspringboot23;

import demo.webfluxspringboot23.repo.TravelReactiveRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.UUID;

@SpringBootApplication
@Slf4j
public class WebfluxSpringboot23Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxSpringboot23Application.class, args);
    }

    @Autowired
    private TravelReactiveRepository travelReactiveRepository;

    @Override
    public void run(String... args) throws Exception {
        Scheduler scheduler = Schedulers.newElastic("nudge-worker");
        ArrayList<Travel> travels;
        for (int j = 1; j <= 1000000; j++) {
            travels = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                Travel travel = new Travel();
                travel.setCity("City-" + j);
                travel.setCallSign(UUID.randomUUID().toString());
                travel.setCountry(UUID.randomUUID().toString());
                travel.setIata(UUID.randomUUID().toString());
                travel.setIcao(UUID.randomUUID().toString());
                travel.setName(UUID.randomUUID().toString());
                travel.setType(UUID.randomUUID().toString());
                travels.add(travel);
            }
            travelReactiveRepository.saveAll(travels)
                    .subscribeOn(scheduler)
                    .subscribe();
            log.info("add finish :" + j);
        }
    }
}
