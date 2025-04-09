package com.lohith.mypaymentwebapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lohith.mypaymentwebapp.entity.BankAccountsEntity;
import com.lohith.mypaymentwebapp.entity.UserEntity;
import com.lohith.mypaymentwebapp.model.UserDashboardModel;
import com.lohith.mypaymentwebapp.model.UserProfileModel;
import com.lohith.mypaymentwebapp.model.UserViewBankModel;
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
		Optional<BankAccountsEntity> userBank = bankService.getUserBankById(userId);
		if (user.isPresent()) {
			UserEntity existedUser = user.get();
			BankAccountsEntity existedUserBank = userBank.orElse(null);
			UserDashboardModel userDashboardModel = new UserDashboardModel();
			UserProfileModel userProfileModel = new UserProfileModel();
			userProfileModel.setFirstName(existedUser.getFirstName());
			userProfileModel.setLastName(existedUser.getLastName());
			userProfileModel.setPhoneNumber(existedUser.getPhoneNumber());
			userProfileModel.setEmail(existedUser.getEmail());
			userProfileModel.setAddress(existedUser.getAddress());
			userDashboardModel.setUserProfileModel(userProfileModel);

			List<UserViewBankModel> banksList = new ArrayList<>();
			if (existedUserBank != null) {
				UserViewBankModel bank1 = new UserViewBankModel();
				bank1.setBankName(existedUserBank.getBankName());
				bank1.setAccountNumber(existedUserBank.getAccountNumber());
				bank1.setIfscCode(existedUserBank.getIfscCode());
				bank1.setCurrentBalance(existedUserBank.getCurrentBalance());
				bank1.setBankBranch(existedUserBank.getBankBranch());
				banksList.add(bank1);
			}
			userDashboardModel.setUserBanksListModel(banksList);

			model.addAttribute("userDashboardModel", userDashboardModel);
//		UserProfileModel userProfile = new UserProfileModel();
//		userProfile.setFirstName(existedUser.getFirstName());
//		userProfile.setLastName(existedUser.getLastName());
//		userProfile.setPhoneNumber(existedUser.getPhoneNumber());
//		userProfile.setEmail(existedUser.getEmail());
//		userProfile.setAddress(existedUser.getAddress());
//		model.addAttribute("userProfile", userProfile);
		}
		return "dashboard";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

}
