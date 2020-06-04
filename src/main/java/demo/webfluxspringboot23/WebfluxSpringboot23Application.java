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
public class WebfluxSpringboot23Application  {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxSpringboot23Application.class, args);
    }

}
