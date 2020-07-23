package com.inventory.product.controller;

import org.springframework.web.bind.annotation.DeleteMapping;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inventory.product.Service.ProductService;
import com.inventory.product.entity.ProductDetails;


@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	String hello = "Hello World!!";
	
	@GetMapping("/hello")
	public String sayHello() {
		return hello;
	}
	
	@GetMapping("/products")
	public List<ProductDetails> getAllProduts(){	
		return productService.getAllProducts();
	}

	@GetMapping("/products/{productid}")
	public ProductDetails getProductDetails(@PathVariable("productid") int productid) throws Exception {
		return productService.getProductDetails(productid);
	}
	
	@PostMapping("/product/add")
	public int saveProducts(@RequestBody ProductDetails productDetails) {
		return productService.saveOrUpdate(productDetails);
	}
	
	@PutMapping("/product/update")
	public ProductDetails updateProduct(@RequestBody ProductDetails productDetails) {
		productService.saveOrUpdate(productDetails);
		return productDetails;
	}
	
	@DeleteMapping("/product/delete/{productid}")
	public void deleteProducts(@PathVariable("productid") int productId ) {
		productService.deleteProducts(productId);
	}
	
	
}
