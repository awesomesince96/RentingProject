package com.springwithjersey.requestdto;

import com.springwithjersey.common.util.Role;
import com.springwithjersey.common.util.Status;

public class UserDto {

  private long usid;
  private String usfn;
  private String usln;
  private String uscn;
  private String usem;
  private String uspw;
  private Role usrole;
  private Status usstatus;

  public UserDto() {
    super();
  }

  public UserDto(long usid, String usfn, String usln, String uscn, String usem, String uspw, Role usrole,
      Status usstatus) {
    super();
    this.usid = usid;
    this.usfn = usfn;
    this.usln = usln;
    this.uscn = uscn;
    this.usem = usem;
    this.uspw = uspw;
    this.usrole = usrole;
    this.usstatus = usstatus;
  }

  public long getUsid() {
    return usid;
  }

  public void setUsid(long usid) {
    this.usid = usid;
  }

  public String getUsfn() {
    return usfn;
  }

  public void setUsfn(String usfn) {
    this.usfn = usfn;
  }

  public String getUsln() {
    return usln;
  }

  public void setUsln(String usln) {
    this.usln = usln;
  }

  public String getUscn() {
    return uscn;
  }

  public void setUscn(String uscn) {
    this.uscn = uscn;
  }

  public String getUsem() {
    return usem;
  }

  public void setUsem(String usem) {
    this.usem = usem;
  }

  public String getUspw() {
    return uspw;
  }

  public void setUspw(String uspw) {
    this.uspw = uspw;
  }

  public Role getUsrole() {
    return usrole;
  }

  public void setUsrole(Role usrole) {
    this.usrole = usrole;
  }

  public Status getUsstatus() {
    return usstatus;
  }

  public void setUsstatus(Status usstatus) {
    this.usstatus = usstatus;
  }

  @Override
  public String toString() {
    return "UserDto [usid=" + usid + ", usfn=" + usfn + ", usln=" + usln + ", uscn=" + uscn + ", usem=" + usem
        + ", uspw=" + uspw + ", usrole=" + usrole + ", usstatus=" + usstatus + "]";
  }

}
