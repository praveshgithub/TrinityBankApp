package com.example.trinitybank.entity;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Loans {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "loan_number")
	private int loanNumber;

	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "start_dt")
	private Date startDt;

	@Column(name = "loan_type")
	private String loanType;

	@Column(name = "total_loan")
	private int totalLoan;

	@Column(name = "outStanding_amount")
	private int outStandingAmount;

	@Column(name = "create_dt")
	private String createDt;
}
