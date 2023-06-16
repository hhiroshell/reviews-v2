package com.bookinfo.reviews.repository;

import com.bookinfo.reviews.TextsService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

import com.bookinfo.reviews.Text;
import com.bookinfo.reviews.Texts;

@ApplicationScoped
public class TextsServiceImpl implements TextsService {

    @Inject
    EntityManager em;
    
    public Texts getByProductId(int productId) {
        List<TextEntity> entities = em.createQuery("select r from TextEntity r where r.productId = :productId", TextEntity.class)
            .setParameter("productId", productId)
            .getResultList();

        List<Text> textList = new ArrayList<>(entities.size());
        int i = 0;
        for (TextEntity entity : entities) {
            textList.add(i, new Text(productId, entity.getReviewer(), entity.getText()));
            i++;
        }

        Texts texts = new Texts(productId, textList);
        return texts;
    }
}
