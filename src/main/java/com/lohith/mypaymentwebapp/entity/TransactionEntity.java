package com.lohith.mypaymentwebapp.entity;



import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="txn_details")
public class TransactionEntity {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="txn_id")
		private Long txnId;
		@Column(name="txn_date_time")
		private LocalDateTime txnDateTime;
		@Column(name="source_id")
		private Long sourceId;
		@Column(name="target__id")
		private Long targetId;
		@ManyToOne
		@JoinColumn(name="source_type_id",referencedColumnName="source_id")
		private SourceTypeEntity sourceType;
		@ManyToOne
		@JoinColumn(name="destination_type_id",referencedColumnName="source_id")
		private SourceTypeEntity destType;
		@Column(name="txn_amount")
		private double txnAmount;
		@ManyToOne
		@JoinColumn(name="user_id")
		private UserEntity user;
		public Long getTxnId() {
			return txnId;
		}
		public void setTxnId(Long txnId) {
			this.txnId = txnId;
		}
		public LocalDateTime getTxnDateTime() {
			return txnDateTime;
		}
		public void setTxnDateTime(LocalDateTime txnDateTime) {
			this.txnDateTime = txnDateTime;
		}
		public Long getSourceId() {
			return sourceId;
		}
		public void setSourceId(Long sourceId) {
			this.sourceId = sourceId;
		}
		public Long getTargetId() {
			return targetId;
		}
		public void setTargetId(Long targetId) {
			this.targetId = targetId;
		}
		public SourceTypeEntity getSourceType() {
			return sourceType;
		}
		public void setSourceType(SourceTypeEntity sourceType) {
			this.sourceType = sourceType;
		}
		public SourceTypeEntity getDestType() {
			return destType;
		}
		public void setDestType(SourceTypeEntity destType) {
			this.destType = destType;
		}
		public double getTxnAmount() {
			return txnAmount;
		}
		public void setTxnAmount(double txnAmount) {
			this.txnAmount = txnAmount;
		}
		public UserEntity getUser() {
			return user;
		}
		public void setUser(UserEntity user) {
			this.user = user;
		}
		@Override
		public String toString() {
			return "TransactionEntity [txnId=" + txnId + ", txnDateTime=" + txnDateTime + ", sourceId=" + sourceId
					+ ", targetId=" + targetId + ", sourceType=" + sourceType + ", destType=" + destType
					+ ", txnAmount=" + txnAmount + "]";
		}
}
