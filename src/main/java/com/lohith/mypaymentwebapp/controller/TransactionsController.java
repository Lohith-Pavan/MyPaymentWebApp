package com.lohith.mypaymentwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.lohith.mypaymentwebapp.entity.TransactionEntity;
import com.lohith.mypaymentwebapp.service.TransactionService;

@Controller
public class TransactionsController {
	@Autowired
	public TransactionService transactionService;
    @GetMapping("/transactions")
	public List<TransactionEntity> getAllTransactions() {
    	for(TransactionEntity x : transactionService.getAllTransactions()) {
    		System.out.println(x);
    	}
		return transactionService.getAllTransactions();
	}
}
