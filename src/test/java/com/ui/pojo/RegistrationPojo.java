package com.ui.pojo;

import com.github.javafaker.Company;
import com.github.javafaker.PhoneNumber;

public class RegistrationPojo {
	
	private String firstName;
	private String lastName;
	private String company;
	private String address1;
	private String address2;
	private String State;
	private String city;
	private String postal;
	private String mobile;
	

	
	
	public RegistrationPojo(String firstName, String lastName, String company, String address1, String address2,
			String state, String city, String postal, String mobile) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.address1 = address1;
		this.address2 = address2;
		this.State = state;
		this.city = city;
		this.postal = postal;
		this.mobile = mobile;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "RegistrationPojo [firstName=" + firstName + ", lastName=" + lastName + ", company=" + company
				+ ", address1=" + address1 + ", address2=" + address2 + ", State=" + State + ", city=" + city
				+ ", postal=" + postal + ", mobile=" + mobile + "]";
	}
	
	
	

}
