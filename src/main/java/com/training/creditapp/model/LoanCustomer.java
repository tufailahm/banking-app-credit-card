package com.training.creditapp.model;

import java.io.Serializable;
import java.util.Objects;

public class LoanCustomer implements Serializable {

	private int loanId;
	private String loanType;
	private int amount;
	
	public LoanCustomer() {
		// TODO Auto-generated constructor stub
	}

	public LoanCustomer(int loanId, String loanType, int amount) {
		super();
		this.loanId = loanId;
		this.loanType = loanType;
		this.amount = amount;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, loanId, loanType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanCustomer other = (LoanCustomer) obj;
		return amount == other.amount && loanId == other.loanId && Objects.equals(loanType, other.loanType);
	}

	@Override
	public String toString() {
		return "LoanCustomer [loanId=" + loanId + ", loanType=" + loanType + ", amount=" + amount + "]";
	}
}
