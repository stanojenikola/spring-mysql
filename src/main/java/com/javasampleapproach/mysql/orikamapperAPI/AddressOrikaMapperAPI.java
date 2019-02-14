package com.javasampleapproach.mysql.orikamapperAPI;

import java.util.List;

import com.javasampleapproach.mysql.dto.address.AddressCreateDTO;
import com.javasampleapproach.mysql.dto.address.AddressDetailsDTO;
import com.javasampleapproach.mysql.dto.address.AddressEditDTO;
import com.javasampleapproach.mysql.dto.address.AddressListDTO;
import com.javasampleapproach.mysql.model.Address;

public interface AddressOrikaMapperAPI {

	public Address getAddressDTOtoAddress(AddressCreateDTO dto) ;

	List<AddressListDTO> getAddressListDTO(List<Address> orgList);
	
	AddressDetailsDTO getAddressDetailsDTOfromAddress(Address address);

	Address getAddressEditDTOtoAddress(AddressEditDTO dto, Address address);
}
