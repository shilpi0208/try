package com.Mobitel.MobitelBack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {
	@Id 
	@GeneratedValue
	int userid;
	
	String Uname;
	boolean Enabled;
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	String email,CustName,Upswd,Role,Mobile,Addr;
	public String getUname() {
		return Uname;
	}
	public void setUname(String uname) {
		Uname = uname;
	}
	public boolean isEnabled() {
		return Enabled;
	}
	public void setEnabled(boolean enabled) {
		Enabled = enabled;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCustName() {
		return CustName;
	}
	public void setCustName(String custName) {
		CustName = custName;
	}
	public String getUpswd() {
		return Upswd;
	}
	public void setUpswd(String upswd) {
		Upswd = upswd;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getAddr() {
		return Addr;
	}
	public void setAddr(String addr) {
		Addr = addr;
	}
	
	
}	