package com.lohith.mypaymentwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lohith.mypaymentwebapp.entity.SourceTypesEntity;

@Repository
public interface SourceTypesRepository extends JpaRepository<SourceTypesEntity,Long>{

}
