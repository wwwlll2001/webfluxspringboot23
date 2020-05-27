package demo.webfluxspringboot23;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Travel {

    @Version
    private String version;

    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private String id;

    private String callSign;
    private String country;
    private String iata;
    private String icao;
    private String name;
    private String type;
    private String city;
}
