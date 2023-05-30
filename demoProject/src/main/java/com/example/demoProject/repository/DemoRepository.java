package com.example.demoProject.repository;

import com.example.demoProject.entity.DemoTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DemoRepository extends JpaRepository<DemoTable, Long> {
    Optional<DemoTable> findById(Long id);
}
