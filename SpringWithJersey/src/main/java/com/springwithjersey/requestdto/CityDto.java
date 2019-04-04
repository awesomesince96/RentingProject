package com.springwithjersey.requestdto;

import com.springwithjersey.common.util.Status;
import com.springwithjersey.model.City;

/**
 * @author Krissh
 *
 */
public class CityDto {

  private long ciid;
  private String ciname;
  private StateDto cistate_d;
  private Status cistatus;

  public CityDto() {
    super();
  }

  public CityDto(City city) {
    super();
    this.ciid = city.getId();
    this.ciname = city.getName();
    this.cistate_d = new StateDto(city.getState());
    this.cistatus = city.getStatus();
  }

  public long getCiid() {
    return ciid;
  }

  public void setCiid(long ciid) {
    this.ciid = ciid;
  }

  public String getCiname() {
    return ciname;
  }

  public void setCiname(String ciname) {
    this.ciname = ciname;
  }

  public StateDto getCistate_d() {
    return cistate_d;
  }

  public void setCistate_d(StateDto cistate_d) {
    this.cistate_d = cistate_d;
  }

  public Status getCistatus() {
    return cistatus;
  }

  public void setCistatus(Status cistatus) {
    this.cistatus = cistatus;
  }

  @Override
  public String toString() {
    return "CityDto [ciid=" + ciid + ", ciname=" + ciname + ", cistate_d=" + cistate_d + ", cistatus=" + cistatus + "]";
  }

}
