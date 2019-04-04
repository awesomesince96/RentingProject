package com.springwithjersey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springwithjersey.manager.PlanMasterManager;
import com.springwithjersey.model.PlanMaster;

@Service
@Transactional
public class PlanMasterService {

  private @Autowired PlanMasterManager planmastermanager;

  public void createPlanMaster(PlanMaster planmaster) {
    planmastermanager.createPlanMaster(planmaster);
  }

  public PlanMaster getPlanMasterById(long id) {
    return planmastermanager.getPlanMasterById(id);
  }

  public List<PlanMaster> getPlanMaster() {
    return planmastermanager.getPlanMaster();
  }

  public void deletePlanMaster(long id) {
    planmastermanager.deletePlanMaster(id);
  }

  public void saveAllPlanMaster(List<PlanMaster> planmaster) {
    planmastermanager.saveAllPlanMaster(planmaster);
  }

}
