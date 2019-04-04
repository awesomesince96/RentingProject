package com.springwithjersey.requestdto;

import com.springwithjersey.common.util.Status;

public class PlanMasterDto {

  private long pmid;
  private String pmname;
  private String pmdays;
  private Status pmstatus;

  public PlanMasterDto() {
    super();
  }

  public PlanMasterDto(long pmid, String pmname, String pmdays, Status pmstatus) {
    super();
    this.pmid = pmid;
    this.pmname = pmname;
    this.pmdays = pmdays;
    this.pmstatus = pmstatus;
  }

  public long getPmid() {
    return pmid;
  }

  public void setPmid(long pmid) {
    this.pmid = pmid;
  }

  public String getPmname() {
    return pmname;
  }

  public void setPmname(String pmname) {
    this.pmname = pmname;
  }

  public String getPmdays() {
    return pmdays;
  }

  public void setPmdays(String pmdays) {
    this.pmdays = pmdays;
  }

  public Status getPmstatus() {
    return pmstatus;
  }

  public void setPmstatus(Status pmstatus) {
    this.pmstatus = pmstatus;
  }

  @Override
  public String toString() {
    return "PlanMasterDto [pmid=" + pmid + ", pmname=" + pmname + ", pmdays=" + pmdays + ", pmstatus=" + pmstatus + "]";
  }

}
