package dev.janaite.uri2611.dto;

import java.io.Serializable;

import dev.janaite.uri2611.projections.MovieMinProjection;

public class MovieMinDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	public MovieMinDTO() {
	}

	public MovieMinDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public MovieMinDTO(MovieMinProjection projection) {
		id = projection.getId();
		name = projection.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MovieMinDTO [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
	
}
