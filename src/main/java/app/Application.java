package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


/******************* start the application using ****************************************
 ./mvnw -DskipTests package && java -jar target/springboot-java-hibernate-rest-sql-0.1.0.jar
 ***************************************************************************************/

@SpringBootApplication
@RestController
public class Application {

    /*********** GET : Root '/' or Home Page of Server
     curl --location --request GET 'http://localhost:8080/
     ***********/

    @RequestMapping("/")
    public String home() {
        return "\n\nWelcome! - Springboot + java + Hibernate + Rest API\n\n" +
                "Need more interesting projects, follow me @ https://github.com/eaccmk \n\n";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
