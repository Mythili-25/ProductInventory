package com.inventory.product.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.inventory.product.entity.ProductDetails;

@Repository
public interface ProductRepository extends CrudRepository<ProductDetails, Integer>{
	

}
