package com.lohith.mypaymentwebapp.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_account_details")
public class UserAccountDetailsEntity {
	@Id
	@Column(name="user_account_id")
	private long userAccountId;
	@Column(name="user_id")
	private long userId;
	@Column(name="account_open_date")
	private LocalDate accountOpenDate;
	@Column(name="current_wallet_balance")
	private double currentWalletBalance;
	@Column(name="linked_bank_accounts_count")
	private int linkedBankAccountsCount;
	@Column(name="wallet_pin")
	private int walletPin;
	
	public long getUserAccountId() {
		return userAccountId;
	}
	public void setUserAccountId(long userAccountId) {
		this.userAccountId = userAccountId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public LocalDate getAccountOpenDate() {
		return accountOpenDate;
	}
	public void setAccountOpenDate(LocalDate accountOpenDate) {
		this.accountOpenDate = accountOpenDate;
	}
	public double getCurrentWalletBalance() {
		return currentWalletBalance;
	}
	public void setCurrentWalletBalance(double currentWalletBalance) {
		this.currentWalletBalance = currentWalletBalance;
	}
	public int getLinkedBankAccountsCount() {
		return linkedBankAccountsCount;
	}
	public void setLinkedBankAccountsCount(int linkedBankAccountsCount) {
		this.linkedBankAccountsCount = linkedBankAccountsCount;
	}
	public int getWalletPin() {
		return walletPin;
	}
	public void setWalletPin(int walletPin) {
		this.walletPin = walletPin;
	}
	@Override
	public String toString() {
		return "UserAccountDetailsEntity [userAccountId=" + userAccountId + ", userId=" + userId + ", accountOpenDate="
				+ accountOpenDate + ", currentWalletBalance=" + currentWalletBalance + ", linkedBankAccountsCount="
				+ linkedBankAccountsCount + ", walletPin=" + walletPin + "]";
	}
	
}
