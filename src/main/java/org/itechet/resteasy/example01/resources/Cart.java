package org.itechet.resteasy.example01.resources;

import org.itechet.resteasy.example01.services.CartService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by ryan on 24/11/15.
 */
@Path("/cart")
public class Cart {
    @Inject
    CartService cartService;

    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void addItem(@QueryParam("itemId") String itemId, @Suspended AsyncResponse response) {
        cartService.add(itemId);
        response.resume(Response.ok().build());
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteItem(@QueryParam("itemId") String itemId, @Suspended AsyncResponse response) {
        cartService.delete(itemId);
        response.resume(Response.noContent().build());
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void getItem(@Suspended AsyncResponse response) {
        response.resume(cartService.getContent());
    }
}
