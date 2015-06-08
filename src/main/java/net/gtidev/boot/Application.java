/**
 * Copyright (c)2015 Lufthansa AirPlus Servicekarten GmbH.
 * <p>
 * All Rights Reserved.
 *
 * @version $Id: filename.java 12345 2012-01-01 12:00:00Z author $
 */
package net.gtidev.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  public static void main(String[] args) throws Throwable {
    SpringApplication.run(Application.class, args);
  }

}