package com.lohith.mypaymentwebapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lohith.mypaymentwebapp.entity.BankAccountsEntity;
import com.lohith.mypaymentwebapp.entity.UserAccountDetailsEntity;
import com.lohith.mypaymentwebapp.entity.UserEntity;
import com.lohith.mypaymentwebapp.repository.BankAccountsRepository;
import com.lohith.mypaymentwebapp.repository.UserAccountDetailsRepository;

@Service
public class BankService {
	@Autowired
	public BankAccountsRepository bankAccRepo;
//	public UserAccountDetailsRepository userAccountDetailsRepository;
//	public List<UserAccountDetailsEntity> getAllUserAccountDetails(){
//		return userAccountDetailsRepository.findAll();
//	}
//	public BankAccountsEntity saveUser(BankAccountsEntity user) {
//		return bankAccRepo.save(user);
//	}
	public Optional<BankAccountsEntity> getUserBankById(Long userId){
		return bankAccRepo.findById(userId);
	}
}
