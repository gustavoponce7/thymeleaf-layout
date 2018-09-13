package com.gpch.thymeleaflayout.controller;

import com.gpch.thymeleaflayout.service.BarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BarController {

    private final BarService barService;

    public BarController(BarService barService) {
        this.barService = barService;
    }

    @GetMapping("/bar")
    public ModelAndView bar(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fragments/bar");
        modelAndView.addObject("bars", barService.getAllBars());
        return modelAndView;
    }

}
