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

import com.springwithjersey.model.Category;
import com.springwithjersey.service.CategoryService;

// @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
// @CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 4800, allowCredentials = "false", allowedHeaders = "*")
@Path("/api/Category")
@Component
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

public class CategoryEndPoint {

  // private final Logger logger = LoggerFactory.getLogger(CategoryEndPoint.class);

  private @Autowired CategoryService categoryservice;

  @POST
  @Path("/")
  public Response createCategory(Category category) {
    categoryservice.createCategory(category);
    // return Response.ok("Category created..").build();
    return Response.ok().header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
  }

  @GET
  @Path("/get")
  public Response getCategoryById(@QueryParam("id") long id) {
    Category category = categoryservice.getCategoryById(id);
    return Response.ok(category).build();
  }

  @GET
  @Path("/")
  public Response getCategory() {
    List<Category> category = categoryservice.getCategory();
    return Response.ok(category).header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
  }

  @PUT
  @Path("/")
  public Response updateCategory(Category category) {
    categoryservice.createCategory(category);
    return Response.ok().build();
  }

  @PUT
  @Path("/saveAll")
  public Response saveAllCategory(List<Category> categorys) {
    categoryservice.saveAllCategory(categorys);
    return Response.ok("Countries Saved..").build();
  }

  @DELETE
  @Path("/delete")
  public Response deleteCategory(@QueryParam("id") long id) {
    categoryservice.deleteCategory(id);
    return Response.ok("Category Deleted..").build();
  }

}
