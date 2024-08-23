package com.jali;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JaliApplication {

  public static final Logger log = LoggerFactory.getLogger(JaliApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(JaliApplication.class);
  }

  
}

