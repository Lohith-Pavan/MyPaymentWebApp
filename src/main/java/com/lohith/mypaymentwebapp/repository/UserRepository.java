package com.lohith.mypaymentwebapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lohith.mypaymentwebapp.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository <UserEntity,Integer>{
	public UserEntity findByPhoneNumber(String phoneNumber);
}