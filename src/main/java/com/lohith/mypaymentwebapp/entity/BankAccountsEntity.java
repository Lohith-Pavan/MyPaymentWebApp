package com.lohith.mypaymentwebapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="bank_accounts")
public class BankAccountsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bank_account_id")
    private long bankAccountId;
	@Column(name="bank_name")
	private String bankName;
	@Column(name="account_number")
	private long AccountNumber;
    @Column(name="ifsc_code")
	private String ifscCode;
    @Column(name="current_balance")
    private double currentBalance;
    @Column(name="pin")
    private int pin;
    @Column(name="bank_branch")
	private String bankBranch;
    @Column(name="account_status")
	private String accountStatus;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
	public long getBankAccountId() {
		return bankAccountId;
	}
	public void setBankAccountId(long bankAccountId) {
		this.bankAccountId = bankAccountId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public long getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		AccountNumber = accountNumber;
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
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "BankAccountsEntity [bankAccountId=" + bankAccountId + ", bankName=" + bankName + ", AccountNumber="
				+ AccountNumber + ", ifscCode=" + ifscCode + ", currentBalance=" + currentBalance + ", pin=" + pin
				+ ", bankBranch=" + bankBranch + ", accountStatus=" + accountStatus + ", user=" + user + "]";
	}
	
	   
}
