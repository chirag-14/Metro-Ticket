package com.bxp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bxp.dto.CustomerDTO;
import com.bxp.entity.Customer;
import com.bxp.repository.CustomerRepository;

@Service(value="customerService")
@Transactional(readOnly=true)
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRespository;

	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public Integer addCustomer(CustomerDTO customerDTO) {

		Customer customer=new Customer();
		customer.setCreationTime(customerDTO.getCreationTime());
		customer.setEmailId(customerDTO.getEmailId());
		customer.setName(customerDTO.getName());
		customerRespository.save(customer);
		return customer.getCustomerId();

	}

}
