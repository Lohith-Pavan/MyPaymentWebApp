package com.lohith.mypaymentwebapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.lohith.mypaymentwebapp.entity.TransactionEntity;
import com.lohith.mypaymentwebapp.entity.UserEntity;
import com.lohith.mypaymentwebapp.model.UserSendMoneyDto;
import com.lohith.mypaymentwebapp.model.UserViewTransactionsModel;
import com.lohith.mypaymentwebapp.service.TransactionService;
import com.lohith.mypaymentwebapp.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class TransactionsController {
	@Autowired
	public TransactionService transactionService;
	@Autowired
	public UserService userService;
    @GetMapping("/transactions")
	public List<TransactionEntity> getAllTransactions() {
    	for(TransactionEntity x : transactionService.getAllTransactions()) {
    		System.out.println(x);
    	}
		return transactionService.getAllTransactions();
	}
}
