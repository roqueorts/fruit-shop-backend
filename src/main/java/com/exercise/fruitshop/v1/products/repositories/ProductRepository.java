package com.exercise.fruitshop.v1.products.repositories;

import com.exercise.fruitshop.v1.products.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {}

