package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "Bank_details_table")
@DynamicUpdate
public class BankDetails {

@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
	public BankDetails(String bankName, String ifsc_code, String manager, String city,int pincode) {
	super();
	this.bankName = bankName;
	this.ifsc_code = ifsc_code;
	this.manager= manager;
	this.city = city;
	this.pincode=pincode;
}
	public Integer getId() {
	return id;
}
public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
public void setId(Integer id) {
	this.id = id;
}
public String getBankName() {
	return bankName;
}
public void setBankName(String bankName) {
	this.bankName = bankName;
}
public String getIfsc_code() {
	return ifsc_code;
}
public void setIfsc_code(String ifsc_code) {
	this.ifsc_code = ifsc_code;
}
public String getManager() {
	return manager;
}
public void setManager(String manager) {
	this.manager = manager;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}

	@Column(name = "bank_name", nullable = false)
	private String bankName;
	private String ifsc_code;
	private String manager;
	private String city;
	private String accountType;
	private int pincode;
	public BankDetails() {}
	
	
//	
	
	
}
