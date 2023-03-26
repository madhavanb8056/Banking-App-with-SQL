package com.atm.model;

import java.util.Date;

public class TransactionHistory {
	
	private Long id;
	private Long accountNumber;
	private Date transactionDate;
	private Long withdrawAmount;
	private Long depositAmount;
	private Long balance;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Long getWithdrawAmount() {
		return withdrawAmount;
	}
	public void setWithdrawAmount(Long withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}
	public Long getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(Long depositAmount) {
		this.depositAmount = depositAmount;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
