package com.inventory;




import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.inventory.OnlineShoppingSiteApplication;
import com.inventory.product.controller.ProductController;
import com.inventory.product.entity.ProductDetails;
import com.inventory.product.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=OnlineShoppingSiteApplication.class)
public class OnlineShoppingSiteApplicationTests {

	@Autowired
	ProductController productController;
	

	@Test
	public void contextLoads() {
		
	}	
	
	@Test
	public void testHello() {
		assertNotNull(productController.sayHello());
	}
	
	@Test
	public void testCreate() {
		ProductDetails productDetails = new ProductDetails();
		//pd.setProductid(07);
		productDetails.setProductname("Redmi Note 5");
		productDetails.setCategory("Mobile Accessories");
		productDetails.setBrand("Redmi");
		productDetails.setQuantity(12);
		productDetails.setPrice(30000);
		assertNotNull(productController.saveProducts(productDetails));
	}
	
	@Test
	public void testReadAll() {
		assertNotNull(productController.getAllProduts());
	}

	@Test
	public void testReadById() throws Exception {
		assertNotNull(productController.getProductDetails(1));
	}
	
	@Test
	public void testUpdate() throws Exception {			
		ProductDetails productDetails = productController.getProductDetails(1);
		if(productDetails != null) {
			int price =0;
			assertNotNull(productDetails);
			productDetails.setPrice(86543);	
			price = productDetails.getPrice();
			assertEquals(86543,price);
			productController.updateProduct(productDetails);
		}
	}
	
	@Test
	public void testDeleteById() throws Exception {
		ProductDetails productDetails = productController.getProductDetails(7);
		assertNotNull(productDetails);
		productController.deleteProducts(productDetails.getProductid());
	}
		
	

}
