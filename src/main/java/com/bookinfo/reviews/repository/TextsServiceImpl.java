package com.bookinfo.reviews.repository;

import com.bookinfo.reviews.domain.Text;
import com.bookinfo.reviews.domain.Texts;
import com.bookinfo.reviews.domain.TextsService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@ApplicationScoped
public class TextsServiceImpl implements TextsService {

    @PersistenceContext
    EntityManager em;
    
    @Override
    public Texts getByProductId(int productId) {
        List<TextEntity> entities = em.createQuery("select r from TextEntity r where r.productId = :productId", TextEntity.class)
            .setParameter("productId", productId)
            .getResultList();

        List<Text> textList = new ArrayList<>(entities.size());
        for (TextEntity entity : entities) {
            textList.add(new Text(entity.getReviewer(), entity.getText()));
        }

        Texts texts = new Texts(productId, textList);
        return texts;
    }

    @Override
    public void add(Texts texts) {
        for (Text text : texts.getTexts()) {
            TextEntity entity = new TextEntity();
            entity.setProductId(texts.getProductId());
            entity.setReviewer(text.getReviewer());
            entity.setText(text.getText());
            em.persist(entity);
        }
    }
}
