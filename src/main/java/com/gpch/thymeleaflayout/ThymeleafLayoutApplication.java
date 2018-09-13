package com.gpch.thymeleaflayout;

import com.gpch.thymeleaflayout.model.Bar;
import com.gpch.thymeleaflayout.model.Beer;
import com.gpch.thymeleaflayout.model.Student;
import com.gpch.thymeleaflayout.service.BarService;
import com.gpch.thymeleaflayout.service.BeerService;
import com.gpch.thymeleaflayout.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class ThymeleafLayoutApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafLayoutApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(BarService barService,
                                  BeerService beerService,
                                  StudentService studentService) {
        return (args) -> {
            //Creating sample data
            for (int i = 1; i <= 70; i++) {
                barService.createBar(Bar.builder().name("Bar " + i).build());
                beerService.createBeer(Beer.builder().name("Beer " + i).build());
                studentService.createStudent(Student.builder().name("Student " + i).build());
            }

            log.info("Bar count: " + barService.getAllBars().size());
            log.info("Beer count: " + beerService.getAllBeers().size());
            log.info("Student count: " + studentService.getAllStudents().size());
        };
    }
}
