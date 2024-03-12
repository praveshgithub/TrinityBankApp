package com.example.trinitybank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trinitybank.entity.Loans;

public interface LoanRepository extends JpaRepository<Loans, Integer> {

	List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);
}
