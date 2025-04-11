package com.lohith.mypaymentwebapp.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="user_details")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;
	@Column(name="first_name")
    private String firstName;
	@Column(name="last_name")
    private String lastName;
	@Column(name="phone_number")
    private String phoneNumber;
	@Column(name="email")
    private String email;
	@Column(name="address")
    private String address;
	@Column(name="user_name")
    private String userName;
	@Column(name="password")
    private String password;
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private UserAccountDetailsEntity userAccDetails;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TransactionEntity> transactions;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BankAccountsEntity> bankAccounts;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserAccountDetailsEntity getUserAccDetails() {
		return userAccDetails;
	}
	public void setUserAccDetails(UserAccountDetailsEntity userAccDetails) {
		this.userAccDetails = userAccDetails;
	}
	public List<TransactionEntity> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<TransactionEntity> transactions) {
		this.transactions = transactions;
	}
	public List<BankAccountsEntity> getBankAccounts() {
		return bankAccounts;
	}
	public void setBankAccounts(List<BankAccountsEntity> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", address=" + address + ", userName=" + userName + ", password="
				+ password + ", userAccDetails=" + userAccDetails + ", transactions=" + transactions + ", bankAccounts="
				+ bankAccounts + "]";
	}
	

}