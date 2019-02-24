package com.javasampleapproach.mysql.guicontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javasampleapproach.mysql.api.AddressAPI;
import com.javasampleapproach.mysql.dto.address.AddressCreateDTO;
import com.javasampleapproach.mysql.dto.address.AddressDetailsDTO;
import com.javasampleapproach.mysql.dto.address.AddressEditDTO;

@Controller
public class AddressController {

	private static final String PAGE_CREATE_ADDRESS= "/pages/address/createaddress";
	private static final String PAGE_EDIT_ADDRESS = "/pages/address/editaddress";
	private static final String PAGE_DETAILS_ADDRESS = "/pages/address/detailsaddress";
	
	@Autowired
	private AddressAPI addressAPI;
	
	@DeleteMapping("/delete/{id}")
	public String getDelete(
			@PathVariable("id") Long addressId) {
		
		addressAPI.deleteAddress( addressId);
		return "redirect:/home";
	}
	@GetMapping("/createAddress")
	public String getCreateAddress(Model model) {
		AddressCreateDTO addressCreateDTO = new AddressCreateDTO();
		model.addAttribute("address", addressCreateDTO);
		
		return PAGE_CREATE_ADDRESS;
	}
	
	@GetMapping("/detailsAddress/{id}")
	public String getAddressDetails(Model model,
			@PathVariable("id") Long id) throws Exception {
		
		model.addAttribute("details", addressAPI.getAddressDetails(id));
		
		return PAGE_DETAILS_ADDRESS;
	}
	
	@PostMapping("/createAddress")
	public String postCreataAddress(Model model,
			@Valid @ModelAttribute AddressCreateDTO address, BindingResult bindingResult,
		RedirectAttributes redirectAttributes) {
		
		if(!bindingResult.hasErrors()) {
			addressAPI.createAddress(address);
			return "redirect:/home";
		} else {
			model.addAttribute("address", address);
		
			return PAGE_CREATE_ADDRESS;
		}
	}
	//edit dto
	@GetMapping("/editAddress/{addressId}")
	public String getEditAddress(Model model, 
			@PathVariable("addressId") Long addressId) throws Exception {
		AddressDetailsDTO addressDetailsDTO = addressAPI.getAddressDetails(addressId);
		model.addAttribute("address", addressDetailsDTO);
		
		return PAGE_EDIT_ADDRESS;
	}
	
	@PutMapping("/editAddress/{addressId}")
	public String postEditAddress(Model model, 
			@PathVariable("addressId") Long addressId,
			@Valid @ModelAttribute("address") AddressEditDTO addressEditDTO, BindingResult bindingResult) throws Exception {
		
		if(!bindingResult.hasErrors()) {
			this.addressAPI.editAddress(addressEditDTO);
			return "redirect:/home";
		}
		
		model.addAttribute("address", addressEditDTO);
		return PAGE_EDIT_ADDRESS;
	}
	
}
