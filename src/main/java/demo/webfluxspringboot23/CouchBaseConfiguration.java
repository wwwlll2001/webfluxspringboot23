package demo.webfluxspringboot23;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableReactiveCouchbaseRepositories;

@Configuration
@EnableReactiveCouchbaseRepositories(basePackages = {"demo.webfluxspringboot23"})
public class CouchBaseConfiguration extends AbstractCouchbaseConfiguration {

    final CouchbaseProperties couchbaseProperties;

    @Value("${spring.couchbase.bucketName}")
    private String bucketName;

    public CouchBaseConfiguration(CouchbaseProperties couchbaseProperties) {
        this.couchbaseProperties = couchbaseProperties;
    }

    @Override
    public String getConnectionString() {
        return couchbaseProperties.getConnectionString();
    }

    @Override
    public String getUserName() {
        return couchbaseProperties.getUsername();
    }

    @Override
    public String getPassword() {
        return couchbaseProperties.getPassword();
    }

    @Override
    public String getBucketName() {
        return bucketName;
    }
}
