package com.javasampleapproach.mysql.orikamapperIMPL;
import java.util.ArrayList;


import java.util.List;


import com.javasampleapproach.mysql.dto.address.AddressCreateDTO;
import com.javasampleapproach.mysql.dto.address.AddressDetailsDTO;
import com.javasampleapproach.mysql.dto.address.AddressEditDTO;
import com.javasampleapproach.mysql.dto.address.AddressListDTO;
import com.javasampleapproach.mysql.model.Address;
import com.javasampleapproach.mysql.orikamapperAPI.AddressOrikaMapperAPI;
import com.javasampleapproach.mysql.orikamapperbase.OrikaMapperFactory;
import com.javasampleapproach.mysql.spring.sterotype.Mapper;

import ma.glasnost.orika.BoundMapperFacade;

@Mapper
public class AddressOrikaMapper extends  OrikaMapperFactory  implements AddressOrikaMapperAPI {
	
	public AddressOrikaMapper(){
		setAddressDTOtoAddress();
		setAddressListDTOfromAddress();
		setAddressDetailsDTOfromAddress();
		setAddressEditDTOtoAddress();
	}

	
	private BoundMapperFacade<AddressCreateDTO, Address> addressCreateDTOtoAddress;
	private BoundMapperFacade<Address, AddressListDTO> addressListDTOfromAddress;
	private BoundMapperFacade<Address, AddressDetailsDTO> addressDetailsDTOfromAddress;
	private BoundMapperFacade<AddressEditDTO, Address>  addressEditDTOtoAddress;
	
	//details
	public void setAddressDetailsDTOfromAddress() {
		getMapperFactory().classMap(Address.class, AddressDetailsDTO.class)
		.byDefault()
		.register();
		addressDetailsDTOfromAddress= getMapperFactory().getMapperFacade(Address.class,AddressDetailsDTO.class);
		
	}
	
	@Override
	public AddressDetailsDTO getAddressDetailsDTOfromAddress(Address address) {
		return addressDetailsDTOfromAddress.map(address);
	}
	
	//edit
	public void setAddressEditDTOtoAddress() {
		getMapperFactory().classMap(AddressEditDTO.class, Address.class)
		.byDefault()
		.register();
		
		addressEditDTOtoAddress = getMapperFactory().getMapperFacade(AddressEditDTO.class, Address.class);
	}
	@Override
	public Address getAddressEditDTOtoAddress(AddressEditDTO dto, Address address) {
		return addressEditDTOtoAddress.map(dto, address);
	}
	
	//create
	public void setAddressDTOtoAddress() {
		getMapperFactory().classMap(AddressCreateDTO.class, Address.class)
		.exclude("addressId")
		.byDefault()
		.register();
		addressCreateDTOtoAddress =getMapperFactory()
				.getMapperFacade(AddressCreateDTO.class, Address.class);
	}
	
	@Override
	public Address getAddressDTOtoAddress(AddressCreateDTO dto) {
		return addressCreateDTOtoAddress.map(dto);
	}
	//list details
	public void setAddressListDTOfromAddress() {
		getMapperFactory().classMap(Address.class, AddressListDTO.class)
		.byDefault()
		.register();
		addressListDTOfromAddress =getMapperFactory().getMapperFacade(Address.class, AddressListDTO.class);
	}
	
	@Override
	public List<AddressListDTO> getAddressListDTO(List<Address> orgList) {
			List<AddressListDTO> listNew = new ArrayList<>();
			for(Address adr: orgList) {
				AddressListDTO mappedAddress = addressListDTOfromAddress.map(adr);
				listNew.add(mappedAddress);
			}

			return listNew;
	}
	
}
