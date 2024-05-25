package edu.badpals;

import edu.badpals.domain.*;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/")
public class ResourceGildedRose {

    @Inject
    ServiceGildedRose service;
    @Inject
    EntityManager em;

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
    @GET
    @Path("items")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllItems(){
        List<Item> items = service.cargaAllItems();
        return items.isEmpty()?
                Response.status(Response.Status.NOT_FOUND).build():
                Response.status(Response.Status.OK).entity(items).build();
    }

    @PUT
    @Path("updateItems")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    //curl -X PUT "http://localhost:8080/updateItems" -v
    public Response updateItems(){
        service.updateDatabase();
        System.out.println("¡Todos los items se han actualizado con éxito!");
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("agedBrie/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAgedBrie(){
        List<AgedBrie> agedBries = service.cargaAllAgedBrie();
        return agedBries.isEmpty()?
                Response.status(Response.Status.NOT_FOUND).build():
                Response.status(Response.Status.OK).entity(agedBries).build();
    }

    @GET
    @Path("normalItem/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllNormalItem(){
        List<NormalItem> normalItems = service.cargaAllNormalItems();
        return normalItems.isEmpty()?
                Response.status(Response.Status.NOT_FOUND).build():
                Response.status(Response.Status.OK).entity(normalItems).build();
    }
    @GET
    @Path("backstagePass/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllbackstagePass(){
        List<BackstagePass> backstagePasses = service.cargaAllBackstagePass();
        return backstagePasses.isEmpty()?
                Response.status(Response.Status.NOT_FOUND).build():
                Response.status(Response.Status.OK).entity(backstagePasses).build();
    }
    @GET
    @Path("conjured/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllConjured(){
        List<Conjured> conjured = service.cargaAllConjured();
        return conjured.isEmpty()?
                Response.status(Response.Status.NOT_FOUND).build():
                Response.status(Response.Status.OK).entity(conjured).build();
    }
    @GET
    @Path("sulfuras/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSulfuras(){
        List<Sulfuras> sulfuras = service.cargaAllSulfuras();
        return sulfuras.isEmpty()?
                Response.status(Response.Status.NOT_FOUND).build():
                Response.status(Response.Status.OK).entity(sulfuras).build();
    }


}
