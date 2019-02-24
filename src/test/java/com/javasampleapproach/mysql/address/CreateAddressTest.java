package com.javasampleapproach.mysql.address;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import com.javasampleapproach.mysql.api.AddressAPI;
import com.javasampleapproach.mysql.dto.address.AddressCreateDTO;
import com.javasampleapproach.mysql.model.Address;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateAddressTest {
	
	@Autowired
	private AddressAPI address1;
	private Address address;
	private AddressCreateDTO addressCreateDTO;
	
	@Before
	public void setUp() {
		 addressCreateDTO =AddressTestFactory.getAddressTest();	
		 address =	address1.createAddress(addressCreateDTO);
		
	}
	
	@Test
	public void sholdMapFields() {
		assertEquals(addressCreateDTO.getAddressName(), address.getAddressName());
		assertEquals(addressCreateDTO.getCounty(), address.getCounty());
		assertEquals(addressCreateDTO.getStreet(), address.getStreet());
	}

	
	
	
}
