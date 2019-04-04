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

import com.springwithjersey.model.User;
import com.springwithjersey.service.UserService;

@Path("api/user")
@Component
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class UserEndPoint {

  private final Logger logger = LoggerFactory.getLogger(UserEndPoint.class);

  private @Autowired UserService userservice;

  @POST
  @Path("/save")
  public Response createuser(User user) {
    userservice.createUser(user);
    return Response.ok().build();
  }

  @GET
  @Path("/get")
  public Response getuserById(@QueryParam("id") long id) {
    User user = userservice.getUserById(id);
    return Response.ok(user).build();
  }

  @GET
  @Path("/")
  public Response getuser() {
    List<User> user = userservice.getUser();
    return Response.ok(user).build();
  }

  @PUT
  @Path("/update")
  public Response updateuser(User user) {
    userservice.createUser(user);
    return Response.ok().build();
  }

  @PUT
  @Path("/saveAll")
  public Response saveAlluser(List<User> users) {
    userservice.saveAllUser(users);
    return Response.ok("Countries Saved..").build();
  }

  @DELETE
  @Path("/delete")
  public Response deleteuser(@QueryParam("id") long id) {
    userservice.deleteUser(id);
    return Response.ok("user Deleted..").build();

  }

}
