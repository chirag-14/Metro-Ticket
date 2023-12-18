package com.bxp.repository;

import org.springframework.data.repository.CrudRepository;

import com.bxp.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}