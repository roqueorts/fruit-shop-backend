package com.exercise.fruitshop.v1.products.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
//import org.springframework.data.annotation.Id;


@Entity
//@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    private final String name ;
    @NonNull
    private final  String price; // BigDecimal

    @OneToMany(mappedBy="product")
    private Set<Offer> offers;

    public Product(@NonNull String name,@NonNull String price) {
        this.name = name;
        this.price = price;
    }

    public Product() {
        this.name = "name";
        this.price = "0.0";
    }

    public long getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getPrice() {
        return price;
    }


}
