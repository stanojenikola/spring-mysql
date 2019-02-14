package com.javasampleapproach.mysql.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="address_new")
public class Address implements Serializable {

	private static final long serialVersionUID = -3128504189683663194L;

	public Address() {
	}

	@Id
	@Column(name="address_id", nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long addressId;
	
	@NotNull
	@Column(name="address_name" ,nullable=false)
	private String addressName;
	
	@NotNull
	@Column(nullable=false)
	private String street;
	
	@NotNull
	@Column(nullable=false)
	private String county;

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}
}
