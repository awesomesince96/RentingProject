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

import com.springwithjersey.model.PlanMaster;
import com.springwithjersey.service.PlanMasterService;

@Path("api/planmaster")
@Component
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class PlanMasterEndPoint {

  private final Logger logger = LoggerFactory.getLogger(PlanMasterEndPoint.class);

  private @Autowired PlanMasterService planMasterService;

  @POST
  @Path("/save")
  public Response createplanmaster(PlanMaster planmaster) {
    planMasterService.createPlanMaster(planmaster);
    return Response.ok().build();
  }

  @GET
  @Path("/get")
  public Response getPlanMasterById(@QueryParam("id") long id) {
    PlanMaster planmaster = planMasterService.getPlanMasterById(id);
    return Response.ok(planmaster).build();
  }

  @GET
  @Path("/")
  public Response getPlanMaster() {
    List<PlanMaster> planmaster = planMasterService.getPlanMaster();
    return Response.ok(planmaster).build();
  }

  @PUT
  @Path("/update")
  public Response updatePlanMaster(PlanMaster planmaster) {
    planMasterService.createPlanMaster(planmaster);
    return Response.ok().build();
  }

  @PUT
  @Path("/saveAll")
  public Response saveAllPlanMaster(List<PlanMaster> planmasters) {
    planMasterService.saveAllPlanMaster(planmasters);
    return Response.ok("Countries Saved..").build();
  }

  @DELETE
  @Path("/delete")
  public Response deletePlanMaster(@QueryParam("id") long id) {
    planMasterService.deletePlanMaster(id);
    return Response.ok("planmaster Deleted..").build();

  }

}
