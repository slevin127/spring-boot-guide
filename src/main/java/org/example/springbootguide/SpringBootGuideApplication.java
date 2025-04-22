package org.example.springbootguide;

import org.example.springbootguide.employees.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


@RestController
@SpringBootApplication
public class SpringBootGuideApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGuideApplication.class, args);
    }



}

