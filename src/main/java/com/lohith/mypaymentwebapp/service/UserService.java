package com.lohith.mypaymentwebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lohith.mypaymentwebapp.entity.UserEntity;
import com.lohith.mypaymentwebapp.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	public UserRepository userRepo;
	public List<UserEntity> getAllUserDetails(){
		return userRepo.findAll();
	}
	public UserEntity getUserByPhoneNumber(String phoneNumber){
		return userRepo.findByPhoneNumber(phoneNumber);
	}
}