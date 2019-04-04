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
import org.springframework.web.bind.annotation.CrossOrigin;

import com.springwithjersey.model.SubCategory;
import com.springwithjersey.service.SubCategoryService;

@Path("/api/SubCategory")
@Component
@CrossOrigin(origins = {"http://localhost:4200"})
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class SubCategoryEndPoint {

  private final Logger logger = LoggerFactory.getLogger(SubCategoryEndPoint.class);

  private @Autowired SubCategoryService subcategoryservice;

  @POST
  @Path("/save")
  public Response createSubcategory(SubCategory subcategory) {
    subcategoryservice.createSubcategory(subcategory);
    return Response.ok().build();
  }

  @PUT
  @Path("/update")
  public Response updateSubcategory(SubCategory subcategory) {
    subcategoryservice.createSubcategory(subcategory);
    return Response.ok().build();
  }

  @GET
  @Path("/saveByCity")
  public Response saveSubcategoryByCity(@QueryParam("cid") long cid, @QueryParam("sid") long sid) {
    subcategoryservice.saveSubcategoryByCity(cid, sid);
    return Response.ok().build();
  }

  @GET
  @Path("/")
  public Response getSubcategory() {
    List<SubCategory> subcategory = subcategoryservice.getSubcategory();
    return Response.ok(subcategory).build();
  }

  @GET
  @Path("/getByCity")
  public Response getSubcategoryByCity(@QueryParam("id") long id) {
    List<SubCategory> subcategory = subcategoryservice.getSubcategoryByCity(id);
    return Response.ok(subcategory).build();
  }


  @DELETE
  @Path("/delete")
  public Response deleteSubcategory(@QueryParam("cid") long cid, @QueryParam("sid") long sid) {
    subcategoryservice.deleteSubcategory(cid, sid);
    return Response.ok().build();
  }

  @GET
  @Path("/get")
  public Response getSubcategoryById(@QueryParam("id") long id) {
    SubCategory subcategory = subcategoryservice.getSubcategoryById(id);
    return Response.ok(subcategory).build();
  }

  @PUT
  @Path("/saveAll")
  public Response saveAllSubcategory(List<SubCategory> subcategory) {
    subcategoryservice.saveAllSubcategory(subcategory);
    return Response.ok("Countries Saved..").build();
  }

  @GET
  @Path("/getByCategory")
  public Response getSubcategoryByCategory(@QueryParam("id") long id) {
    List<SubCategory> subcategory = subcategoryservice.getSubcategoryByCategory(id);
    return Response.ok(subcategory).build();
  }

  // @GET
  // @Path("/getByCity")
  // public Response getSubcategoryByCity(@QueryParam("id") long id) {
  // List<SubCategory> subcategory = subcategoryservice.getSubcategoryByCity(id);
  // return Response.ok(subcategory).build();
  // }

  //
  // @DELETE
  // @Path("/delete")
  // public Response deleteSubcategoryCity(@QueryParam("sid") long sid, @QueryParam("cid") long cid) {
  // subcategoryservice.deleteSubcategoryCity(sid, cid);
  // return Response.ok("Mapping Removed..").build();
  // }

}
