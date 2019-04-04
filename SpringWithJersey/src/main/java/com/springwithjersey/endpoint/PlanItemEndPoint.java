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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springwithjersey.model.PlanItem;
import com.springwithjersey.service.PlanItemService;

@Path("/api/planitem")
@Component
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class PlanItemEndPoint {

  private @Autowired PlanItemService planItemService;

  @POST
  @Path("/post")
  public Response createplanitem(PlanItem planitem) {
    planItemService.createPlanItem(planitem);
    return Response.ok("planitem created..").build();
  }

  @GET
  @Path("/get")
  public Response getplanitemById(@QueryParam("id") long id) {
    PlanItem planitem = planItemService.getPlanItemById(id);
    return Response.ok(planitem).build();
  }

  @GET
  @Path("/getAll")
  public Response getplanitem() {
    List<PlanItem> planitem = planItemService.getPlanItem();
    return Response.ok(planitem).build();
  }

  @GET
  @Path("/getByItem")
  public Response getplanitemByItem(@QueryParam("id") long id) {
    List<PlanItem> planitem = planItemService.getPlanItemByItem(id);
    return Response.ok(planitem).build();
  }

  @PUT
  @Path("/update")
  public Response updateplanitem(PlanItem planitem) {
    planItemService.createPlanItem(planitem);
    return Response.ok("planitem updated..").build();
  }

  @PUT
  @Path("/saveAll")
  public Response saveAllplanitem(List<PlanItem> planitems) {
    planItemService.saveAllPlanItem(planitems);
    return Response.ok("Countries Saved..").build();
  }

  @DELETE
  @Path("/delete")
  public Response deleteplanitem(@QueryParam("id") long id) {
    planItemService.deletePlanItem(id);
    return Response.ok("planitem Deleted..").build();
  }


}
