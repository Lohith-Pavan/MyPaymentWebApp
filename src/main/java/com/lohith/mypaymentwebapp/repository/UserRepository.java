package com.lohith.mypaymentwebapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lohith.mypaymentwebapp.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository <UserEntity,Long>{
	 UserEntity findByPhoneNumber(String phoneNumber);
	 Optional<UserEntity> findByUserNameAndPassword(String userName,String password);
}