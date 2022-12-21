package com.exercise.fruitshop.v1.products.entities;

import lombok.NonNull;

import javax.persistence.*;
//import org.springframework.data.annotation.Id;


@Entity
//@Data
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    private final String description ;
  /*  @NonNull
    private final  String product;*/

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;

    public Offer(@NonNull String description, @NonNull Product product) {
        this.description = description;
        this.product = product;
    }

    public Offer() {
        this.description = "";
        this.product = new Product();
    }

    public long getId() {
        return id;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    @NonNull
    public Product getProduct() {
        return product;
    }


}
