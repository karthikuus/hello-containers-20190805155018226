package com.baabbee.iframex.beans;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class Address {
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String zipcode;
	private String state;
	private String country;
	
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Address(String addressLine1, String addressLine2, String city, String zipcode, String state,
			String country) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.zipcode = zipcode;
		this.state = state;
		this.country = country;
	}


	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", city=" + city + ", zipcode=" + zipcode + ", state=" + state + ", country=" + country
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
