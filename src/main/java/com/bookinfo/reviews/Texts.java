package com.bookinfo.reviews;

import java.util.List;

public class Texts {
    private int productId;
    private List<Text> texts;

    public Texts(int productId, List<Text> texts) {
        this.productId = productId;
        this.texts = texts;
    }

    public int getProductId() {
        return productId;
    }

    public List<Text> getTexts() {
        return texts;
    }
}
