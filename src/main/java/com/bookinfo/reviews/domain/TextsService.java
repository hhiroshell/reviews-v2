package com.bookinfo.reviews.domain;

public interface TextsService {

    public Texts getByProductId(int productId);

    public void add(Texts texts);
}