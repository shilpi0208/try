package com.Mobitel.MobitelBack.Test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Mobitel.MobitelBack.dao.SupplierDAO;
import com.Mobitel.MobitelBack.model.Supplier;



public class SupplierTest
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.Mobitel.MobitelBack");
		
		context.refresh();
		
		// Inserting a Supplier Object.
		SupplierDAO supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
		
		//Insertion TestCase
		
		Supplier supplier=new Supplier();
		
		supplier.setAddress("ranchi");
		supplier.setSuppname("ashok");
		supplierDAO.insertUpdateSupplier(supplier);		
		System.out.println("Supplier Inserted");
		
		//Retrieval TestCase
		
	/*	Supplier supplier=supplierDAO.getSupplier(2);
		System.out.println("Supplier Name:"+supplier.getsupname());
		System.out.println("Supplier Description:"+supplier.getsupdesc());
		
	*/	//Deletion TestCase
		/*Supplier supplier=supplierDAO.getSupplier(2);
		supplierDAO.deleteSupplier(supplier);
		System.out.println("The Supplier Deleted");*/
		
		//Retrieving the Data
		/*
		List<Supplier> list=supplierDAO.getSupplierDetails();
		
		for(Supplier supplier:list)
		{
	
			System.out.println(supplier.getCatid()+":"+supplier.getCatname()+":"+supplier.getCatdesc());
		}
	*/	
		//Update the Supplier
		/*Supplier supplier=supplierDAO.getSupplier(1);
		supplier.setSupname("SBK Supplier");
		supplierDAO.insertUpdateSupplier(supplier);
		System.out.println("The Supplier Updated");
		*/
	}
}


