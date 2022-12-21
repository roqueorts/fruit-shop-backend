package com.exercise.fruitshop;

import com.exercise.fruitshop.v1.products.entities.Offer;
import com.exercise.fruitshop.v1.products.entities.Product;
import com.exercise.fruitshop.v1.products.repositories.OfferRepository;
import com.exercise.fruitshop.v1.products.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@SpringBootApplication
public class FruitshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(FruitshopApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ProductRepository productRepository, OfferRepository offerRepository) {
		return args -> {
			Stream.of("Apple", "Pear", "Orange").forEach(name -> {
				Product product = new Product(name, "3.50");
				productRepository.save(product);
			});
			Offer offer = new Offer("3 x 2", productRepository.findById(1L).get());

			offerRepository.save(offer);
			List<Offer> offers = offerRepository.findAllByProduct(productRepository.findById(1L).get());
			System.out.println("PRODUCT OFFER");
			for(int i = 0; i < offers.size(); i++) {
				System.out.print(offers.get(i).getProduct().getName() + ", ");
				System.out.println(offers.get(i).getDescription());
			}
		};
	}
}
