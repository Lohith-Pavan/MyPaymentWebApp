package com.lohith.mypaymentwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lohith.mypaymentwebapp.entity.SourceTypeEntity;

@Repository
public interface SourceTypeRepository extends JpaRepository<SourceTypeEntity,Integer>{
	public SourceTypeEntity findBySourceTypeCode(String sourceTypeCode);
}
