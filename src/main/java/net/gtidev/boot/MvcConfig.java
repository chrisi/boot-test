/**
 * Copyright (c)2015 Lufthansa AirPlus Servicekarten GmbH.
 * <p>
 * All Rights Reserved.
 *
 * @version $Id: filename.java 12345 2012-01-01 12:00:00Z author $
 */
package net.gtidev.boot;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("index");
    registry.addViewController("/world").setViewName("world");
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/404").setViewName("404");
    registry.addViewController("/error").setViewName("error");
  }

  @Bean
  public EmbeddedServletContainerCustomizer containerCustomizer() {

    return container -> {
      ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
      container.addErrorPages(error404Page);
    };

  }

  @Bean
  public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
    SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();

    Properties mappings = new Properties();
    mappings.setProperty("DatabaseException", "databaseError");
    mappings.setProperty("InvalidCreditCardException", "creditCardError");

    r.setExceptionMappings(mappings);  // None by default
    r.setDefaultErrorView("error");
    r.setWarnLogCategory("net.gtidev.error");
    return r;
  }

}