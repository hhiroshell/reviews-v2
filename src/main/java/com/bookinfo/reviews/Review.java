package com.bookinfo.reviews;

public class Review {
    private String reviewer;
    private String text;
    private Rating rating;

    public Review(String reviewer, String text, int stars) {
        this.reviewer = reviewer;
        this.text = text;
        this.rating = new Rating(stars);
    }

    public String getReviewer() {
        return this.reviewer;
    }

    public String getText() {
        return this.text;
    }

    public Rating getRating() {
        return this.rating;
    }

    public class Rating {
        private int stars;
        private static final String color = "red";

        public Rating(int stars) {
            this.stars = stars;
        }

        public int getStars() {
            return this.stars;
        }

        public String getColor() {
            return color;
        }
    }
}