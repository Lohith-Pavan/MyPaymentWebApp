package com.lohith.mypaymentwebapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="source_types")
public class SourceTypesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="source_id")
	private long sourceId;
	@Column(name="source_type_code")
	private String sourceTypeCode;
	@Column(name="source_type_name")
	private String sourceTypeName;
	public long getSourceId() {
		return sourceId;
	}
	public void setSourceId(long sourceId) {
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
	@Override
	public String toString() {
		return "SourceTypesEntity [sourceId=" + sourceId + ", sourceTypeCode=" + sourceTypeCode + ", sourceTypeName="
				+ sourceTypeName + "]";
	}
	
}
