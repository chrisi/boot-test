/**
 * Copyright (c)2015 Lufthansa AirPlus Servicekarten GmbH.
 * <p>
 * All Rights Reserved.
 *
 * @version $Id: filename.java 12345 2012-01-01 12:00:00Z author $
 */
package net.gtidev.boot;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DaemonExecutor;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.ExecuteResultHandler;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

  @RequestMapping("/index")
  public String index() {
    return "redirect:/";
  }

  @RequestMapping("/home")
  public String home() {
    return "redirect:/";
  }

  @RequestMapping("/hello")
  public String hello(Model model) {
    model.addAttribute("name", "Christian");
    return "hello";
  }

  @RequestMapping("/profile")
  public String profile(Model model) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    UserDetails user = (UserDetails) auth.getPrincipal();
    model.addAttribute("user", user.getUsername());
    return "profile";
  }

  @RequestMapping("/exec")
  public String exec() {
    String line = "notepad.exe";
    CommandLine cmdLine = CommandLine.parse(line);
    DefaultExecutor executor = new DaemonExecutor();
    executor.setExitValue(0);
    try {
      executor.execute(cmdLine, new ExecuteResultHandler() {
        @Override
        public void onProcessComplete(int i) {
          int a = 0;
        }

        @Override
        public void onProcessFailed(ExecuteException e) {
          int i = 0;
        }
      });
    }
    catch (Exception e) {
    }

    return "profile";
  }

  @RequestMapping("/failure")
  public String failure() {
    throw new RuntimeException("my custom internal error");
  }
}
