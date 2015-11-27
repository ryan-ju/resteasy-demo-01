package org.itechet.resteasy.example01.resources;

import org.itechet.resteasy.example01.services.CatalogueService;

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
