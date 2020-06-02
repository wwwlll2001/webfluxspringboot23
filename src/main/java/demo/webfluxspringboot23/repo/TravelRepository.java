package demo.webfluxspringboot23.repo;

import demo.webfluxspringboot23.Travel;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TravelRepository extends CrudRepository<Travel, String> {

    @Query("#{#n1ql.selectEntity} limit 10")
    List<Travel> findByCountry(String country, Pageable pageable);
}
