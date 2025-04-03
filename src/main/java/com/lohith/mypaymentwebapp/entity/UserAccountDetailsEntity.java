package com.lohith.mypaymentwebapp.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user_account_details")
public class UserAccountDetailsEntity {
	@Id
	@Column(name = "user_account_id")
	private long userAccountId;
	@Column(name = "account_open_date")
	private LocalDate accountOpenDate;
	@Column(name = "current_wallet_balance")
	private double currentWalletBalance;
	@Column(name = "linked_bank_accounts_count")
	private int linkedBankAccountsCount;
	@Column(name = "wallet_pin")
	private int walletPin;
	@OneToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;

}
