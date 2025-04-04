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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="user_details")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private long userId;
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
	@Override
	public String toString() {
	    return "UserEntity{" +
	            "firstName='" + firstName + '\'' +
	            ", lastName='" + lastName + '\'' +
	            ", phoneNumber='" + phoneNumber + '\'' +
	            ", email='" + email + '\'' +
	            ", address='" + address + '\'' +
	            ", userName='" + userName + '\'' +
	            ", password='" + password + '\'' +
	            '}';
	}

}