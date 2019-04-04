package com.springwithjersey.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springwithjersey.common.util.Status;
import com.springwithjersey.model.Item;
import com.springwithjersey.model.PlanItem;
import com.springwithjersey.rest.data.PlanItemRepository;

@Service
public class PlanItemManager {

  private @Autowired PlanItemRepository planItemRepository;

  public void createPlanItem(PlanItem planItem) {
    planItemRepository.save(planItem);
  }

  public PlanItem getPlanItemById(long id) {
    return planItemRepository.findById(id);
  }

  public List<PlanItem> getPlanItem() {
    return planItemRepository.findAllByStatus(Status.ACTIVE);
  }

  public List<PlanItem> getPlanItemByItem(Item item) {
    return planItemRepository.findAllByItem(item);
  }

  public void saveAllPlanItem(List<PlanItem> planItem) {
    planItemRepository.save(planItem);
  }

  public void deletePlanItem(long id) {
    long result = planItemRepository.deleteById(id);
  }

}
