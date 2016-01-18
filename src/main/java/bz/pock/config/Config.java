package bz.pock.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import static java.util.Collections.singletonList;

@Configuration
@EnableMongoRepositories(basePackages = "bz.pock.persistence")
public class Config extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "Bz";
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient(singletonList(new ServerAddress("127.0.0.1", 27017)));
    }

    @Override
    protected String getMappingBasePackage() {
        return "bz.pock.model";
    }

    /**
     * Define message source.
     *
     * @return bundle
     */
    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
        messageBundle.setBasename("classpath:messages/error");
        messageBundle.setDefaultEncoding("UTF-8");
        return messageBundle;
    }
}
