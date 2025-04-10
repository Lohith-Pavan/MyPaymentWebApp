package com.lohith.mypaymentwebapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lohith.mypaymentwebapp.entity.BankAccountsEntity;
import com.lohith.mypaymentwebapp.entity.UserEntity;

@Repository
public interface BankAccountsRepository extends JpaRepository<BankAccountsEntity,Long>{

}
