package com.Mobitel.MobitelBack.model;



import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Cart {
	@Id
	@GeneratedValue
	int cartItemid;
	
	int cartid;
	
	int proid;
	int price;
	int quantity;
	String proname,status,username;
	Date date;
	public int getCartItemid() {
		return cartItemid;
	}
	public void setCartItemid(int cartItemid) {
		this.cartItemid = cartItemid;
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
	}
		public String getProname() {
		return proname;
	}
	public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}