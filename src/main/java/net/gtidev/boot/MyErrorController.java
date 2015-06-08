/**
 * Copyright (c)2015 Lufthansa AirPlus Servicekarten GmbH.
 * <p>
 * All Rights Reserved.
 *
 * @version $Id: filename.java 12345 2012-01-01 12:00:00Z author $
 */
package net.gtidev.boot;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MyErrorController implements ErrorController {

  private static final String StatusCode = "javax.servlet.error.status_code";
  private static final String Message = "javax.servlet.error.message";
  private static final String RequestUri = "javax.servlet.error.request_uri";
  private static final String Exception = "javax.servlet.error.exception";

  private static final Logger LOG = LoggerFactory.getLogger(MyErrorController.class);

  @RequestMapping(value = "/error")
  public String error(Model model, HttpServletRequest req, HttpServletResponse resp, RedirectAttributes ra) throws IOException {
    if ((Integer) req.getAttribute(StatusCode) == 404) {
      ra.addFlashAttribute("error", "Page not be found:" + req.getAttribute(RequestUri));
    }
    if ((Integer) req.getAttribute(StatusCode) == 500) {
      Throwable ex = (Throwable) req.getAttribute(Exception);
      if (ex.getCause() != null) {
        ex = ex.getCause();
      }
      ra.addFlashAttribute("error", "Internal error occured: " + ex.getMessage());
    }
    return "redirect:/";
  }

  @Override
  public String getErrorPath() {
    return "/error";
  }
}