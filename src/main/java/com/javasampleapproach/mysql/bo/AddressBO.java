package com.javasampleapproach.mysql.bo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javasampleapproach.mysql.api.AddressAPI;
import com.javasampleapproach.mysql.dto.address.AddressCreateDTO;
import com.javasampleapproach.mysql.dto.address.AddressDetailsDTO;
import com.javasampleapproach.mysql.dto.address.AddressEditDTO;
import com.javasampleapproach.mysql.dto.address.AddressListDTO;
import com.javasampleapproach.mysql.model.Address;
import com.javasampleapproach.mysql.orikamapperIMPL.AddressOrikaMapper;
import com.javasampleapproach.mysql.repo.AddressRepository;

@Service
public class AddressBO implements AddressAPI{
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private AddressOrikaMapper addressOrikaMapper;
	
	@Transactional
	@Override
	public Address createAddress(AddressCreateDTO addressCreateDTO) {
		Address address = addressOrikaMapper.getAddressDTOtoAddress(addressCreateDTO);
		address = addressRepository.save(address);
		
		return address;	
	}
	
	@Transactional
	@Override
	public List<AddressListDTO> getAllAddress() {
			List<Address>address = (List<Address>) addressRepository.findAll();
		return	addressOrikaMapper.getAddressListDTO(address);

	}
	@Transactional(readOnly =true)
	@Override
	public AddressDetailsDTO getAddressDetails(long id) throws Exception {
		Address address =findAddressDetails(id);
		
		AddressDetailsDTO addressDetailsDTO =addressOrikaMapper.getAddressDetailsDTOfromAddress(address);
		return addressDetailsDTO;
	}
	
	@Transactional(readOnly=true)
	@Override
	public Address findAddressDetails(long addressId) throws Exception {
		Address address= addressRepository.findOne(addressId);
		
		if(address==null) {
			throw new Exception("Id not found");
		}
		
		return address;
	}

	@Transactional
	@Override
	public void editAddress(@Valid AddressEditDTO addressEditDTO) throws Exception {
		Address address = findAddressDetails(addressEditDTO.getAddressId());
		
		 address = addressOrikaMapper.getAddressEditDTOtoAddress(addressEditDTO,address);
		 addressRepository.save(address);
	}
	
}
