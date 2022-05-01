package com.light.mdc.springbootmdc.controller;

import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RestController
@Slf4j
public class TestController {
  @Autowired private RequestMappingHandlerMapping requestMappingHandlerMapping;

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

  @RequestMapping(
      path = "/orgin",
      produces = "application/json",
      consumes = "application/json",
      method = RequestMethod.POST)
  public String orgin() {
    log.info("orgin");
    return "Hello World";
  }

  @GetMapping("/list")
  public String list() {
    requestMappingHandlerMapping
        .getHandlerMethods()
        .forEach(
            (k, v) -> {
              log.info("key,{},value,{}", k, v);
              final Method method = v.getMethod();
              log.info("method {} ", method);
              final String name = method.getName();
              log.info("method name {} ", name);
              final String name1 = method.getDeclaringClass().getName();
              log.info("declaring class name {} ", name1);
              final Class<?>[] parameterTypes = method.getParameterTypes();
              for (Class<?> parameterType : parameterTypes) {
                log.info("parameter type {} ", parameterType);
              }
              final HandlerMethod resolvedFromHandlerMethod = v.getResolvedFromHandlerMethod();
              log.info("resolvedFromHandlerMethod {} ", resolvedFromHandlerMethod);
              final MethodParameter[] methodParameters = v.getMethodParameters();
              for (MethodParameter methodParameter : methodParameters) {
                log.info("methodParameters {} ", methodParameter);
              }
            });
    return "Hello World";
  }
}
