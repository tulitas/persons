package persons;

import org.apache.logging.log4j.jul.LogManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.logging.Logger;

import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;

@SpringBootApplication
@Configuration
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);
//        LogManager.getLogManager().readConfiguration(Application.class.getResourceAsStream("src/main/resources/logging.properties"));

    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(Application.class);
    }


}