package com.springwithjersey.requestdto;

import com.springwithjersey.common.util.Status;

public class CategoryDto {

  private long caid;
  private String caname;
  private Status castatus;

  public CategoryDto() {
    super();
  }

  public CategoryDto(long caid, String caname, Status castatus) {
    super();
    this.caid = caid;
    this.caname = caname;
    this.castatus = castatus;
  }

  public long getCaid() {
    return caid;
  }

  public void setCaid(long caid) {
    this.caid = caid;
  }

  public String getCaname() {
    return caname;
  }

  public void setCaname(String caname) {
    this.caname = caname;
  }

  public Status getCastatus() {
    return castatus;
  }

  public void setCastatus(Status castatus) {
    this.castatus = castatus;
  }

  @Override
  public String toString() {
    return "CategoryDto [caid=" + caid + ", caname=" + caname + ", castatus=" + castatus + "]";
  }

}
