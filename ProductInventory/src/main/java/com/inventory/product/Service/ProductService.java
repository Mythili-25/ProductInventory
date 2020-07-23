package com.inventory.product.Service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.product.entity.ProductDetails;
import com.inventory.product.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	

	public List<ProductDetails> getAllProducts() {
		
		List<ProductDetails> productdList = new ArrayList<ProductDetails>();	
		
		productRepository.findAll().forEach(p -> productdList.add(p));;
		 
		 return productdList;
	}

	public ProductDetails getProductDetails(int productid) throws Exception {		
		
		Optional<ProductDetails> prdDetail = this.productRepository.findById(productid);
		if(prdDetail.isPresent()) {
			return prdDetail.get();
		}else {
			throw new Exception("Record not found with the id " +productid);
		}
	}
		

	public int saveOrUpdate(ProductDetails productDetails) {
		
		productRepository.save(productDetails);
		return productDetails.getProductid();
	}

	public void deleteProducts(int productId) {
		
		productRepository.deleteById(productId);
	}



}
