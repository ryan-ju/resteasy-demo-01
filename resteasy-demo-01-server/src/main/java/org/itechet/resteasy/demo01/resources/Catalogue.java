/*
 * Copyright (c) 2015.
 *
 * This software may be modified and distributed under the terms of the MIT license.
 * See the LICENSE file for details.
 */
package org.itechet.resteasy.demo01.resources;

import org.itechet.resteasy.demo01.services.CatalogueService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

/**
 * Created by ryan on 24/11/15.
 */
@Path("/catalogue")
public class Catalogue {
    @Inject
    CatalogueService catalogueService;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void getCatalogue(@Suspended AsyncResponse response) {
        response.resume(catalogueService.getItemList());
    }
}
