package com.example.tdd.controller;
import com.example.tdd.model.ToDo;
import com.example.tdd.service.TddService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class TddControllerTest {

    /**
     * MockMvc has been around since Spring 3.2. This providing a powerful way to mock Spring MVC for testing MVC web applications. Through MockMvc, you can send
     * mock HTTP requests to a controller
     */
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private TddService tddService;

    @Test
     void getAllToDos() throws Exception {
        List<ToDo> toDoList = new ArrayList<ToDo>();
        toDoList.add(new ToDo(1L, "Eat thrice", true));
        toDoList.add(new ToDo(2L, "Sleep twice", true));
        when(tddService.findAll()).thenReturn(toDoList);

        mockMvc.perform(MockMvcRequestBuilders.get("/todos")
        .contentType(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$", hasSize(2))).andDo(print());
    }

}
