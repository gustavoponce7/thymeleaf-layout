package com.gpch.thymeleaflayout.service;

import com.gpch.thymeleaflayout.model.Bar;
import com.gpch.thymeleaflayout.repository.BarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarService {

    private BarRepository barRepository;

    public BarService(BarRepository barRepository) {
        this.barRepository = barRepository;
    }

    public List<Bar> getAllBars(){
        return  barRepository.findAll();
    }

    public Bar createBar(Bar bar){
        return barRepository.save(bar);
    }
}
