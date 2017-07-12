package com.Mobitel.MobitelFront.Controller;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Mobitel.MobitelBack.dao.CategoryDAO;
import com.Mobitel.MobitelBack.dao.ProductDAO;
import com.Mobitel.MobitelBack.model.Category;
import com.Mobitel.MobitelBack.model.Product;



@Controller
public class ProductController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/Product")
	public String showProduct(Model m)
	{
		
		
		Product product=new Product();
		
		m.addAttribute("catlist",this.getCatList());
		m.addAttribute("product",product);
		
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
		
		
		return "Product";
	}
	
	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product") Product product,Model m)
	{
		System.out.println("---Product Inserted---");
		productDAO.insertUpdateProduct(product);	
		
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
		
		return "Product";
	}
	
	@RequestMapping(value="/updateProduct/{prodid}")
	public String updateProduct(@PathVariable("prodid")int prodid,Model m)
	{
		
		Product product=productDAO.getProduct(prodid);
		m.addAttribute("product",product);
		m.addAttribute("catlist",this.getCatList());
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
		
		return "redirect:/Product";
	}
	
	@RequestMapping(value="/deleteProduct/{prodid}")
	public String deleteProduct(@PathVariable("prodid")int prodid,Model m)
	{
		
		Product product=productDAO.getProduct(prodid);
		productDAO.deleteProduct(product);
		
		Product product1=new Product();
		m.addAttribute("product",product1);
		m.addAttribute("catlist",this.getCatList());
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
		
		return "Product";
	}
	
	public LinkedHashMap<Integer,String> getCatList()
	{
		List<Category> list=categoryDAO.getCategoryDetails();
		
		LinkedHashMap<Integer,String> catlist=new LinkedHashMap<Integer,String>();
		
		for(Category cat:list)
		{
			catlist.put(cat.getCatid(),cat.getCatname());
		}
		
		return catlist;
	}
	
	
	
	
}