package com.lohith.mypaymentwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lohith.mypaymentwebapp.entity.TransactionEntity;

@Repository
public interface TransactionRepository extends JpaRepository <TransactionEntity,Long>{

}
