package com.bookinfo.reviews.domain;

import java.util.List;

public class Ratings {
    private int productId;
    List<Rating> ratings;

    public Ratings(int productId, List<Rating> ratings) {
        this.productId = productId;
        this.ratings = ratings;
    }

    public int getProductId() {
        return productId;
    }

    public List<Rating> getRatings() {
        return ratings;
    }
}
