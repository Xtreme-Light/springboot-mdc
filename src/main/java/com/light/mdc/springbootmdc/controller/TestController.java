package com.light.mdc.springbootmdc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

  @GetMapping("/get")
  public String getHelloWorld() {
    log.info("getHelloWorld");
    return "Hello World";
  }

  @PutMapping("/put")
  public String putHelloWorld() {
    log.info("putHelloWorld");
    return "Hello World";
  }

  @PostMapping("/post")
  public String postHelloWorld() {
    log.info("postHelloWorld");
    return "Hello World";
  }


  @DeleteMapping("/delete")
  public String deleteHelloWorld() {
    log.info("deleteHelloWorld");
    return "Hello World";
  }

  @RequestMapping(path = "/orgin", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
  public String orgin() {
    log.info("orgin");
    return "Hello World";
  }
}
