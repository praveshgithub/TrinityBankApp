package com.example.trinitybank.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.trinitybank.entity.Customer;
import com.example.trinitybank.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public ResponseEntity<Customer> createCustomer(Customer customer) {
		customer.setPassword(this.passwordEncoder.encode(customer.getPassword()));
		customer.setRole("ROLE_" + customer.getRole().toUpperCase());
		customer.setCreateDt(String.valueOf(new Date(System.currentTimeMillis())));
		Customer savedCustomer = this.customerRepository.save(customer);
		return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
	}

}
