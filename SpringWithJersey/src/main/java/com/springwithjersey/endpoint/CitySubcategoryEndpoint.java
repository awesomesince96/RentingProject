package com.springwithjersey.endpoint;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springwithjersey.model.City_Subcategory;
import com.springwithjersey.rest.data.CitySubcategoryRepository;

@Path("api/citysubcategory")
@Component
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class CitySubcategoryEndpoint {

  private final Logger logger = LoggerFactory.getLogger(CityEndPoint.class);

  private @Autowired CitySubcategoryRepository repo;

  @GET
  @Path("/getAll")
  public Response getCity() throws IllegalAccessException, InvocationTargetException {
    List<City_Subcategory> cs = repo.findAll();
    return Response.ok(cs).header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
  }


}
