package dev.janaite.uri2621.dto;

import java.io.Serializable;

import dev.janaite.uri2621.projections.ProductMinProjection;

public class ProductMinDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;

	public ProductMinDTO() {
	}

	public ProductMinDTO(String name) {
		super();
		this.name = name;
	}

	public ProductMinDTO(ProductMinProjection projection) {
		this.name = projection.getName();
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
		builder.append("ProductMinDTO [name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

}
