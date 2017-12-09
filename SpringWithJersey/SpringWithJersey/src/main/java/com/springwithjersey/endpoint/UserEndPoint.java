package com.springwithjersey.endpoint;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springwithjersey.requestdto.UpdateUserInformationDto;
import com.springwithjersey.requestdto.UserInformationDto;
import com.springwithjersey.requestdto.UserRegistrationDto;
import com.springwithjersey.service.UserService;

@Path("/api/user")
@Component
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class UserEndPoint {
  private @Autowired UserService userService;

  @GET
  @PermitAll
  public Response getLoggedinUserDetails(@Context HttpServletRequest request,
      @Context SecurityContext securityContext) {
    UserInformationDto userInfo = userService.getUserProfile(securityContext.getUserPrincipal().getName());

    return Response.ok(userInfo).build();
  }

  @POST
  @Path("/register")
  public Response register(@NotNull @Valid UserRegistrationDto userRegistration) {
    UserRegistrationDto userRegistrationinformation = userService.register(userRegistration);

    return Response.status(Response.Status.CREATED).entity(userRegistrationinformation).build();
  }

  @PUT
  @Path("/{userId}/update")
  public Response updateUser(@NotNull @Valid UpdateUserInformationDto updateUserInfo,
      @PathParam("userId") @NotNull Long userId) {
    UpdateUserInformationDto updateUserInformation = userService.updateUser(updateUserInfo, userId);

    return Response.ok(updateUserInformation).build();
  }

}

