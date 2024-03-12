package com.example.trinitybank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.trinitybank.entity.Customer;
import com.example.trinitybank.repository.CustomerRepository;
import com.example.trinitybank.service.CustomerService;

@RestController
public class LoginController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<List<Customer>> showAllCustomer() {
		return new ResponseEntity<>(this.customerRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<Customer> registerUser(@RequestBody Customer customer) {
		return this.customerService.createCustomer(customer);
	}

	@GetMapping("/user")
	public Customer getUserDetailsAfterLogin(Authentication authentication) {

		Optional<Customer> customer = customerRepository.findByEmail(authentication.getName());
		if (customer.isPresent()) {
			return customer.get();
		} else {
			return null;
		}
	}
}
