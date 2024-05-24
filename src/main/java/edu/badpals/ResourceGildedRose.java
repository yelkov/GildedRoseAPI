package edu.badpals;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class ResourceGildedRose {

    @Inject
    ServiceGildedRose service;

    @GET
    @Path("bienvenida")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "¡Bienvenido a nuestra tienda!";
    }
}
