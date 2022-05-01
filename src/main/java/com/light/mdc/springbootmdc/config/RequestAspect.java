package com.light.mdc.springbootmdc.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Aspect
@Component
@Slf4j
public class RequestAspect {

  @Pointcut(
      "execution(public * com..controller..*(..)) && (@annotation(org.springframework.web.bind.annotation.RequestMapping) ||"
          + " @annotation(org.springframework.web.bind.annotation.PostMapping) ||"
          + "@annotation(org.springframework.web.bind.annotation.DeleteMapping) ||"
          + "@annotation(org.springframework.web.bind.annotation.PutMapping) ||"
          + "@annotation(org.springframework.web.bind.annotation.PatchMapping))")
  public void controllerPointCut() {}

  @Around("controllerPointCut() && @annotation(requestMapping)")
  public Object around(ProceedingJoinPoint proceedingJoinPoint, RequestMapping requestMapping)
      throws Throwable {
    log.info("RequestAspect.around()");
    Object result = proceedingJoinPoint.proceed();
    log.info("RequestAspect.around()");
    return result;
  }
  @Around("controllerPointCut() && @annotation(postMapping)")
  public Object around(ProceedingJoinPoint proceedingJoinPoint, PostMapping postMapping)
      throws Throwable {
    log.info("RequestAspect.postMapping.around()");
    Object result = proceedingJoinPoint.proceed();
    final String name = proceedingJoinPoint.getTarget().getClass().getName();
    log.info("class name is {}",name);
    final String methodName = proceedingJoinPoint.getSignature().getName();
    log.info("method name is {} ",methodName);
    log.info("RequestAspect.postMapping.around()");
    return result;
  }
}
