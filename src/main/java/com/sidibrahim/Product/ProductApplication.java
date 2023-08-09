package com.sidibrahim.Product;

import com.sidibrahim.Product.entities.Product;
import com.sidibrahim.Product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductApplication implements CommandLineRunner {
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {

		SpringApplication.run(ProductApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product(null,"computer",3499,13));
		productRepository.save(new Product(null,"smart phone",5000,70));
		productRepository.save(new Product(null,"Printer",90009,30));

		System.out.println("**************");
		List<Product> products = productRepository.findAll();
		products.forEach(System.out::println);
		Product product=productRepository.findById(Long.valueOf(1)).get();
		System.out.println("___________________");
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getQuantity());
		System.out.println(product.getPrice());
		System.out.println("___________________");
		List<Product> productlist = productRepository.findByNameContains("c");
		productlist.forEach(System.out::println);
		System.out.println("11111111111111111111111");
		List<Product> productlist2 = productRepository.search("%c%");
		productlist2.forEach(System.out::println);
		System.out.println("00000000000000000000");
		List<Product> products3= productRepository.findByPriceGreaterThan(5000);
		products3.forEach(System.out::println);

	}
}
