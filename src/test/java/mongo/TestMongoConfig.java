package mongo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by slava23 on 2/13/2017.
 */
@Configuration
@EnableAutoConfiguration(exclude = EmbeddedMongoAutoConfiguration.class)
@ComponentScan(basePackages = "com.example")
public class TestMongoConfig {

}
