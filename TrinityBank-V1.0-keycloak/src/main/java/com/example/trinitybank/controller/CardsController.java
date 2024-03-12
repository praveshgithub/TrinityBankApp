package com.example.trinitybank.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.trinitybank.entity.Cards;
import com.example.trinitybank.entity.Customer;
import com.example.trinitybank.repository.CardsRepository;
import com.example.trinitybank.repository.CustomerRepository;

@RestController
public class CardsController {

	@Autowired
	private CardsRepository cardsRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/myCards")
	public List<Cards> getCardDetails(@RequestParam String email) {

		Optional<Customer> customer = this.customerRepository.findByEmail(email);

		if (customer.isPresent()) {
			List<Cards> cards = cardsRepository.findByCustomerId(customer.get().getId());
			if (cards != null) {
				return cards;
			}
		}
		return null;
	}
}
