package az.xazar.msauthamigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class MsAuthAmigoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsAuthAmigoApplication.class, args);
    }

}
