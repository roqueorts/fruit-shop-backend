package com.exercise.fruitshop.v1.products.controllers;


import com.exercise.fruitshop.v1.products.dtos.PurchaseDTO;
import com.exercise.fruitshop.v1.products.entities.Offer;
import com.exercise.fruitshop.v1.products.entities.Product;
import com.exercise.fruitshop.v1.products.repositories.OfferRepository;
import com.exercise.fruitshop.v1.products.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {


    private final ProductRepository productRepository;
    private final OfferRepository offerRepository;

    public ProductController(ProductRepository productRepository, OfferRepository offerRepository) {
        this.productRepository = productRepository;
        this.offerRepository = offerRepository;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @PostMapping("/products")
    void addProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    @PostMapping("/offers")
    void addOffer(@RequestBody Product product) {
        productRepository.save(product);
    }

    @PostMapping("/purchase")
    void purchase(@RequestBody List<PurchaseDTO> purchaseDTOs) {
        // productRepository.save(product);
        Double totalPrice = 0.0;
        System.out.println("PRODUCT OFFER_APPLIED");
        for(int i = 0; i < purchaseDTOs.size(); i++) {
            Double totalPriceProduct = 0.0;
            // find if product has offers
            List<Offer> offers = offerRepository.findAllByProduct(productRepository.findById(purchaseDTOs.get(i).getProduct().getId()).get());
            // Only applies for 1 offer(3x2). TODO: Set up more offers
            if(offers.size()>0) {
                for (int j = 0; j < offers.size(); j++) {

                    if (offers.get(j).getDescription() == "3 x 2")
                    {       // Apply offer 3x2
                        if (purchaseDTOs.get(i).getQuantity() >= 3) {
                            int totalProducts = (purchaseDTOs.get(i).getQuantity() / 3) * 2 + purchaseDTOs.get(i).getQuantity() % 3;
                            totalPriceProduct = totalProducts * Double.parseDouble(purchaseDTOs.get(i).getProduct().getPrice());
                            System.out.print(offers.get(j).getProduct().getName() + ", ");
                            System.out.println(offers.get(j).getDescription());
                        }
                        // No apply offer 3x2
                        else {
                            totalPriceProduct = purchaseDTOs.get(i).getQuantity() * Double.parseDouble(purchaseDTOs.get(i).getProduct().getPrice());
                            System.out.println(purchaseDTOs.get(i).getProduct().getName());
                        }
                    }
                }
            } else // No offer
            {
                totalPriceProduct = purchaseDTOs.get(i).getQuantity() * Double.parseDouble(purchaseDTOs.get(i).getProduct().getPrice());
                System.out.println(purchaseDTOs.get(i).getProduct().getName());

            }
            totalPrice += totalPriceProduct;
        }
        System.out.println("Total price: " + totalPrice);
    }


}
