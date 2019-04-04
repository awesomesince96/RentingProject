package com.springwithjersey.requestdto;

import java.sql.Timestamp;

public class IntrestedUserDto {

  private long iuid;
  private UserDto iuus;
  private ItemDto iuitem;
  private Timestamp time;

  public IntrestedUserDto() {
    super();
  }

  public IntrestedUserDto(long iuid, UserDto iuus, ItemDto iuitem, Timestamp time) {
    super();
    this.iuid = iuid;
    this.iuus = iuus;
    this.iuitem = iuitem;
    this.time = time;
  }

  public long getIuid() {
    return iuid;
  }

  public void setIuid(long iuid) {
    this.iuid = iuid;
  }

  public UserDto getIuus() {
    return iuus;
  }

  public void setIuus(UserDto iuus) {
    this.iuus = iuus;
  }

  public ItemDto getIuitem() {
    return iuitem;
  }

  public void setIuitem(ItemDto iuitem) {
    this.iuitem = iuitem;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }

  @Override
  public String toString() {
    return "IntresetedUserDto [iuid=" + iuid + ", iuus=" + iuus + ", iuitem=" + iuitem + ", time=" + time + "]";
  }

}
