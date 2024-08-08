package com.jali.testingJpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;;

public interface GreetingRepository extends CrudRepository<Greeting, Long>{
    List<Greeting> findByMessage(String message);
    Greeting findById(long id);
}
