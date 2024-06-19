package com.ilp04.entity;

public class Customer {

	private int customer_code;
	private String customer_firstname;
	private String customer_lastname;
	private String address;
	private long phonenumber;
	private long aadharno;
	public Customer(int customer_code, String customer_firstname, String customer_lastname, String address,
			long phonenumber, long aadharno) {
		super();
		this.customer_code = customer_code;
		this.customer_firstname = customer_firstname;
		this.customer_lastname = customer_lastname;
		this.address = address;
		this.phonenumber = phonenumber;
		this.aadharno = aadharno;
	}
	public int getCustomer_code() {
		return customer_code;
	}
	public void setCustomer_code(int customer_code) {
		this.customer_code = customer_code;
	}
	public String getCustomer_firstname() {
		return customer_firstname;
	}
	public void setCustomer_firstname(String customer_firstname) {
		this.customer_firstname = customer_firstname;
	}
	public String getCustomer_lastname() {
		return customer_lastname;
	}
	public void setCustomer_lastname(String customer_lastname) {
		this.customer_lastname = customer_lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public long getAadharno() {
		return aadharno;
	}
	public void setAadharno(long aadharno) {
		this.aadharno = aadharno;
	}

}
