package com.Mobitel.MobitelBack.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class Order {

	@Id
	@GeneratedValue
	private int orderid;

	private String username, paymode, shipmentaddress, status;

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPaymode() {
		return paymode;
	}

	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}

	public String getShipmentaddress() {
		return shipmentaddress;
	}

	public void setShipmentaddress(String shipmentaddress) {
		this.shipmentaddress = shipmentaddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

