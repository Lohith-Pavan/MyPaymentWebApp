package com.lohith.mypaymentwebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lohith.mypaymentwebapp.entity.SourceTypeEntity;
import com.lohith.mypaymentwebapp.repository.SourceTypeRepository;

@Service
public class SourceTypeService {
	@Autowired
	public SourceTypeRepository sourceTypeRepo;
	public SourceTypeEntity findBySourceTypeCode(String sourceTypeCode) {
		return sourceTypeRepo.findBySourceTypeCode(sourceTypeCode);
	}
}
