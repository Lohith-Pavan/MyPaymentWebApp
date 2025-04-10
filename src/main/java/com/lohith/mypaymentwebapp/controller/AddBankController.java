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
	@GetMapping("/addbankaccount")
	public String showAddBankAccountPage() {
		return "addbankaccount";
	}
	@PostMapping("/addbankaccount")
	public String addBankAccount(@ModelAttribute UserBankModel bankDetails,HttpSession session,Model model) {
	    Long userId = (Long)session.getAttribute("userId"); 
	    if(userId == null) {
	    	return "redirect:/login";
	    }
	    Optional<UserEntity> user = userService.getUserById(userId);
	    if(user.isPresent()) {
	    	UserEntity existingUser = user.get();
	    	UserAddBankModel userAddBankModel = bankDetails.getUserAddBankModel();
	    	BankAccountsEntity bankEntity = new BankAccountsEntity();
	    	bankEntity.setBankName(userAddBankModel.getBankName());
	    	bankEntity.setAccountNumber(userAddBankModel.getAccountNumber());
	    	bankEntity.setIfscCode(userAddBankModel.getIfscCode());
	    	bankEntity.setCurrentBalance(userAddBankModel.getCurrentBalance());
	    	bankEntity.setPin(userAddBankModel.getPin());
	    	bankEntity.setBankBranch(userAddBankModel.getBankBranch());
	    	bankEntity.setAccountStatus(userAddBankModel.getAccountStatus());
	    	bankEntity.setUser(existingUser);
	    	existingUser.getBankAccounts().add(bankEntity);
	    	userService.saveUser(existingUser);
	    }
	   	return "redirect:/dashboard";
	}
}
