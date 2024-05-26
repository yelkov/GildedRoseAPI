package edu.badpals;

import edu.badpals.domain.*;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    @POST
    @Path("crearItem")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    //curl -d "{\"name\": \"Snitch Dorada\", \"sellIn\":10,\"quality\":35}" -H "Content-Type: application/json" -X POST http://localhost:8080/crearItem -v
    public Response postItem(Item item){
        Item itemCreado = service.crearItem(item.name,item.sellIn,item.quality);
        return itemCreado!= null?
                Response.status(201).entity(itemCreado).build():
                Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("deleteItem/{id}")
    @Transactional
    public Response deleteItem(@PathParam("id")Long id){
        return service.borrarItem(id)?
                Response.status(204).build():
                Response.status(404).build();
    }

    /*@POST
    @Path("crearItem/normalItem")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    //curl -d "{\"name\": \"Snitch Dorada\", \"sellIn\":10,\"quality\":35}" -H "Content-Type: application/json" -X POST http://localhost:8080/crearItem/normalItem -v
    public <T> Response postItem(Item item){
        NormalItem normalItem = service.crearNormalItem(item.name, item.sellIn, item.quality);
        return normalItem!= null?
                Response.status(201).entity(normalItem).build():
                Response.status(Response.Status.BAD_REQUEST).build();
    }*/

}
