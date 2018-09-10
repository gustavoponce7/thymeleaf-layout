package com.gpch.thymeleaflayout.service;

import com.gpch.thymeleaflayout.model.Beer;
import com.gpch.thymeleaflayout.repository.BeerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeerService {

    private final BeerRepository beerRepository;

    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public List<Beer> getAllBeers(){
        return  beerRepository.findAll();
    }

    public Beer createBeer(Beer beer){
        return beerRepository.save(beer);
    }
}
