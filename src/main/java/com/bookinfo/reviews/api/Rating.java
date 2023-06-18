package com.bookinfo.reviews.api;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Rating {
    private static final String color = "red";

    private int stars;

    @JsonCreator
    public Rating(int stars) {
        this.stars = stars;
    }

    public String getColor() {
        return color;
    }

    public int getStars() {
        return this.stars;
    }
}
