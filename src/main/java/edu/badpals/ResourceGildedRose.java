package edu.badpals;

import edu.badpals.domain.Item;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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

    @GET
    @Path("item/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItem(@PathParam("id")Long id){
        Item item = service.cargarItem(id);
        return item.name.isEmpty()?
                Response.status(Response.Status.NOT_FOUND).build():
                Response.status(Response.Status.OK).entity(item).build();
    }

}
