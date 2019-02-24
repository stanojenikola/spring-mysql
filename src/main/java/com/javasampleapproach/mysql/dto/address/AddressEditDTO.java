package com.javasampleapproach.mysql.dto.address;

import javax.validation.constraints.NotNull;

public class AddressEditDTO {

	private Long addressId;
	
	@NotNull
	private String addressName;

	@NotNull
	private String county;
	
	@NotNull
	private String street;
	
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	
}
