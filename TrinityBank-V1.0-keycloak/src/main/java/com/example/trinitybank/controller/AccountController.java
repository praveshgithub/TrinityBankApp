package com.example.trinitybank.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.trinitybank.entity.Accounts;
import com.example.trinitybank.entity.Customer;
import com.example.trinitybank.repository.AccountRepository;
import com.example.trinitybank.repository.CustomerRepository;

@RestController
public class AccountController {

	@Autowired
	private AccountRepository accountsRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/acc")
	public String getAccounts() {
		return "dummy accounts details";
	}

	@GetMapping("/myAccount")
	public Accounts getAccountDetails(@RequestParam String email) {

		Optional<Customer> customer = this.customerRepository.findByEmail(email);

		if (customer.isPresent()) {
			Accounts account = this.accountsRepository.findByCustomerId(customer.get().getId());
			if (account != null) {
				return account;
			}
		}
		return null;
	}
}
