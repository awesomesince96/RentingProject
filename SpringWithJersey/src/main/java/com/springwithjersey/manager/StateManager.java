package com.springwithjersey.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springwithjersey.common.util.Status;
import com.springwithjersey.model.Country;
import com.springwithjersey.model.State;
import com.springwithjersey.rest.data.StateRepository;

@Service
public class StateManager {

  private @Autowired StateRepository stateRepository;

  public void createState(State state) {
    stateRepository.save(state);
  }

  public State getStateById(long id) {
    return stateRepository.findById(id);
  }

  public List<State> getState() {
    return stateRepository.findAllByStatus(Status.ACTIVE);
  }

  public List<State> getStateByCountry(Country country) {
    return stateRepository.findAllByCountry(country);
  }

  public void saveAllState(List<State> states) {
    stateRepository.save(states);
  }

  public void deleteState(long id) {
    long result = stateRepository.deleteById(id);
    System.out.println("----" + result);
  }
}
