package com.lohith.mypaymentwebapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lohith.mypaymentwebapp.entity.BankAccountsEntity;
import com.lohith.mypaymentwebapp.entity.UserEntity;
import com.lohith.mypaymentwebapp.model.UserSendMoneyDto;
import com.lohith.mypaymentwebapp.model.UserViewBankModel;
import com.lohith.mypaymentwebapp.service.BankService;
import com.lohith.mypaymentwebapp.service.TransactionService;
import com.lohith.mypaymentwebapp.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class SendMoneyController {
	@Autowired
	public UserService userService;
	@Autowired
	public BankService bankService;
	@Autowired
	public TransactionService transactionService;

	@GetMapping("/sendmoney")
	public String ViewSendMoneyPage(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		Optional<UserEntity> user = userService.getUserById(userId);
		if (user.isPresent()) {
			UserEntity existedUser = user.get();
			List<BankAccountsEntity> banksList = new ArrayList<>();
			banksList = existedUser.getBankAccounts();
			if (banksList != null && !banksList.isEmpty()) {
				List<UserViewBankModel> userBanksList = new ArrayList<>();
				for (BankAccountsEntity bank : banksList) {
					UserViewBankModel userViewBankModel = new UserViewBankModel();
					userViewBankModel.setAccountNumber(bank.getAccountNumber());
					userViewBankModel.setBankName(bank.getBankName());
					userBanksList.add(userViewBankModel);
				}
				model.addAttribute("userBanksList", userBanksList);
			}
		}
		return "sendmoney";
	}

	@PostMapping("/sendmoney")
	public String sendMoney(@ModelAttribute UserSendMoneyDto userSendMoneyDto, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/login";
		}
		boolean transaction = transactionService.getUpdate(userSendMoneyDto, userId);
		if (transaction) {
			return "redirect:/dashboard";
		} else {
			return "redirect:/sendmoney";
		}
	}
}
