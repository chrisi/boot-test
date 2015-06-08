/**
 * Copyright (c)2015 Lufthansa AirPlus Servicekarten GmbH.
 * <p>
 * All Rights Reserved.
 *
 * @version $Id: filename.java 12345 2012-01-01 12:00:00Z author $
 */
package net.gtidev.boot;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/address")
public class AddressController {

  @RequestMapping(method = RequestMethod.GET)
  public String get(Address address) {
    return "address";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String post(@Valid Address address, BindingResult result) {
    int i = result.getErrorCount();

    if (!address.getZip().equals("63322")) {
      result.rejectValue("zip", "zip.wrongValue", "zip has to be 63322");
      return "address";
    }
    return "redirect:/";
  }
}
