package com.lohith.mypaymentwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lohith.mypaymentwebapp.entity.BankAccountsEntity;

@Repository
public interface BankAccountsRepository extends JpaRepository<BankAccountsEntity,Long>{
    
}
