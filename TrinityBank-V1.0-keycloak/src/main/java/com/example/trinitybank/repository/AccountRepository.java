package com.example.trinitybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trinitybank.entity.Accounts;

public interface AccountRepository extends JpaRepository<Accounts, Long> {

	Accounts findByCustomerId(int customerId);
}
