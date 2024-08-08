package com.jali;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jali.testingJpa.Greeting;
import com.jali.testingJpa.GreetingRepository;

@SpringBootApplication
public class JaliApplication {

  private static final Logger log = LoggerFactory.getLogger(JaliApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(JaliApplication.class);
  }

  @Bean
  public CommandLineRunner demo(GreetingRepository repository) {
    return (args) -> {
		repository.deleteAll();
		log.info("Started Working Here");
      // save a few Greetings
      repository.save(new Greeting("Hello World"));
      repository.save(new Greeting("Sup G"));
      repository.save(new Greeting("salam alaykom world"));
	  
      // fetch all Greetings
      log.info("Greetings found with findAll():");
      log.info("-------------------------------");
      repository.findAll().forEach(Greeting -> {
		  log.info(Greeting.toString());
		});
      log.info("");
	  
      // fetch an individual Greeting by ID
      Greeting Greeting = repository.findById(2);
      log.info("Greeting found with findById(1L):");
      log.info("--------------------------------");
	  if(Greeting != null)
      	log.info(Greeting.toString());
      log.info("");
	  
      // fetch Greetings by last name
      log.info("Greeting found with findByLastName('Bauer'):");
      log.info("--------------------------------------------");
      repository.findByMessage("Hello World").forEach(bauer -> {
		if(bauer != null){
			log.info(bauer.toString());
		}
		});
		log.info("");
		
		log.info("Ended");
    };
}

}