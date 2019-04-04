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

import com.springwithjersey.model.Item;
import com.springwithjersey.service.ItemService;

@Path("api/item")
@Component
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class ItemEndPoint {

  private final Logger logger = LoggerFactory.getLogger(ItemEndPoint.class);

  private @Autowired ItemService itemService;

  @POST
  @Path("/post")
  public Response createitem(Item item) {
    itemService.createItem(item);
    return Response.ok("item created,s.").build();
  }

  @GET
  @Path("/get")
  public Response getItemById(@QueryParam("id") long id) {
    Item item = itemService.getItemById(id);
    return Response.ok(item).build();
  }

  @GET
  @Path("/getAll")
  public Response getItem() {
    List<Item> item = itemService.getItem();
    return Response.ok(item).build();
  }

  @PUT
  @Path("/update")
  public Response updateItem(Item item) {
    itemService.updateItem(item);
    return Response.ok("update..").build();
  }

  @PUT
  @Path("/saveAll")
  public Response saveAllItem(List<Item> items) {
    itemService.saveAllItem(items);
    return Response.ok("Countries Saved..").build();
  }

  @DELETE
  @Path("/delete")
  public Response deleteItem(@QueryParam("id") long id) {
    itemService.deleteItem(id);
    return Response.ok("item Deleted..").build();

  }
}
