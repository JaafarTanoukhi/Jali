package com.jali.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jali.testingJpa.Greeting;
import com.jali.testingJpa.GreetingRepository;

@RestController
public class GreetingController {

    private final GreetingRepository greetingRepository;

    public GreetingController(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // @GetMapping("/greetings/{id}")
    // public Greeting getGreeting(@PathVariable Long id) {
    //     return greetingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Greeting not found"));
    // }

    @CrossOrigin(origins = "*")
    @GetMapping("/greetings")
    public List<Greeting> createGreeting() {
        return (List<Greeting>)greetingRepository.findAll();
    }
}
