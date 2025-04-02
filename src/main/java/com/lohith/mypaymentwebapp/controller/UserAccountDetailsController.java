package com.lohith.mypaymentwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.lohith.mypaymentwebapp.entity.UserAccountDetailsEntity;
import com.lohith.mypaymentwebapp.service.UserAccountDetailsService;

@Controller
public class UserAccountDetailsController {
	@Autowired
	public UserAccountDetailsService userAccountDetailsService;

	@GetMapping("/useraccountdetails")
	public List<UserAccountDetailsEntity> getAllUserAccountDetails() {
		for (UserAccountDetailsEntity x : userAccountDetailsService.getAllUserAccountDetails()) {
			System.out.println(x);
		}
		return userAccountDetailsService.getAllUserAccountDetails();
	}
}
