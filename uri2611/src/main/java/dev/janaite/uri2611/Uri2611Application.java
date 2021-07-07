package dev.janaite.uri2611;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.janaite.uri2611.dto.MovieMinDTO;
import dev.janaite.uri2611.projections.MovieMinProjection;
import dev.janaite.uri2611.repositories.MovieRepository;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {
	
	@Autowired
	private MovieRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Native Query");
		List<MovieMinProjection> list = repository.search1("Action");
		List<MovieMinDTO> result1 = list.stream().map(x -> new MovieMinDTO(x)).collect(Collectors.toList());
		result1.forEach(System.out::println);
		
		System.out.println("JPQL Query");
		List<MovieMinDTO> result2 = repository.search2("Action");
		result2.forEach(System.out::println);
	}
}
