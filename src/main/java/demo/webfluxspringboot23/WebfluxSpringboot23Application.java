package demo.webfluxspringboot23;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class WebfluxSpringboot23Application {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxSpringboot23Application.class, args);
	}

}
