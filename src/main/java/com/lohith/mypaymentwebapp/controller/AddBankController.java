package com.lohith.mypaymentwebapp.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lohith.mypaymentwebapp.entity.BankAccountsEntity;
import com.lohith.mypaymentwebapp.entity.UserEntity;
import com.lohith.mypaymentwebapp.model.UserAddBankModel;
import com.lohith.mypaymentwebapp.model.UserBankModel;
import com.lohith.mypaymentwebapp.service.BankService;
import com.lohith.mypaymentwebapp.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AddBankController {
	@Autowired
	public UserService userService;
	public BankService bankService;
	@GetMapping("/addbankaccount")
	public String showAddBankAccountPage() {
		return "addbankaccount";
	}
	@PostMapping("/addbankaccount")
	public String addBankAccount(@ModelAttribute UserBankModel bankDetails,HttpSession session,Model model) {
		// Get the logged-in user (assuming you store it in session)
	    Long userId = (Long) session.getAttribute("userId"); 
	    UserEntity user = userService.getUserById(userId).orElse(null);

	    if (user != null) {
	        UserAddBankModel form = bankDetails.getUserAddBankModel();

	        BankAccountsEntity account = new BankAccountsEntity();
	        account.setBankName(form.getBankName());
	        account.setAccountNumber(form.getAccountNumber());
	        account.setIfscCode(form.getIfscCode());
	        account.setCurrentBalance(form.getCurrentBalance());
	        account.setPin(form.getPin());
	        account.setBankBranch(form.getBankBranch());
	        account.setUser(user); // important!

	        bankService.saveUser(account);
	    }
	    return "redirect:/dashboard"; // or wherever you want
	}
}
