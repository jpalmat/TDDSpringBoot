package com.example.tdd.controller;

import com.example.tdd.model.ToDo;
import com.example.tdd.service.TddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TddController {
    @Autowired
    public TddService tddService;

    @GetMapping("/todos")
    ResponseEntity<List<ToDo>> getAllToDos(){
        return new ResponseEntity<List<ToDo>>(tddService.findAll(), HttpStatus.OK);
    }
}
