package com.bookinfo.reviews.domain;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/ratings")
@RegisterRestClient
public interface RatingsService {

    @GET
    @Path("/{productId}")
    Ratings getByProductId(@PathParam("productId") int productId);

    @POST
    @Path("/")
    void add(Ratings ratings);
}
