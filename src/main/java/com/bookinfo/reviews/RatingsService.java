package com.bookinfo.reviews;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/ratings")
@RegisterRestClient
public interface RatingsService {

    @GET
    @Path("/{productId}")
    Ratings getByProductId(@PathParam("productId") int productId);
}
