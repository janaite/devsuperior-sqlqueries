package dev.janaite.uri2602.dto;

import java.io.Serializable;

import dev.janaite.uri2602.projections.CustomerMinProjection;

public class CustomerMinDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	
	public CustomerMinDTO() {
	}

	public CustomerMinDTO(String name) {
		this.name = name;
	}

	public CustomerMinDTO(CustomerMinProjection projection) {
		name = projection.getName();
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
		builder.append("CustomerMinDTO [name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

}
