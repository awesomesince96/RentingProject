package com.springwithjersey.requestdto;

public class PlanItemDto {

  private long piid;
  private PlanMasterDto piplan;
  private ItemDto piitem;
  private long piprice;

  public PlanItemDto() {
    super();
  }

  public PlanItemDto(long piid, PlanMasterDto piplan, ItemDto piitem, long piprice) {
    super();
    this.piid = piid;
    this.piplan = piplan;
    this.piitem = piitem;
    this.piprice = piprice;
  }

  public long getPiid() {
    return piid;
  }

  public void setPiid(long piid) {
    this.piid = piid;
  }

  public PlanMasterDto getPiplan() {
    return piplan;
  }

  public void setPiplan(PlanMasterDto piplan) {
    this.piplan = piplan;
  }

  public ItemDto getPiitem() {
    return piitem;
  }

  public void setPiitem(ItemDto piitem) {
    this.piitem = piitem;
  }

  public long getPiprice() {
    return piprice;
  }

  public void setPiprice(long piprice) {
    this.piprice = piprice;
  }

  @Override
  public String toString() {
    return "PlanItemDto [piid=" + piid + ", piplan=" + piplan + ", piitem=" + piitem + ", piprice=" + piprice + "]";
  }

}
