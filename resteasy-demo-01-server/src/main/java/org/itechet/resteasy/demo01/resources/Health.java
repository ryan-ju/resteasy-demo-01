/*
 * Copyright (c) 2015.
 *
 * This software may be modified and distributed under the terms of the MIT license.
 * See the LICENSE file for details.
 */
package org.itechet.resteasy.demo01.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

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
