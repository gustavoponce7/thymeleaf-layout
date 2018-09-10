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
                                  StudentService studentService){
        return (args) -> {
            //Creating Bar sample data
            barService.createBar(Bar.builder().name("La Opera").build());
            barService.createBar(Bar.builder().name("La Valenciana").build());
            barService.createBar(Bar.builder().name("Montejo").build());
            barService.createBar(Bar.builder().name("Salon Corona").build());
            barService.createBar(Bar.builder().name("La China Poblana").build());

            //Creating Beer sample data
            beerService.createBeer(Beer.builder().name("Corona").build());
            beerService.createBeer(Beer.builder().name("Gordon Five").build());
            beerService.createBeer(Beer.builder().name("Kozel").build());
            beerService.createBeer(Beer.builder().name("Siberian Crown").build());
            beerService.createBeer(Beer.builder().name("Shiner").build());

            //Creating Student sample data
            studentService.createStudent(Student.builder().name("Student Sample 1").build());
            studentService.createStudent(Student.builder().name("Student Sample 2").build());
            studentService.createStudent(Student.builder().name("Student Sample 3").build());
            studentService.createStudent(Student.builder().name("Student Sample 4").build());
            studentService.createStudent(Student.builder().name("Student Sample 5").build());

            log.info("Bar count: " + barService.getAllBars().size());
            log.info("Beer count: " + beerService.getAllBeers().size());
            log.info("Student count: " + studentService.getAllStudents().size());

        };
    }
}
