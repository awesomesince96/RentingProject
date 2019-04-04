package com.springwithjersey.endpoint;

import java.lang.reflect.InvocationTargetException;
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

import com.springwithjersey.model.City;
import com.springwithjersey.requestdto.CityDto;
import com.springwithjersey.service.CityService;

@Path("api/city")
@Component
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class CityEndPoint {

  private final Logger logger = LoggerFactory.getLogger(CityEndPoint.class);

  private @Autowired CityService cityservice;

  @POST
  @Path("/save")
  public Response createCity(City city) {
    cityservice.createCity(city);
    return Response.ok().header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
  }

  @GET
  @Path("/get")
  public Response getCityById(@QueryParam("id") long id) throws IllegalAccessException, InvocationTargetException {
    // CityDto citydto = cityservice.getCityById(id);
    City citydto = cityservice.getCityById(id);
    return Response.ok(citydto).build();
  }

  @GET
  @Path("/getAll")
  public Response getCity() throws IllegalAccessException, InvocationTargetException {
    List<City> city = cityservice.getCity();
    return Response.ok(city).header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
  }

  @GET
  @Path("/getByState")
  public Response getCityByCountry(@QueryParam("id") long id) {
    List<CityDto> city = cityservice.getCityByState(id);
    return Response.ok(city).build();
  }

  @PUT
  @Path("/update")
  public Response updateCity(City city) {
    cityservice.createCity(city);
    return Response.ok().header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
  }

  @PUT
  @Path("/saveAll")
  public Response saveAllCity(List<City> citys) {
    cityservice.saveAllCity(citys);
    return Response.ok("Countries Saved..").build();
  }

  @DELETE
  @Path("/delete")
  public Response deleteCity(@QueryParam("id") long id) {
    cityservice.deleteCity(id);
    return Response.ok("City Deleted..").build();
  }

}
