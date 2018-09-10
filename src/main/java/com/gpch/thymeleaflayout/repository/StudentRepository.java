package com.gpch.thymeleaflayout.repository;

import com.gpch.thymeleaflayout.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
