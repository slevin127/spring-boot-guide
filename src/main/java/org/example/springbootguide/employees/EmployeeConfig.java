package org.example.springbootguide.employees;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class EmployeeConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            EmployeeRepository employeeRepository
    ) {
        return args -> {
            var employeeList = List.of(
                    new Employee(
                            null,
                            "Vasili",
                            "vsil@gmail.com",
                            LocalDate.of(1987, 11, 18),
                            "Norilsk, Bogdana Hmelnickogo str. house 1, ",

                            100000,
                            "+7-902-552-03-57"

                    ),
                    new Employee(
                            null,
                            "Alexandr",
                            "alex@gmail.com",
                            LocalDate.of(1989, 12, 25),
                            "Norilsk, Bogdana Hmelnickogo str. house 3, ",

                            200000,
                            "+7-911-552-03-57"
                    )
            );
            employeeRepository.saveAll(employeeList);
        };
    }
}
