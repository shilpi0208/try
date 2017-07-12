package com.Mobitel.MobitelFront.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Mobitel.MobitelBack.dao.SupplierDAO;
import com.Mobitel.MobitelBack.model.Supplier;



@Controller
public class SupplierController 
{
	
	
	@Autowired
	SupplierDAO supplierDAO;
	@RequestMapping(value="/Supplier")
	public String showSupplierPage(Model m)
	{
		System.out.println("---Supplier Page Displaying-----");
		List<Supplier> list=supplierDAO.getSupplierDetails();
		m.addAttribute("supdetail",list);
		
		boolean flag=false;
		m.addAttribute("flag",flag);
		
		return "Supplier";
	}
	
	@RequestMapping(value="/AddSupplier")
	public String addSupplier(@RequestParam("supname") String supname,@RequestParam("supaddr") String supaddr,Model m)
	{
		System.out.println("---Add Supplier Starting-----");
		
		System.out.println(supname+":::"+supaddr);
		
		Supplier supplier=new Supplier();
		supplier.setSuppname("Ashok");
		supplier.setAddress("ranchi");;
		
		supplierDAO.insertUpdateSupplier(supplier);
		
		List<Supplier> list=supplierDAO.getSupplierDetails();
		m.addAttribute("catdetail",list);
		
		boolean flag=false;
		m.addAttribute("flag",flag);
		
		System.out.println("---Supplier Added----");
		return "Supplier";
	}
	
	@RequestMapping(value="/deleteSupplier/{Supid}")
	public String deleteSupplier(@PathVariable("Supid") int Supid,Model m)
	{
		System.out.println("---Supplier Deleted----");
		Supplier supplier=supplierDAO.getSupplier(Supid);
		supplierDAO.deleteSupplier(supplier);
		
		List<Supplier> list=supplierDAO.getSupplierDetails();
		m.addAttribute("catdetail",list);
		
		boolean flag=false;
		m.addAttribute("flag",flag);
		
		return "Supplier";
	}
	
	@RequestMapping(value="/updateSupplier/{Supid}")
	public String getUpdateSupplier(@PathVariable("Supid") int Supid,Model m)
	{
		System.out.println("--- Getting Supplier Object to be Updated ---");
		
		Supplier supplier=supplierDAO.getSupplier(Supid);
		m.addAttribute("supplier",supplier);
		
		List<Supplier> list=supplierDAO.getSupplierDetails();
		m.addAttribute("catdetail",list);
		
		boolean flag=true;
		m.addAttribute("flag",flag);
		
		return "Supplier";
	}
	
	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
	public String updateSupplier(@RequestParam("Supid") int Supid,@RequestParam("supname") String supname,@RequestParam("supaddr") String supaddr,Model m)
	{
		System.out.println("--Updating the Supplier----");

		Supplier supplier=new Supplier();
		supplier.setSuppid(Supid);
		supplier.setSuppname(supname);
		supplier.setAddress(supaddr);
		
		supplierDAO.insertUpdateSupplier(supplier);
		
		List<Supplier> list=supplierDAO.getSupplierDetails();
		m.addAttribute("catdetail",list);
		
		boolean flag=false;
		m.addAttribute("flag",flag);
		
		return "Supplier";
	}
	
	
}