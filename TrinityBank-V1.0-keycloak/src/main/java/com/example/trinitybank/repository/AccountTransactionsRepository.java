package com.example.trinitybank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trinitybank.entity.AccountTransactions;

public interface AccountTransactionsRepository extends JpaRepository<AccountTransactions, String> {

	List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(int customerId);

}
