package com.javasampleapproach.mysql.api;

import java.util.List;

import com.javasampleapproach.mysql.dto.address.AddressCreateDTO;
import com.javasampleapproach.mysql.dto.address.AddressDetailsDTO;
import com.javasampleapproach.mysql.dto.address.AddressEditDTO;
import com.javasampleapproach.mysql.dto.address.AddressListDTO;
import com.javasampleapproach.mysql.model.Address;

public interface AddressAPI {

public List<AddressListDTO> getAllAddress();
public Address createAddress(AddressCreateDTO addressCreateDTO);
Address findAddressDetails(long addressId) throws Exception;
AddressDetailsDTO getAddressDetails(long id) throws Exception;
void editAddress(AddressEditDTO addressEditDTO) throws Exception;
public void deleteAddress(Long addressId);

}