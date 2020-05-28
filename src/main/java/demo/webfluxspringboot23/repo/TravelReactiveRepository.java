package demo.webfluxspringboot23.repo;


import demo.webfluxspringboot23.Travel;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;


public interface TravelReactiveRepository extends ReactiveCouchbaseRepository<Travel, String> {

//    @Query("SELECT * FROM `travel-sample` limit 10")
    @Query("#{#n1ql.selectEntity} limit 10  ")
    Flux<Travel> findByCountry(String country);

    Flux<Travel> findByCity(String city);

    Flux<Travel> findByCityAndCallSign(String city, String callSign);
}
