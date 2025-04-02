package com.lohith.mypaymentwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lohith.mypaymentwebapp.entity.UserAccountDetailsEntity;

@Repository
public interface UserAccountDetailsRepository extends JpaRepository <UserAccountDetailsEntity,Integer>{
	
}
