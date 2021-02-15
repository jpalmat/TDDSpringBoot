package com.example.tdd.service;

import com.example.tdd.model.ToDo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TddService {
    public List<ToDo> findAll() {
        return new ArrayList<>();
    }
}