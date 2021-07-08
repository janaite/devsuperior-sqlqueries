package dev.janaite.uri2609;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.janaite.uri2609.dto.CategorySumDTO;
import dev.janaite.uri2609.projections.CategorySumProjection;
import dev.janaite.uri2609.repositories.CategoryRepository;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Native query");
		List<CategorySumProjection> list = repository.search1();
		List<CategorySumDTO> result1 = list.stream().map(obj -> new CategorySumDTO(obj)).collect(Collectors.toList());
		result1.forEach(System.out::println);
		
		System.out.println("JPQL query");
		List<CategorySumDTO> result2 = repository.search2();
		result2.forEach(System.out::println);

	}
}
