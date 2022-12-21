package com.exercise.fruitshop.v1.products.dtos;

import com.exercise.fruitshop.v1.products.entities.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseDTO {

    Product product;
    int quantity;
}
