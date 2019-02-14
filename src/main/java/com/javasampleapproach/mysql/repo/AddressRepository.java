package com.javasampleapproach.mysql.repo;

import org.springframework.data.repository.CrudRepository;

import com.javasampleapproach.mysql.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {


}
