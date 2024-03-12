package com.example.trinitybank.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.trinitybank.entity.Customer;
import com.example.trinitybank.entity.Loans;
import com.example.trinitybank.repository.CustomerRepository;
import com.example.trinitybank.repository.LoanRepository;

@RestController
public class LoanController {

	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/myLoans")
	@PreAuthorize("hasRole('USER')")
	public List<Loans> getLoanDetails(@RequestParam String email) {

		Optional<Customer> customer = this.customerRepository.findByEmail(email);

		if (customer.isPresent()) {
			List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(customer.get().getId());

			if (loans != null) {
				return loans;
			}
		}
		return null;
	}
}
