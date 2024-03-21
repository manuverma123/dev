package com.bank.customer.service.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.customer.service.entities.*;
import com.bank.customer.service.exception.*;
import com.bank.customer.service.repository.*;
import com.bank.customer.service.services.*;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
	return customerRepository.save(customer);
    }
    
    @Override
    public List<Customer> getAllCustomers() {
	return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Long id) {
	return customerRepository.findById(id).orElseThrow(
		() -> new ResourceNotFoundException("Customer with the following ID was not found: " + id));
    }

    @Override
    public Customer updateCustomer(Customer customer) {
	return customerRepository.save(customer);
    }
    @Override
    public Customer deleteCustomer(Long id) {
	Customer customer = customerRepository.findById(id).orElseThrow(
		() -> new ResourceNotFoundException("Customer with the following ID was not found: " + id));
	if (customer != null) {
	    customerRepository.delete(customer);
	}
	return customer;
    }

    
    @Override
    public Customer getCustomerById(Long id) {
        // Implement the logic to retrieve a customer by ID from the repository
        return customerRepository.findById(id)
                                  .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
    }
    
    
    
    
}