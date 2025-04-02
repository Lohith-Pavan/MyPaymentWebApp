package com.lohith.mypaymentwebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lohith.mypaymentwebapp.entity.UserAccountDetailsEntity;
import com.lohith.mypaymentwebapp.repository.UserAccountDetailsRepository;

@Service
public class UserAccountDetailsService {
	@Autowired
	public UserAccountDetailsRepository userAccountDetailsRepository;
	public List<UserAccountDetailsEntity> getAllUserAccountDetails(){
		return userAccountDetailsRepository.findAll();
	}
}
