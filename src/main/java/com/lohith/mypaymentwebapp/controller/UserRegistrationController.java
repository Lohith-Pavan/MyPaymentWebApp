package com.lohith.mypaymentwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lohith.mypaymentwebapp.entity.UserEntity;
import com.lohith.mypaymentwebapp.service.UserService;


@Controller
@RequestMapping("/")
public class UserRegistrationController {
	@Autowired
	public UserService userService;
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
    	model.addAttribute("user",new UserEntity());
    	return "registration";
    }
    @PostMapping("/register")
    public String saveUser(@ModelAttribute("user") UserEntity user) {
    	System.out.println("receiver user: "+ user);
    	userService.saveUser(user);
    	return "login";
    }
}
