package com.example.tdd.service;

import com.example.tdd.model.ToDo;
import com.example.tdd.repository.TDDRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TddService {
    private TDDRepository tddRepository;

    public TddService(TDDRepository tddRepository) {
        this.tddRepository = tddRepository;
    }

    public List<ToDo> findAll() {
        return tddRepository.findAll();
    }
}