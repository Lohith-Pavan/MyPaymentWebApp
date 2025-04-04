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
	@Column(name="account_number")
	private long AccountNumber;
    @Column(name="ifsc_code")
	private String ifscCode;
    @Column(name="bank_name")
	private String bankName;
    @Column(name="bank_branch")
	private String bankBranch;
    @Column(name="bank_location")
	private String bankLocation;
    @Column(name="is_active")
	private String isActive;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
	public long getBankAccountId() {
		return bankAccountId;
	}
	public void setBankAccountId(long bankAccountId) {
		this.bankAccountId = bankAccountId;
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
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	public String getBankLocation() {
		return bankLocation;
	}
	public void setBankLocation(String bankLocation) {
		this.bankLocation = bankLocation;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "BankAccountsEntity [bankAccountId=" + bankAccountId + ", AccountNumber=" + AccountNumber + ", ifscCode="
				+ ifscCode + ", bankName=" + bankName + ", bankBranch=" + bankBranch + ", bankLocation=" + bankLocation
				+ ", isActive=" + isActive + ", user=" + user + "]";
	}
    
}
