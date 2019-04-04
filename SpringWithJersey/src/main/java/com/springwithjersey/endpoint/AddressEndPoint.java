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

import com.springwithjersey.model.Address;
import com.springwithjersey.model.User;
import com.springwithjersey.service.AddressService;

@Path("/api/Address")
@Component
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class AddressEndPoint {

  private @Autowired AddressService addressService;

  @POST
  @Path("/post")
  public Response createAddress(Address address) {
    addressService.createAddress(address);
    return Response.ok("address created..").build();
  }

  @GET
  @Path("/get")
  public Response getAddressById(@QueryParam("id") long id) {
    Address address = addressService.getAddressById(id);
    return Response.ok(address).build();
  }

  @GET
  @Path("/getAll")
  public Response getAddress() {
    List<Address> address = addressService.getAddress();
    return Response.ok(address).build();
  }

  @GET
  @Path("/getByUser")
  public Response getAddressByUser(@QueryParam("id") long id) {
    List<User> user = addressService.getAddressByUser(id);
    return Response.ok(user).build();
  }

  @GET
  @Path("/getByCity")
  public Response getAddressByCity(@QueryParam("id") long id) {
    List<Address> address = addressService.getAddressByCity(id);
    return Response.ok(address).build();
  }

  @PUT
  @Path("/update")
  public Response updateAddress(Address address) {
    addressService.createAddress(address);
    return Response.ok("address updated..").build();
  }

  @PUT
  @Path("/saveAll")
  public Response saveAllAddress(List<Address> addresss) {
    addressService.saveAllAddress(addresss);
    return Response.ok("Countries Saved..").build();
  }

  @DELETE
  @Path("/delete")
  public Response deleteAddress(@QueryParam("id") long id) {
    addressService.deleteAddress(id);
    return Response.ok("address Deleted..").build();
  }

}
