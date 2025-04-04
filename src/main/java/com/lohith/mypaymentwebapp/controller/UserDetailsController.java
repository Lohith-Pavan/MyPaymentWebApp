package com.lohith.mypaymentwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lohith.mypaymentwebapp.model.UserRegistrationModel;



@Controller
@RequestMapping("/")
public class UserDetailsController {
     @GetMapping("/editprofilepage")
     public String editprofile(Model model) {
    	 UserRegistrationModel userRegModel = new UserRegistrationModel();
    	 model.addAttribute("userRegModel", userRegModel);
    	 return "editprofilepage";
     }
}
