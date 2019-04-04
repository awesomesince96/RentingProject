package com.springwithjersey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springwithjersey.manager.StateManager;
import com.springwithjersey.model.Country;
import com.springwithjersey.model.State;

@Service
@Transactional
public class StateService {

  private @Autowired StateManager statemanager;

  public void createState(State state) {
    statemanager.createState(state);
  }

  public State getStateById(long id) {
    State state = statemanager.getStateById(id);
    return state;
  }

  public List<State> getState() {
    List<State> state = statemanager.getState();
    return state;
  }

  public List<State> getStateByCountry(long id) {
    Country country = new Country();
    country.setId(id);
    List<State> state_res = statemanager.getStateByCountry(country);
    return state_res;
  }

  public void saveAllState(List<State> countries) {
    statemanager.saveAllState(countries);
  }

  public void deleteState(long id) {
    statemanager.deleteState(id);
  }

}
