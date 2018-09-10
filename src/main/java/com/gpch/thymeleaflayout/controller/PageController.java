package com.gpch.thymeleaflayout.controller;

import com.gpch.thymeleaflayout.service.BarService;
import com.gpch.thymeleaflayout.service.BeerService;
import com.gpch.thymeleaflayout.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    private final BarService barService;
    private final BeerService beerService;
    private final StudentService studentService;

    public PageController(BarService barService,
                          BeerService beerService,
                          StudentService studentService) {
        this.barService = barService;
        this.beerService = beerService;
        this.studentService = studentService;
    }


    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/bar")
    public String bar(Model model) {
        return "fragments/bar";
    }

    @GetMapping("/beer")
    public String beer(Model model) {
        return "fragments/beer";
    }

    @GetMapping("/student")
    public String student(Model model) {
        return "fragments/student";
    }
}
