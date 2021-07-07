package dev.janaite.uri2621;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.janaite.uri2621.dto.ProductMinDTO;
import dev.janaite.uri2621.projections.ProductMinProjection;
import dev.janaite.uri2621.repositories.ProductRepository;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Native Query");
		List<ProductMinProjection> list = repository.search1(10, 20, "P");
		List<ProductMinDTO> result1 = list.stream().map(x -> new ProductMinDTO(x)).collect(Collectors.toList());
		result1.forEach(System.out::println);
		
		System.out.println("JPQL Query");
		List<ProductMinDTO> result2 = repository.search2(10, 20, "P");
		result2.forEach(System.out::println);
	}
}
