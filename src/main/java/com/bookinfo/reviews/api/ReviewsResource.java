package com.bookinfo.reviews.api;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.bookinfo.reviews.domain.Rating;
import com.bookinfo.reviews.domain.Ratings;
import com.bookinfo.reviews.domain.RatingsService;
import com.bookinfo.reviews.domain.Text;
import com.bookinfo.reviews.domain.Texts;
import com.bookinfo.reviews.domain.TextsService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

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
                    reviewList.add(new Review(reviewer, text.getText(), rating.getStars()));
                }
            }
        }
        
        Reviews reviews = new Reviews(productId, reviewList);
        return reviews;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Reviews post(Reviews reviews) {
        List<Review> reviewList = reviews.getReviews();
        List<Text> textList = new ArrayList<>(reviewList.size());
        List<Rating> ratingList = new ArrayList<>(reviewList.size());

        for (Review review : reviewList) {
            Text text = new Text(review.getReviewer(), review.getText());
            textList.add(text);

            Rating rating = new Rating(review.getReviewer(), review.getRating().getStars());
            ratingList.add(rating);
        }

        int productId = reviews.getId();
        textsService.add(new Texts(productId , textList));
        ratingsService.add(new Ratings(productId, ratingList));

        return reviews;
    }
}
