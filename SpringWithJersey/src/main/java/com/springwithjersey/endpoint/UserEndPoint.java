package com.springwithjersey.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springwithjersey.service.ItemService;

@Path("/api/user")
@Component
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class UserEndPoint {

  private final Logger logger = LoggerFactory.getLogger(UserEndPoint.class);

  @Autowired
  private ItemService itemservice;

  // private @Autowired UserService userService;

  // @GET
  // @PermitAll
  // public Response getLoggedinUserDetails(@Context HttpServletRequest request,
  // @Context SecurityContext securityContext) {
  // // UserInformationDto userInfo = userService.getUserProfile(securityContext.getUserPrincipal().getName());
  //
  // // return Response.ok(userInfo).build();
  // }

  @POST
  @Path("/login")
  public Response login() {

    // CountryHelper countryHel
    logger.debug("This is the right path");
    System.out.println("This is the right path");
    return Response.ok("Krish").build();
  }

  @GET
  @Path("/city")
  public Response getProduct() {

    return Response.ok("Products").build();
  }

  @GET
  @Path("/city")

  public Response loadCity(String city) {
    itemservice.getItemsByCity(city);
    // return Response.status(Response.Status.OK).entity(List<Item>).build();
    return null;
  }


  //
  // @POST
  // @Path("/register")
  // public Response register(@NotNull @Valid UserRegistrationDto userRegistration) {
  // UserRegistrationDto userRegistrationinformation = userService.register(userRegistration);
  //
  // return Response.status(Response.Status.OK).entity(userRegistrationinformation).build();
  // }
  //
  // @PUT
  // @Path("/{userId}/update")
  // public Response updateUser(@NotNull @Valid UpdateUserInformationDto updateUserInfo,
  // @PathParam("userId") @NotNull Long userId) {
  // UpdateUserInformationDto updateUserInformation = userService.updateUser(updateUserInfo, userId);
  //
  // return Response.ok(updateUserInformation).build();
  // }

}

