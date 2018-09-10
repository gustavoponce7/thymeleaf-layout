package com.gpch.thymeleaflayout.repository;

import com.gpch.thymeleaflayout.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long> {
}
