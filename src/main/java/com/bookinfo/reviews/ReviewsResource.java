package com.bookinfo.reviews;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/reviews")
public class ReviewsResource {

    @RestClient
    RatingsService ratingsService;

    @Inject
    TextsService textsService;

    @GET
    @Path("/{productId}")
    public Reviews id(int productId) {
        Texts texts = textsService.getByProductId(productId);
        Ratings ratings = ratingsService.getByProductId(productId);

        List<Review> reviewList = new ArrayList<>(texts.getTexts().size());
        for (Text text : texts.getTexts()) {
            String reviewer = text.getReviewer();
            for (Rating rating: ratings.getRatings()) {
                if (rating.getReviewer().equals(reviewer)) {
                    reviewList.add(productId, new Review(reviewer, text.getText(), rating.getStars()));
                }
            }
        }
        
        Reviews reviews = new Reviews(productId, reviewList);
        return reviews;
    }
}
