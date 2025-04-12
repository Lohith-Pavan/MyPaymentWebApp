package com.lohith.mypaymentwebapp.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="source_types")
public class SourceTypeEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="source_id")
	private int sourceId;
	@Column(name="source_type_code",unique=true)
	private String sourceTypeCode;
	@Column(name="source_type_name")
	private String sourceTypeName;
	@OneToMany(mappedBy="sourceType")
	private List<TransactionEntity> sourceTransactions;
	@OneToMany(mappedBy="destType")
	private List<TransactionEntity> destTransactions;
	public int getSourceId() {
		return sourceId;
	}
	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}
	public String getSourceTypeCode() {
		return sourceTypeCode;
	}
	public void setSourceTypeCode(String sourceTypeCode) {
		this.sourceTypeCode = sourceTypeCode;
	}
	public String getSourceTypeName() {
		return sourceTypeName;
	}
	public void setSourceTypeName(String sourceTypeName) {
		this.sourceTypeName = sourceTypeName;
	}
	public List<TransactionEntity> getSourceTransactions() {
		return sourceTransactions;
	}
	public void setSourceTransactions(List<TransactionEntity> sourceTransactions) {
		this.sourceTransactions = sourceTransactions;
	}
	public List<TransactionEntity> getDestTransactions() {
		return destTransactions;
	}
	public void setDestTransactions(List<TransactionEntity> destTransactions) {
		this.destTransactions = destTransactions;
	}
	
	
}
