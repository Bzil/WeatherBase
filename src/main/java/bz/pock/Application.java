package bz.pock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("bz.pock")
public class Application {
    /**
     * Main. Pour charger les beans.
     *
     * @param args liste args
     * @throws Exception erreur
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
