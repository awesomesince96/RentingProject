package com.springwithjersey.requestdto;

import com.springwithjersey.common.util.Status;
import com.springwithjersey.model.State;

public class StateDto {

  private long stid;
  private String stname;
  private CountryDto stcountry_d;
  private Status ststatus;

  public StateDto(State state) {
    super();
    this.stid = state.getId();
    this.stname = state.getName();
    this.stcountry_d = new CountryDto(state.getCountry());
    this.ststatus = state.getStatus();
  }

  public StateDto() {
    super();
  }

  public long getStid() {
    return stid;
  }

  public void setStid(long stid) {
    this.stid = stid;
  }

  public String getStname() {
    return stname;
  }

  public void setStname(String stname) {
    this.stname = stname;
  }

  public CountryDto getStcountry_d() {
    return stcountry_d;
  }

  public void setStcountry_d(CountryDto stcountry_d) {
    this.stcountry_d = stcountry_d;
  }

  public Status getStstatus() {
    return ststatus;
  }

  public void setStstatus(Status ststatus) {
    this.ststatus = ststatus;
  }

  @Override
  public String toString() {
    return "StateDto [stid=" + stid + ", stname=" + stname + ", stcountry_d=" + stcountry_d + ", ststatus=" + ststatus
        + "]";
  }
}
