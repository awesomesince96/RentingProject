package com.springwithjersey.requestdto;

import com.springwithjersey.common.util.Status;

public class SubCategoryDto {

  private long suid;
  private String suname;
  private Status susatus;
  private CategoryDto sucat;

  public SubCategoryDto() {
    super();
  }

  public SubCategoryDto(long suid, String suname, Status susatus, CategoryDto sucat) {
    super();
    this.suid = suid;
    this.suname = suname;
    this.susatus = susatus;
    this.sucat = sucat;
  }

  public long getSuid() {
    return suid;
  }

  public void setSuid(long suid) {
    this.suid = suid;
  }

  public String getSuname() {
    return suname;
  }

  public void setSuname(String suname) {
    this.suname = suname;
  }

  public Status getSusatus() {
    return susatus;
  }

  public void setSusatus(Status susatus) {
    this.susatus = susatus;
  }

  public CategoryDto getSucat() {
    return sucat;
  }

  public void setSucat(CategoryDto sucat) {
    this.sucat = sucat;
  }

  @Override
  public String toString() {
    return "SubCategory [suid=" + suid + ", suname=" + suname + ", susatus=" + susatus + ", sucat=" + sucat + "]";
  }

}
