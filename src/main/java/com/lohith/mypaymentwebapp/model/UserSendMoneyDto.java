package com.lohith.mypaymentwebapp.model;

public class UserSendMoneyDto {
	private double amount;
	private Long fromAccount;
	private String transferType;
	private Long toAccountNumber;
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Long getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}
	public String getTransferType() {
		return transferType;
	}
	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}
	public Long getToAccountNumber() {
		return toAccountNumber;
	}
	public void setToAccountNumber(Long toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}
	@Override
	public String toString() {
		return "UserSendMoneyDto [amount=" + amount + ", fromAccount=" + fromAccount + ", transferType=" + transferType
				+ ", toAccountNumber=" + toAccountNumber + "]";
	}
}
