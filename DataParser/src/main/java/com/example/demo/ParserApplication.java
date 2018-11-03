package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class ParserApplication {
  public static void main(String[] args) {
    SpringApplication.run(ParserApplication.class, args);
  }

  @GetMapping("/")
  public String hello() {
    return "hello world!";
  }
}

