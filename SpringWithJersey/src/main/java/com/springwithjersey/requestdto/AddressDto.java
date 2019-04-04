package com.springwithjersey.requestdto;

import com.springwithjersey.common.util.Status;

public class AddressDto {

  private long adid;
  private String adhno;
  private String adsno;
  private String adar;
  private String adlm;
  private String adpin;
  private String adaltno;
  private UserDto aduser;
  private Status adstatus;

  public AddressDto() {
    super();
  }

  public AddressDto(long adid, String adhno, String adsno, String adar, String adlm, String adpin, String adaltno,
      UserDto aduser, Status adstatus) {
    super();
    this.adid = adid;
    this.adhno = adhno;
    this.adsno = adsno;
    this.adar = adar;
    this.adlm = adlm;
    this.adpin = adpin;
    this.adaltno = adaltno;
    this.aduser = aduser;
    this.adstatus = adstatus;
  }

  public long getAdid() {
    return adid;
  }

  public void setAdid(long adid) {
    this.adid = adid;
  }

  public String getAdhno() {
    return adhno;
  }

  public void setAdhno(String adhno) {
    this.adhno = adhno;
  }

  public String getAdsno() {
    return adsno;
  }

  public void setAdsno(String adsno) {
    this.adsno = adsno;
  }

  public String getAdar() {
    return adar;
  }

  public void setAdar(String adar) {
    this.adar = adar;
  }

  public String getAdlm() {
    return adlm;
  }

  public void setAdlm(String adlm) {
    this.adlm = adlm;
  }

  public String getAdpin() {
    return adpin;
  }

  public void setAdpin(String adpin) {
    this.adpin = adpin;
  }

  public String getAdaltno() {
    return adaltno;
  }

  public void setAdaltno(String adaltno) {
    this.adaltno = adaltno;
  }

  public UserDto getAduser() {
    return aduser;
  }

  public void setAduser(UserDto aduser) {
    this.aduser = aduser;
  }

  public Status getAdstatus() {
    return adstatus;
  }

  public void setAdstatus(Status adstatus) {
    this.adstatus = adstatus;
  }

  @Override
  public String toString() {
    return "AddressDto [adid=" + adid + ", adhno=" + adhno + ", adsno=" + adsno + ", adar=" + adar + ", adlm=" + adlm
        + ", adpin=" + adpin + ", adaltno=" + adaltno + ", adstatus=" + adstatus + "]";
  }

}
