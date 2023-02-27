package com.cakeboss.service.product.controllers;

import com.cakeboss.service.product.exception.Status409ProductNotFound;
import com.cakeboss.service.product.exception.Status410ProductNotCreated;
import com.cakeboss.service.product.exception.Status411ProductNotDeleted;
import com.cakeboss.service.product.object.Product;
import com.cakeboss.service.product.services.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author stevemak
 */
@Path("/catalogue")
public class ProductsController {
    
    @Inject
    ProductService productService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{productId}")
    public Response getProduct(@PathParam("productId") Long id) throws Status409ProductNotFound{
        Product product = productService.findProduct(id);
        
        if(product == null) {
            throw new Status409ProductNotFound("Product was not found");
        }
        return Response
                .ok(product)
                .build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduct(Product product) throws Status410ProductNotCreated {
        boolean productCreated = productService.createUpdateProduct(product);
        if(!productCreated) {
            throw new Status410ProductNotCreated("Product not created or updated");
        }
        
        return Response.ok().build();
        
    }
    
    @DELETE
    @Path("/{productId}")
    public Response deleteProduct(Long productId) throws Status411ProductNotDeleted {
        boolean productDeleted = productService.deleteProduct(productId);
        if(!productDeleted) {
           throw new Status411ProductNotDeleted("Product not deleted"); 
        }
        
        return Response.ok().build(); 
    } 
    
}
