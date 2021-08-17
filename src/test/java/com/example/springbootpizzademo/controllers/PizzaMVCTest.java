package com.example.springbootpizzademo.controllers;

import com.example.springbootpizzademo.repositories.PizzaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//detta test är som ett mellanting mellan enklaste och högsta nivån av tidigare tester
//detta för att slippa starta upp allt, vi kan begränsa så den bara startar upp vissa saker.
//i detta fall starta upp PizzaController och allt som behövs för att testa den klassen

@WebMvcTest(controllers = PizzaController.class)
class PizzaMVCTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PizzaRepository pizzaRepository;

    @Test
    void getAllPizzasReturnsOnePizza() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/pizzas"))
                .andExpect(status().is(200));
    }
}