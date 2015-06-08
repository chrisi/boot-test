/**
 * Copyright (c)2015 Lufthansa AirPlus Servicekarten GmbH.
 * <p>
 * All Rights Reserved.
 *
 * @version $Id: filename.java 12345 2012-01-01 12:00:00Z author $
 */
package net.gtidev.boot;


import org.hibernate.validator.constraints.NotEmpty;

public class Address {
  private String street;
  private String zip;
  private String city;

  @NotEmpty
  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  @NotEmpty
  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  @NotEmpty
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
}
