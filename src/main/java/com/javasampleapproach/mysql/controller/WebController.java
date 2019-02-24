package com.javasampleapproach.mysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.mysql.model.Address;
import com.javasampleapproach.mysql.model.Customer;
import com.javasampleapproach.mysql.repo.AddressRepository;
import com.javasampleapproach.mysql.repo.CustomerRepository;


@RestController
public class WebController {
	@Autowired
	CustomerRepository repository;
	
	@Autowired
	AddressRepository addressRepository;
	
	
	@RequestMapping("/save")
	public String process(){
		repository.save(new Customer("Jack", "Smith"));
		repository.save(new Customer("Adam", "Johnson"));
		repository.save(new Customer("Kim", "Smith"));
		repository.save(new Customer("David", "Williams"));
		repository.save(new Customer("Peter", "Davis"));
		
		return repository.findAll().toString();
		
	}
	
	@GetMapping("/alladdress")
	public String findAllAddressRest() {
		String result="<html>";
		for(Address add:	addressRepository.findAll()) {
			result += "<div>" +add.toString() + "</div>";
		}
		return result + "</html>";
	}
	
	@RequestMapping("/findall")
	public String findAll(){
		String result = "<html>";
		
		for(Customer cust : repository.findAll()){
			result += "<div>" + cust.toString() + "</div>";
		}
		
		return result + "</html>";
	}
	
	@RequestMapping("/findbyid")
	public String findById(@RequestParam("id") long id){
		String result = "";
		result = repository.findOne(id).toString();
		return result;
	}
	
	
	
	@RequestMapping("/findbylastname")
	public String fetchDataByLastName(@RequestParam("lastname") String lastName){
		String result = "<html>";
		
		for(Customer cust: repository.findByLastName(lastName)){
			result += "<div>" + cust.toString() + "</div>"; 
		}
		
		return result + "</html>";
	}
}