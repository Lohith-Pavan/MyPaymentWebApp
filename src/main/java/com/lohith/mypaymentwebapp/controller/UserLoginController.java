package com.lohith.mypaymentwebapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lohith.mypaymentwebapp.entity.UserEntity;
import com.lohith.mypaymentwebapp.model.UserLoginModel;
import com.lohith.mypaymentwebapp.model.UserIdModel;
import com.lohith.mypaymentwebapp.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class UserLoginController {
	@Autowired
	public UserService userService;
	@GetMapping("/login")
	public String showloginpage() {
		return "login";
	}
	@PostMapping("/login")
	public String login(@ModelAttribute UserLoginModel userLoginModel,HttpSession session,Model model) {
		Optional<UserEntity> existingUser = userService.authenticateUser(userLoginModel.getUserName(),userLoginModel.getPassword());
		System.out.println("user" + existingUser);
		if(existingUser.isPresent()) {
//			UserProfileModel user = new UserProfileModel();
//			user.setUserId(existingUser.get().getUserId());
//			user.setFirstName(existingUser.getFirstName());
//			user.setLastName(existingUser.getLastName());
//			user.setPhoneNumber(existingUser.getPhoneNumber());
//			user.setEmail(existingUser.getEmail());
//			user.setAddress(existingUser.getAddress());
//			user.setUserName(existingUser.getUserName());
//			user.setPassword(existingUser.getPassword());
			session.setAttribute("userId",existingUser.get().getUserId());
//			model.addAttribute("user",user);
			return "redirect:/dashboard";
		}
		else {
			model.addAttribute("error","There is no user with this credentials");
			return "login";
		}
	}
	
}
