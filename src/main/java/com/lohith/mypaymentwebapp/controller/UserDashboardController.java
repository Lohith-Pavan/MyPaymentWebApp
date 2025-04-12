package com.lohith.mypaymentwebapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lohith.mypaymentwebapp.entity.BankAccountsEntity;
import com.lohith.mypaymentwebapp.entity.TransactionEntity;
import com.lohith.mypaymentwebapp.entity.UserEntity;
import com.lohith.mypaymentwebapp.model.UserDashboardModel;
import com.lohith.mypaymentwebapp.model.UserProfileModel;
import com.lohith.mypaymentwebapp.model.UserViewBankModel;
import com.lohith.mypaymentwebapp.model.UserViewTransactionsModel;
import com.lohith.mypaymentwebapp.service.BankService;
import com.lohith.mypaymentwebapp.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserDashboardController {
	@Autowired
	public UserService userService;
	@Autowired
	public BankService bankService;

	@GetMapping("/dashboard")
	public String loadprofilepage(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/login";
		}
		Optional<UserEntity> user = userService.getUserById(userId);
		if (user.isPresent()) {
			UserEntity existedUser = user.get();
			UserDashboardModel userDashboardModel = new UserDashboardModel();
			UserProfileModel userProfileModel = new UserProfileModel();
			userProfileModel.setFirstName(existedUser.getFirstName());
			userProfileModel.setLastName(existedUser.getLastName());
			userProfileModel.setPhoneNumber(existedUser.getPhoneNumber());
			userProfileModel.setEmail(existedUser.getEmail());
			userProfileModel.setAddress(existedUser.getAddress());
			userDashboardModel.setUserProfileModel(userProfileModel);

			List<BankAccountsEntity> userBank = existedUser.getBankAccounts();
			if (userBank != null && !userBank.isEmpty()) {
				List<UserViewBankModel> banks = new ArrayList<>();
				for (BankAccountsEntity existedUserBank : userBank) {
					UserViewBankModel bank = new UserViewBankModel();
					bank.setBankName(existedUserBank.getBankName());
					bank.setAccountNumber(existedUserBank.getAccountNumber());
					bank.setIfscCode(existedUserBank.getIfscCode());
					bank.setCurrentBalance(existedUserBank.getCurrentBalance());
					bank.setBankBranch(existedUserBank.getBankBranch());
					banks.add(bank);
				}
				userDashboardModel.setUserBanksListModel(banks);
			}
			List<TransactionEntity> txnsList = existedUser.getTransactions();
			if(txnsList!=null && !txnsList.isEmpty()) {
				List<UserViewTransactionsModel> txns = new ArrayList<>();
				for(TransactionEntity existedUserTxns : txnsList) {
					UserViewTransactionsModel txn = new UserViewTransactionsModel();
					txn.setTxnId(existedUserTxns.getTxnId());
					txn.setDate(existedUserTxns.getTxnDateTime());
					txn.setSender(existedUserTxns.getUser().getFirstName());
					UserEntity receiver = bankService.getBankByAccountNumber(existedUserTxns.getTargetId()).get().getUser();
					txn.setReceiver(receiver.getFirstName());
					txn.setSourceType(existedUserTxns.getSourceType().getSourceTypeCode());
					txn.setDestType(existedUserTxns.getDestType().getSourceTypeCode());
					txn.setAmount(existedUserTxns.getTxnAmount());
					txns.add(txn);
				}
				userDashboardModel.setUserTxnListModel(txns);
			}
			model.addAttribute("userDashboardModel", userDashboardModel);
		}
		return "dashboard";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

}
