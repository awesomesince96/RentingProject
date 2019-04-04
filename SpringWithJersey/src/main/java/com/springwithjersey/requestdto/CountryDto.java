package com.springwithjersey.requestdto;

import com.springwithjersey.common.util.Status;
import com.springwithjersey.model.Country;

public class CountryDto {

  private long coid;
  private String coname;
  private Status costatus;

  public CountryDto() {
    super();
  }

  public CountryDto(Country country) {
    super();
    this.coid = country.getId();
    this.coname = country.getName();
    this.costatus = country.getStatus();
  }

  public long getCoid() {
    return coid;
  }

  public void setCoid(long coid) {
    this.coid = coid;
  }

  public String getConame() {
    return coname;
  }

  public void setConame(String coname) {
    this.coname = coname;
  }

  public Status getCostatus() {
    return costatus;
  }

  public void setCostatus(Status costatus) {
    this.costatus = costatus;
  }

  @Override
  public String toString() {
    return "CountryDto [coid=" + coid + ", coname=" + coname + ", costatus=" + costatus + "]";
  }

}
