package com.example.tdd.repository;

import com.example.tdd.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TDDRepository extends JpaRepository<ToDo, Long> {
}