package com.springwithjersey.endpoint;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springwithjersey.model.State;
import com.springwithjersey.service.StateService;

@Path("api/state")
@Component
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class StateEndPoint {

  private final Logger logger = LoggerFactory.getLogger(StateEndPoint.class);

  private @Autowired StateService stateservice;

  @POST
  @Path("/post")
  public Response createState(State state) {
    stateservice.createState(state);
    return Response.ok("State created..").build();
  }

  @GET
  @Path("/get")
  public Response getStateById(@QueryParam("id") long id) {
    State state = stateservice.getStateById(id);
    return Response.ok(state).build();
  }

  @GET
  @Path("/getAll")
  public Response getState() {
    List<State> state = stateservice.getState();
    return Response.ok(state).build();
  }

  @GET
  @Path("/getByCountry")
  public Response getStateByCountry(@QueryParam("id") long id) {
    List<State> state = stateservice.getStateByCountry(id);
    return Response.ok(state).build();
  }

  @PUT
  @Path("/update")
  public Response updateState(State state) {
    stateservice.createState(state);
    return Response.ok("State updated..").build();
  }

  @PUT
  @Path("/saveAll")
  public Response saveAllState(List<State> states) {
    stateservice.saveAllState(states);
    return Response.ok("Countries Saved..").build();
  }

  @DELETE
  @Path("/delete")
  public Response deleteState(@QueryParam("id") long id) {
    stateservice.deleteState(id);
    return Response.ok("State Deleted..").build();
  }

}
