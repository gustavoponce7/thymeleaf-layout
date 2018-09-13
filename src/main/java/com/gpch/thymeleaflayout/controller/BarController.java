package com.gpch.thymeleaflayout.controller;

import com.gpch.thymeleaflayout.model.Bar;
import com.gpch.thymeleaflayout.service.BarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class BarController {

    private static int currentPage = 1;
    private static int pageSize = 5;

    private final BarService barService;

    public BarController(BarService barService) {
        this.barService = barService;
    }

/*    @GetMapping("/bar")
    public ModelAndView bar(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fragments/bar");
        modelAndView.addObject("bars", barService.getAllBars());
        return modelAndView;
    }*/

    @GetMapping("/bar")
    public ModelAndView bar(Model model,
                            @RequestParam("page") Optional<Integer> page,
                            @RequestParam("size") Optional<Integer> size) {
        ModelAndView modelAndView = new ModelAndView();
        page.ifPresent(p -> currentPage = p);
        size.ifPresent(s -> pageSize = s);
        Page<Bar> barPage = barService.findPaginated(PageRequest.of(currentPage - 1, pageSize));
        int totalPages = barPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            modelAndView.addObject("pageNumbers", pageNumbers);
        }
        modelAndView.addObject("barPage", barPage);
        modelAndView.setViewName("fragments/bar");
        return modelAndView;
    }

}
