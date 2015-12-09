/*
 * Copyright (c) 2015.
 *
 * This software may be modified and distributed under the terms of the MIT license.
 * See the LICENSE file for details.
 */
package org.itechet.resteasy.demo01.resources;

import org.itechet.resteasy.demo01.services.CartService;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
