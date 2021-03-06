package dev.janaite.uri2602;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.janaite.uri2602.dto.CustomerMinDTO;
import dev.janaite.uri2602.projections.CustomerMinProjection;
import dev.janaite.uri2602.repositories.CustomerRepository;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Native Query");
		List<CustomerMinProjection> list = repository.search1("Rs");
		List<CustomerMinDTO> result1 = list.stream().map(x -> new CustomerMinDTO(x)).collect(Collectors.toList());
		result1.forEach(obj -> System.out.println(obj));
		
		System.out.println("JPQL Query");
		List<CustomerMinDTO> result2 = repository.search2("Rs");
		result2.forEach(obj -> System.out.println(obj));

	}

}
