package com.example.trinitybank.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.trinitybank.entity.AccountTransactions;
import com.example.trinitybank.entity.Customer;
import com.example.trinitybank.repository.AccountTransactionsRepository;
import com.example.trinitybank.repository.CustomerRepository;

@RestController
public class BalanceController {

	@Autowired
	private AccountTransactionsRepository accountTransactionsRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/myBalance")
	public List<AccountTransactions> getBalanceDetails(@RequestParam String email) {

		Optional<Customer> customer = this.customerRepository.findByEmail(email);

		if (customer.isPresent()) {
			List<AccountTransactions> accountTransactions = this.accountTransactionsRepository
					.findByCustomerIdOrderByTransactionDtDesc(customer.get().getId());
			if (accountTransactions != null) {
				return accountTransactions;
			}
		}
		return null;
	}
}
