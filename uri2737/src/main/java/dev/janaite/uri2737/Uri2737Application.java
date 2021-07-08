package dev.janaite.uri2737;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.janaite.uri2737.dto.LawyerMinDTO;
import dev.janaite.uri2737.projections.LawyerMinProjection;
import dev.janaite.uri2737.repositories.LawyerRepository;

@SpringBootApplication
public class Uri2737Application implements CommandLineRunner {

	@Autowired
	private LawyerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2737Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Native query");
		List<LawyerMinProjection> list = repository.search1();
		List<LawyerMinDTO> result1 = list.stream().map(obj -> new LawyerMinDTO(obj)).collect(Collectors.toList());
		result1.forEach(System.out::println);

	}
}
