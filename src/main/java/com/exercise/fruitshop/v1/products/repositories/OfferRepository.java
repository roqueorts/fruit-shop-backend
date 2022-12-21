package com.exercise.fruitshop.v1.products.repositories;

import com.exercise.fruitshop.v1.products.entities.Offer;
import com.exercise.fruitshop.v1.products.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends CrudRepository<Offer, Long> {


    List<Offer> findAll();

    List<Offer> findAllByProduct(Product product);
}

