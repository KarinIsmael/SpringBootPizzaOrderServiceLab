package com.example.springbootpizzademo.controllers;

import com.example.springbootpizzademo.entities.Pizza;
import com.example.springbootpizzademo.repositories.PizzaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PizzaController {

    private PizzaRepository pizzaRepository;

    public PizzaController(PizzaRepository pizzaRepository){
        this.pizzaRepository = pizzaRepository;
    }

    /*@GetMapping("/pizzas")
    public List<Pizza>pizzas(){
        return List.of(new Pizza(1L,"Calzone", 100,"Ost, tomatsås, skinka"));
    } *///ovan vill vi göra med att använda vårt repository. Då skapar vi en instans och konstruktor som ovan.
    //då skapar vi en implementation som i nedan metod av vårt repository.

    @GetMapping("/pizzas")
    public List<Pizza> pizzas(){
        return pizzaRepository.findAll();
    } //nu hämtar vi pizzor från databasen med hjälp av vårt repository
}
