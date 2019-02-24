package com.javasampleapproach.mysql.address;

import com.javasampleapproach.mysql.dto.address.AddressCreateDTO;

public class AddressTestFactory {
	
	
	public static AddressCreateDTO getAddressTest() {
		AddressCreateDTO addressCreateDTO = new AddressCreateDTO();
		addressCreateDTO.setAddressId(123456789L);
		addressCreateDTO.setAddressName("nikol");
		addressCreateDTO.setCounty("serbia");
		addressCreateDTO.setStreet("hartlgasee");
		
		return addressCreateDTO;
	}

}
