package com.products.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.products.entities.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {

	public Optional<Category> findByName(String name);

}
