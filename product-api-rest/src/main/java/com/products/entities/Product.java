package com.products.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name_product", unique = true)
	private String name;
	@Column(name = "description_product")
	private String description;
	@Column(name = "price")
	private BigDecimal price;
	@Column(name = "enabled")
	private Boolean enabled;
	@Column(name = "inStock")
	private double inStock;

	public Product() {
		super();
	}

	public Product(Long id, String name, String description, BigDecimal price, Boolean enabled, double inStock) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.enabled = enabled;
		this.inStock = inStock;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public double getInStock() {
		return inStock;
	}

	public void setInStock(double inStock) {
		this.inStock = inStock;
	}

}
