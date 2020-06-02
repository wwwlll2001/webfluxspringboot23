package demo.webfluxspringboot23;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.repository.config.EnableReactiveCouchbaseRepositories;

@Configuration
@EnableReactiveCouchbaseRepositories(basePackages = {"demo.webfluxspringboot23"})
public class CouchBaseConfiguration {
}
