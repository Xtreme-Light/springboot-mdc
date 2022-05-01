package com.light.mdc.springbootmdc.config;

import ch.qos.logback.classic.ViewStatusMessagesServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogbackViewStatusMessagesServlet {

  /**
   * 配置logback-spring.xml中的servlet
   * @return servlet
   */
  @Bean
  public ServletRegistrationBean<ViewStatusMessagesServlet> ViewStatusMessagesServlet() {
    return new ServletRegistrationBean<>(new ViewStatusMessagesServlet(), "/logback-status");
  }

}
