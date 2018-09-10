package com.gpch.thymeleaflayout.repository;

import com.gpch.thymeleaflayout.model.Bar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarRepository extends JpaRepository<Bar, Long> {
}
