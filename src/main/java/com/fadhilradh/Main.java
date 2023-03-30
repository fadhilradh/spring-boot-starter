package com.fadhilradh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public GreetResponse salam() {
        GreetResponse response = new GreetResponse(
                "Salam",
                List.of("coding", "being grateful"),
                new Person("Fadhil", 29, 30_000)
        );

        return response;
    }

    record GreetResponse(String salam, List<String> hobbies, Person person) {
    }

    record Person(String name, int age, double savings) {
    }
}

