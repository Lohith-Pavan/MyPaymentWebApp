package com.lohith.mypaymentwebapp.model;

import jakarta.persistence.Column;

public class UserAddBankModel {
	private String bankName;   
	private Long accountNumber;
	private String ifscCode;
	private double currentBalance;
	private int pin;
	private String bankBranch;
	private String accountStatus;
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	@Override
	public String toString() {
		return "UserAddBankModel [bankName=" + bankName + ", accountNumber=" + accountNumber + ", ifscCode=" + ifscCode
				+ ", currentBalance=" + currentBalance + ", pin=" + pin + ", bankBranch=" + bankBranch
				+ ", accountStatus=" + accountStatus + "]";
	}  
	
}
