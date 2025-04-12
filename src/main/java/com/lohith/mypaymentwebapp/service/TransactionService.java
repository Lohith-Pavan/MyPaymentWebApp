package com.lohith.mypaymentwebapp.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lohith.mypaymentwebapp.entity.BankAccountsEntity;
import com.lohith.mypaymentwebapp.entity.SourceTypeEntity;
import com.lohith.mypaymentwebapp.entity.TransactionEntity;
import com.lohith.mypaymentwebapp.entity.UserEntity;
import com.lohith.mypaymentwebapp.model.UserSendMoneyDto;
import com.lohith.mypaymentwebapp.model.UserViewTransactionsModel;
import com.lohith.mypaymentwebapp.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	public TransactionRepository transactionRepo;
	@Autowired
	public UserService userService;
	@Autowired
	public BankService bankService;
	@Autowired
	public SourceTypeService sourceTypeService;
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
		Optional<BankAccountsEntity> receiver = bankService.getBankByAccountNumber(userSendMoneyDto.getToAccountNumber());
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
	public void recordTransactions(UserSendMoneyDto addTxns,Long userId){
		Optional<UserEntity> sender = userService.getUserById(userId);
		if(sender.isPresent()) {
			UserEntity sentUser = sender.get();
			TransactionEntity txn = new TransactionEntity();
			txn.setSourceId(addTxns.getFromAccount());
			txn.setTargetId(addTxns.getToAccountNumber());
			SourceTypeEntity sourceType = sourceTypeService.findBySourceTypeCode(addTxns.getTransferType());
			txn.setSourceType(sourceType);
			txn.setDestType(sourceType);
			txn.setTxnAmount(addTxns.getAmount());
			txn.setTxnDateTime(LocalDateTime.now());
			txn.setUser(sentUser);
			sentUser.getTransactions().add(txn);
			userService.saveUser(sentUser);
		}
	}
}
