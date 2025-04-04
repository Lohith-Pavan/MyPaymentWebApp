package com.lohith.mypaymentwebapp.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lohith.mypaymentwebapp.entity.UserEntity;
import com.lohith.mypaymentwebapp.service.UserService;


@ Controller
public class WelcomeController {
//	@Autowired
//	public UserService userService;
//	@GetMapping("/userdetails")
//	public List<UserEntity> getAllUserDetails(){
//		System.out.println(userService.getAllUserDetails().size());
//		return userService.getAllUserDetails();
//	}
//	@RequestMapping("/testMethod")
//	public String testMethod() {
//		return "hello";
//	}
//	@GetMapping("/userdetails/{phoneNumber}")
//	public String getUserByPhoneNumber(@PathVariable String phoneNumber,Model model){
//		List<UserEntity> userList = new ArrayList<>();
//		UserEntity userByPh = userService.getUserByPhoneNumber(phoneNumber);
//		userList.add(userByPh);
//		model.addAttribute("user",userList);
//		return "details";
//	}
	@GetMapping("/welcome")
	public String welcome() {
		return "welcomepage";
	}
}

