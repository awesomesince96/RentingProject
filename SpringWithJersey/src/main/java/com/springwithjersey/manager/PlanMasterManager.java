package com.springwithjersey.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springwithjersey.model.PlanMaster;
import com.springwithjersey.rest.data.PlanMasterRepository;

@Service
public class PlanMasterManager {

  private @Autowired PlanMasterRepository planmasterrepository;

  public void createPlanMaster(PlanMaster planmaster) {
    planmasterrepository.save(planmaster);
  }

  public PlanMaster getPlanMasterById(long id) {
    return planmasterrepository.findById(id);
  }

  public List<PlanMaster> getPlanMaster() {
    // System.out.println("--->" + planmasterrepository.findAllByStatus(Status.ACTIVE));
    return planmasterrepository.findAll();
  }

  public void deletePlanMaster(long id) {
    long result = planmasterrepository.deleteById(id);
  }

  public void saveAllPlanMaster(List<PlanMaster> countries) {
    planmasterrepository.save(countries);
  }
}
