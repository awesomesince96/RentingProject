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

import com.springwithjersey.model.InterestedUser;
import com.springwithjersey.model.User;
import com.springwithjersey.service.InterestedUserService;

@Path("/api/InterestedUser")
@Component
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class InterestedUserEndPoint {

  private @Autowired InterestedUserService interesteduserService;

  @POST
  @Path("/post")
  public Response createInterestedUser(InterestedUser interesteduser) {
    interesteduserService.createInterestedUser(interesteduser);
    return Response.ok("interesteduser created..").build();
  }

  @GET
  @Path("/get")
  public Response getInterestedUserById(@QueryParam("id") long id) {
    InterestedUser interesteduser = interesteduserService.getInterestedUserById(id);
    return Response.ok(interesteduser).build();
  }

  @GET
  @Path("/getAll")
  public Response getInterestedUser() {
    List<InterestedUser> interesteduser = interesteduserService.getInterestedUser();
    return Response.ok(interesteduser).build();
  }

  @GET
  @Path("/getByUser")
  public Response getInterestedUserByUser(@QueryParam("id") long id) {
    List<User> user = interesteduserService.getInterestedUserByUser(id);
    return Response.ok(user).build();
  }

  @GET
  @Path("/getByItem")
  public Response getInterestedUserByItem(@QueryParam("id") long id) {
    List<InterestedUser> interesteduser = interesteduserService.getInterestedUserByItem(id);
    return Response.ok(interesteduser).build();
  }

  @PUT
  @Path("/update")
  public Response updateInterestedUser(InterestedUser interesteduser) {
    interesteduserService.createInterestedUser(interesteduser);
    return Response.ok("interesteduser updated..").build();
  }

  @PUT
  @Path("/saveAll")
  public Response saveAllInterestedUser(List<InterestedUser> interestedusers) {
    interesteduserService.saveAllInterestedUser(interestedusers);
    return Response.ok("Countries Saved..").build();
  }

  @DELETE
  @Path("/delete")
  public Response deleteInterestedUser(@QueryParam("id") long id) {
    interesteduserService.deleteInterestedUser(id);
    return Response.ok("interesteduser Deleted..").build();
  }
}
