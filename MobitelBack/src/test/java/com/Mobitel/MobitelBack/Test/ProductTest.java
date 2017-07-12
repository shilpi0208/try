package com.Mobitel.MobitelBack.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Mobitel.MobitelBack.dao.ProductDAO;
import com.Mobitel.MobitelBack.model.Product;



public class ProductTest {

	public static void main(String arg[]) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.Mobitel.MobitelBack");

		context.refresh();

		// Inserting a Product Object.
		ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");

		// Insertion TestCase
		
		Product product = new Product();
		product.setProdname("Book");
		product.setCatid(1);
		product.setPrice(1000);
		product.setQuantity(2);
		product.setSuppid(1);
		product.setProdDesc("engineering");
		productDAO.insertUpdateProduct(product);		
		System.out.println("product Inserted");
	
		

		// Retrieval TestCase

		/*
		 Product product=productDAO.getProduct(3);
		  System.out.println("Product Name:"+product.getProname());
		  System.out.println("Product Description:"+product.getProdesc());
		 
		  // Deletion TestCase
		/*
		 * Product product=productDAO.getProduct(2);
		 * productDAO.deleteProduct(product);
		 * System.out.println("The Product Deleted");
		 */

		// Retrieving the Data
		/*
		 * List<Product> list=productDAO.getProductDetails();
		 * 
		 * for(Product product:list) {
		 * 
		 * System.out.println(product.getproid()+":"+product.getproname()+":"+
		 * product.getprodesc()); }
		 */
		// Update the Product
		
		/*  Product product=productDAO.getProduct(3);
		  product.setProname("Casio Edifice");
		  productDAO.insertUpdateProduct(product);
		  System.out.println("The Product Updated");
		 */
	}
}