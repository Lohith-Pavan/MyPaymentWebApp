package com.lohith.mypaymentwebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lohith.mypaymentwebapp.entity.TransactionEntity;
import com.lohith.mypaymentwebapp.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	public TransactionRepository transactionRepo;
	public List<TransactionEntity> getAllTransactions(){
		return transactionRepo.findAll();
	}
}
