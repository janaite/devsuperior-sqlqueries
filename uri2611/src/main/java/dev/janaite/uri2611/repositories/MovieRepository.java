package dev.janaite.uri2611.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.janaite.uri2611.dto.MovieMinDTO;
import dev.janaite.uri2611.entities.Movie;
import dev.janaite.uri2611.projections.MovieMinProjection;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	@Query(nativeQuery = true, value = "SELECT movies.id, movies.name "
			+ "FROM movies " 
			+ "INNER JOIN genres ON movies.id_genres = genres.id "
			+ "WHERE genres.description = :genreName")
	List<MovieMinProjection> search1(String genreName);

	@Query("SELECT new dev.janaite.uri2611.dto.MovieMinDTO(m.id, m.name) "
			+ "FROM Movie m " 
			+ "WHERE m.genre.description = :genreName")
	List<MovieMinDTO> search2(String genreName);
}
