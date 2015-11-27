package org.itechet.resteasy.example01.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by ryan on 26/11/15.
 */
@Path("/health")
public class Health {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public void getHealth(@Suspended AsyncResponse response) {
        response.resume("Server healthy");
    }
}
