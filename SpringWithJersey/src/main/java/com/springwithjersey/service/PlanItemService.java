package com.springwithjersey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springwithjersey.manager.PlanItemManager;
import com.springwithjersey.model.Item;
import com.springwithjersey.model.PlanItem;

@Service
@Transactional
public class PlanItemService {

  private @Autowired PlanItemManager planItemManager;

  public void createPlanItem(PlanItem planItem) {
    planItemManager.createPlanItem(planItem);
  }

  public PlanItem getPlanItemById(long id) {
    PlanItem planItem = planItemManager.getPlanItemById(id);
    return planItem;
  }

  public List<PlanItem> getPlanItem() {
    List<PlanItem> planItem = planItemManager.getPlanItem();
    return planItem;
  }

  public List<PlanItem> getPlanItemByItem(long id) {
    Item item = new Item();
    item.setId(id);
    List<PlanItem> item_res = planItemManager.getPlanItemByItem(item);
    return item_res;
  }


  public void saveAllPlanItem(List<PlanItem> items) {
    planItemManager.saveAllPlanItem(items);
  }

  public void deletePlanItem(long id) {
    planItemManager.deletePlanItem(id);
  }


}
