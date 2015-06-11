/**
 * Copyright (c)2015 Lufthansa AirPlus Servicekarten GmbH.
 * <p>
 * All Rights Reserved.
 *
 * @version $Id: filename.java 12345 2012-01-01 12:00:00Z author $
 */
package net.gtidev.boot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Navigation {

  private List<NavItem> navs = new ArrayList<>();

  public Navigation() {
    navs.add(new NavItem("/login", "fa-lock", "Login"));
    navs.add(new NavItem("/hello", "fa-bar-chart-o", "Hello"));
    navs.add(new NavItem("/world", "fa-table", "World"));
    navs.add(new NavItem("/address", "fa-globe", "Address"));
    navs.add(new NavItem("/failure", "fa-wrench", "Failure"));
    navs.add(new NavItem("/profile", "fa-user", "Profile"));
  }

  public List<NavItem> getItems() {
    return navs;
  }
}
