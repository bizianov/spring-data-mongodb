package mongo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * Created by slava23 on 2/12/2017.
 */
@Configuration
@EnableAutoConfiguration(exclude = EmbeddedMongoAutoConfiguration.class)
public class TestMongoConfig {
}
