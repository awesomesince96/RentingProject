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

import com.springwithjersey.model.Country;
import com.springwithjersey.service.CountryService;

@Path("api/country")
@Component
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class CountryEndPoint {

  private final Logger logger = LoggerFactory.getLogger(CountryEndPoint.class);

  private @Autowired CountryService countryservice;

  @POST
  @Path("/post")
  public Response createCountry(Country country) {
    countryservice.createCountry(country);
    return Response.ok("Country created,s.").build();
  }

  @GET
  @Path("/get")
  public Response getCountryById(@QueryParam("id") long id) {
    logger.info("this is logger");
    Country country = countryservice.getCountryById(id);
    return Response.ok(country).build();
  }

  @GET
  @Path("/getAll")
  public Response getCountry() {
    List<Country> country = countryservice.getCountry();
    return Response.ok(country).build();
  }

  @PUT
  @Path("/update")
  public Response updateCountry(Country country) {
    countryservice.createCountry(country);
    return Response.ok("Country updated..").build();
  }

  @PUT
  @Path("/saveAll")
  public Response saveAllCountry(List<Country> countries) {
    System.out.println(countries.toString());
    countryservice.saveAllCountry(countries);
    return Response.ok("Countries Saved..").build();
  }

  @DELETE
  @Path("/delete")
  public Response deleteCountry(@QueryParam("id") long id) {
    countryservice.deleteCountry(id);
    return Response.ok("Country Deleted..").build();

  }

}
