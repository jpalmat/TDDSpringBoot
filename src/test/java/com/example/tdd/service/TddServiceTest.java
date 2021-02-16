package com.example.tdd.service;

import com.example.tdd.model.ToDo;
import com.example.tdd.repository.TDDRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TddServiceTest {

    @MockBean
    private TDDRepository tddRepository;

    @Test
    void getAllToDos(){
        ToDo todoSample = new ToDo("wqTodo sample 1", true);
        tddRepository.save(todoSample);
        TddService tddService = new TddService(tddRepository);

        List<ToDo> toDoList = tddService.findAll();
        ToDo lastTodo = toDoList.get(toDoList.size()-1);

        assertEquals(todoSample.getText(), lastTodo.getText());
    }

}