package com.example.firstapp.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository
    ) {
        return args -> {
            Student mariam = new Student(
                    1L,
                    "Mariam",
                    LocalDate.of(2004, Month.JULY, 20),
                    "Mariam"

            );
            Student fiona = new Student(
                    2L,
                    "fiona",
                    LocalDate.of(1998, Month.APRIL, 20),
                    "fiona@fiona.com"

            );
            Student morelle = new Student(
                    3L,
                    "morelle",
                    LocalDate.of(2010, Month.APRIL, 20),
                    "morelle@morelle.com"

            );
            Student jones = new Student(
                    4L,
                    "jones",
                    LocalDate.of(2009, Month.APRIL, 20),
                    "jones@jones.com"
            );
            repository.saveAll(List.of(morelle,jones,fiona,mariam));
        };
    }
}
