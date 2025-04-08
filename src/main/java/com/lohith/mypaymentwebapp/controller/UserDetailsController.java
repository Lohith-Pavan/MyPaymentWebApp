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
import com.lohith.mypaymentwebapp.model.UserRegistrationModel;
import com.lohith.mypaymentwebapp.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class UserDetailsController {
	@Autowired
	public UserService userService;
    @GetMapping("/editprofilepage")
    public String editProfile(HttpSession session,Model model) {
    	Long userId = (Long)session.getAttribute("userId");
    	Optional<UserEntity> user = userService.getUserById(userId);
    	UserEntity existingUser = user.orElse(null);
    	UserRegistrationModel userEditProfile = new UserRegistrationModel();
    	userEditProfile.setFirstName(existingUser.getFirstName());
    	userEditProfile.setLastName(existingUser.getLastName());
    	userEditProfile.setPhoneNumber(existingUser.getPhoneNumber());
    	userEditProfile.setEmail(existingUser.getEmail());
    	userEditProfile.setAddress(existingUser.getAddress());
    	userEditProfile.setUserName(existingUser.getUserName());
    	userEditProfile.setPassword(existingUser.getPassword());
    	model.addAttribute("userEditProfile", userEditProfile);
    return "editprofilepage";
    }
    @PostMapping("/editprofilepage")
    public String updateProfile(@ModelAttribute UserRegistrationModel userRegModel,HttpSession session,Model model) {
    	Long userId = (Long)session.getAttribute("userId");
    	if (userId == null) {
    		return "redirect:/login";
    	}
    	userService.updateUserProfile(userId, userRegModel);
    	return "redirect:/dashboard";
    }
}
