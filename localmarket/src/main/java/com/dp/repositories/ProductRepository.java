package com.dp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dp.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	List<Product> findByType(String type);
}
