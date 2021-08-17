package com.example.springbootpizzademo.controllers;

import com.example.springbootpizzademo.repositories.PizzaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class PizzaControllerTest {

    @Mock
    PizzaRepository pizzaRepository;
    //mockar pizzarepo för att det behövs en instans av den i nedan metod.

   @Test
    void getAllPizzas(){

        PizzaController pizzaController = new PizzaController(pizzaRepository);
        assertThat(pizzaController.pizzas()).isEmpty();
    }

}