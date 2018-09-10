package com.gpch.thymeleaflayout.controller;

import com.gpch.thymeleaflayout.service.BarService;
import com.gpch.thymeleaflayout.service.BeerService;
import com.gpch.thymeleaflayout.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView bar(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fragments/bar");
        modelAndView.addObject("bars", barService.getAllBars());
        return modelAndView;
    }

    @GetMapping("/beer")
    public ModelAndView beer(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fragments/beer");
        modelAndView.addObject("beers", beerService.getAllBeers());
        return modelAndView;
    }

    @GetMapping("/student")
    public ModelAndView student(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fragments/student");
        modelAndView.addObject("students", studentService.getAllStudents());
        return modelAndView;
    }
}
