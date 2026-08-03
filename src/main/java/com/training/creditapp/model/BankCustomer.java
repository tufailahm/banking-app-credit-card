package com.training.creditapp.model;

import java.io.Serializable;
import java.util.Objects;
//tostring, def cons
//para cons
//setter and getter and equals 
public class BankCustomer implements Serializable {

	private int customerId;
	private int accountId;
	private String customerName;
	private String mobileNumber;
	private int balance;
	
	
	public BankCustomer() {
		// TODO Auto-generated constructor stub
	}


	
	public BankCustomer(int customerId, int accountId, String customerName, String mobileNumber, int balance) {
		super();
		this.customerId = customerId;
		this.accountId = accountId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.balance = balance;
	}



	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(accountId), Integer.valueOf(balance), Integer.valueOf(customerId),
				customerName, mobileNumber);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankCustomer other = (BankCustomer) obj;
		return accountId == other.accountId && balance == other.balance && customerId == other.customerId
				&& Objects.equals(customerName, other.customerName) && Objects.equals(mobileNumber, other.mobileNumber);
	}



	public int getCustomerId() {
		return customerId;
	}



	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}



	public int getAccountId() {
		return accountId;
	}



	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public String getMobileNumber() {
		return mobileNumber;
	}



	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	public int getBalance() {
		return balance;
	}



	public void setBalance(int balance) {
		this.balance = balance;
	}



	@Override
	public String toString() {
		return "BankCustomer [customerId=" + customerId + ", accountId=" + accountId + ", customerName=" + customerName
				+ ", mobileNumber=" + mobileNumber + ", balance=" + balance + "]";
	}
	
	

}
