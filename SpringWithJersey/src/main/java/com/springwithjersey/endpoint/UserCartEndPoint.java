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

import com.springwithjersey.model.User;
import com.springwithjersey.model.UserCart;
import com.springwithjersey.service.UserCartService;

@Path("/api/UserCart")
@Component
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class UserCartEndPoint {

  private @Autowired UserCartService userCartService;

  @POST
  @Path("/post")
  public Response createUserCart(UserCart userCart) {
    userCartService.createUserCart(userCart);
    return Response.ok("userCart created..").build();
  }

  @GET
  @Path("/get")
  public Response getUserCartById(@QueryParam("id") long id) {
    UserCart userCart = userCartService.getUserCartById(id);
    return Response.ok(userCart).build();
  }

  @GET
  @Path("/getAll")
  public Response getUserCart() {
    List<UserCart> userCart = userCartService.getUserCart();
    return Response.ok(userCart).build();
  }

  @GET
  @Path("/getByUser")
  public Response getUserCartByUser(@QueryParam("id") long id) {
    List<User> user = userCartService.getUserCartByUser(id);
    return Response.ok(user).build();
  }

  @PUT
  @Path("/update")
  public Response updateUserCart(UserCart userCart) {
    userCartService.createUserCart(userCart);
    return Response.ok("userCart updated..").build();
  }

  @PUT
  @Path("/saveAll")
  public Response saveAllUserCart(List<UserCart> userCarts) {
    userCartService.saveAllUserCart(userCarts);
    return Response.ok("Countries Saved..").build();
  }

  @DELETE
  @Path("/delete")
  public Response deleteUserCart(@QueryParam("id") long id) {
    userCartService.deleteUserCart(id);
    return Response.ok("userCart Deleted..").build();
  }

}
