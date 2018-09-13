package com.gpch.thymeleaflayout.service;

import com.gpch.thymeleaflayout.model.Bar;
import com.gpch.thymeleaflayout.repository.BarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BarService {

    private BarRepository barRepository;

    public BarService(BarRepository barRepository) {
        this.barRepository = barRepository;
    }

    public List<Bar> getAllBars(){
        return barRepository.findAll();
    }

    public Bar createBar(Bar bar){
        return barRepository.save(bar);
    }

    public Page<Bar> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Bar> bars = barRepository.findAll();
        List<Bar> list;

        if (bars.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, bars.size());
            list = bars.subList(startItem, toIndex);
        }

        Page<Bar> barPage
                = new PageImpl<Bar>(list, PageRequest.of(currentPage, pageSize), bars.size());

        return barPage;
    }
}
