package com.lohith.mypaymentwebapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lohith.mypaymentwebapp.entity.BankAccountsEntity;
import com.lohith.mypaymentwebapp.entity.UserEntity;
import com.lohith.mypaymentwebapp.model.UserDashboardModel;
import com.lohith.mypaymentwebapp.model.UserProfileModel;
import com.lohith.mypaymentwebapp.service.BankService;
import com.lohith.mypaymentwebapp.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserDashboardController {
	@Autowired
	public UserService userService;
	public BankService bankService;
	@GetMapping("/dashboard")
	public String loadprofilepage(HttpSession session,Model model) {
		Long userId = (Long)session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/login";
		}
		Optional<UserEntity> user = userService.getUserById(userId);
		Optional<BankAccountsEntity> userBank = bankService.getUserBankById(userId);
		UserEntity existedUser = user.orElse(null);
		BankAccountsEntity existedUserBank = userBank.orElse(null);
		UserDashboardModel userDashboardModel = new UserDashboardModel();
		userDashboardModel.getUserProfileModel().setFirstName(existedUser.getFirstName());
		userDashboardModel.getUserProfileModel().setLastName(existedUser.getLastName());
		userDashboardModel.getUserProfileModel().setPhoneNumber(existedUser.getPhoneNumber());
		userDashboardModel.getUserProfileModel().setEmail(existedUser.getEmail());
		userDashboardModel.getUserProfileModel().setAddress(existedUser.getAddress());
//		UserProfileModel userProfile = new UserProfileModel();
//		userProfile.setFirstName(existedUser.getFirstName());
//		userProfile.setLastName(existedUser.getLastName());
//		userProfile.setPhoneNumber(existedUser.getPhoneNumber());
//		userProfile.setEmail(existedUser.getEmail());
//		userProfile.setAddress(existedUser.getAddress());
//		model.addAttribute("userProfile", userProfile);
		return "dashboard";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
}
