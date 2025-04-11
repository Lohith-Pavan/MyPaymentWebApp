package com.lohith.mypaymentwebapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lohith.mypaymentwebapp.entity.BankAccountsEntity;
import com.lohith.mypaymentwebapp.entity.TransactionEntity;
import com.lohith.mypaymentwebapp.entity.UserEntity;
import com.lohith.mypaymentwebapp.model.UserSendMoneyDto;
import com.lohith.mypaymentwebapp.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	public TransactionRepository transactionRepo;
	@Autowired
	UserService userService;
	@Autowired
	BankService bankService;
	public List<TransactionEntity> getAllTransactions() {
		return transactionRepo.findAll();
	}
	@Transactional
	public boolean getUpdate(UserSendMoneyDto userSendMoneyDto, Long userId) {
		Optional<UserEntity> user = userService.getUserById(userId);
		if (user.isEmpty()) {
			return false;
		}
		System.out.println(user);
		UserEntity existedUser = user.get();
		List<BankAccountsEntity> banksList = existedUser.getBankAccounts();
		BankAccountsEntity senderAccount = null;
		for (BankAccountsEntity account : banksList) {
			if (userSendMoneyDto.getFromAccount().equals(account.getAccountNumber())) {
				senderAccount = account;
				break;
			}
		}
		System.out.println(userSendMoneyDto);
		if (senderAccount == null || senderAccount.getCurrentBalance() < userSendMoneyDto.getAmount()) {
			return false;
		}
		Optional<BankAccountsEntity> receiver = bankService.getUserByAccountNumber(userSendMoneyDto.getToAccountNumber());
		if (receiver.isEmpty()) {
			return false;
		}
		BankAccountsEntity receiverAccount = receiver.get();
		senderAccount.setCurrentBalance(senderAccount.getCurrentBalance()-userSendMoneyDto.getAmount());
		bankService.saveBank(senderAccount);
		receiverAccount.setCurrentBalance(receiverAccount.getCurrentBalance()+userSendMoneyDto.getAmount());
		bankService.saveBank(receiverAccount);
		return true;
	}
}
