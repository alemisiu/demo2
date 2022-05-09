package pl.javastart.devicrent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import pl.javastart.devicrent.app.ApplicationController;

import java.util.Scanner;

@SpringBootApplication
public class Devicrent4Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Devicrent4Application.class, args);
        ApplicationController controller = ctx.getBean(ApplicationController.class);
        controller.mainLoop();
    }

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}