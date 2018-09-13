package com.gpch.thymeleaflayout.controller;

import com.gpch.thymeleaflayout.service.BeerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/beer")
    public ModelAndView beer(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fragments/beer");
        modelAndView.addObject("beers", beerService.getAllBeers());
        return modelAndView;
    }

}
