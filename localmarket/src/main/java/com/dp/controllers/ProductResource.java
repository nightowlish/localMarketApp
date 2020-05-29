package com.dp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dp.entities.Product;
import com.dp.repositories.ProductRepository;

@RestController
//@RequestMapping("api")
public class ProductResource {

	@Autowired
	ProductRepository repository;
	
	@CrossOrigin
	@GetMapping("/api/products/{type}")
	public List <Product> fetchDataByType(@PathVariable String type)
	{
		System.out.println("Searching for products...");
		System.out.println(type);
		List<Product> products =  repository.findByType(type);
		System.out.println(products);
		return products;
	}
	
	@CrossOrigin
	@PostMapping("/api/products/add")
	public Product saveProduct(@RequestBody Product p)
	{
		System.out.println(p);
		repository.save(p);
		return p;
	}
	
	@PutMapping("products/update")
	public Product updateProduct(long pid, String name, String type, int price, String description, String photoPath)
	{
		Product p = new Product();
		Optional<Product> product = repository.findById(pid);
		
		if(product.isPresent())
		{
			p = product.get();
			p.setDescription(description);
			p.setName(name);
			p.setPhotoPath(photoPath);
			p.setPrice(price);
			p.setType(type);
			repository.save(p);
		}
		else
		{
			System.out.println("Product not found.");
		}
		
		return p;
	}
	
	@DeleteMapping("products/delete")
	public Product deleteProduct(long pid)
	{
		Product  p = new Product();
		
		repository.deleteById(pid);
		
		return p;
	}
}
