package com.lohith.mypaymentwebapp.entity;



import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="txn_details")
public class TransactionEntity {
		@Id
		@Column(name="txn_id")
		private long txnId;
		@Column(name="txn_date_time")
		private LocalDateTime txnDateTime;
		@Column(name="source_id")
		private int sourceId;
		@Column(name="target_id")
		private int targetId;
		@Column(name="source_type_code")
		private String sourceTypeCode;
		@Column(name="dest_type_code")
		private String destTypeCode;
		@Column(name="txn_amount")
		private double txnAmount;
		
		public long getTxnId() {
			return txnId;
		}
		public void setTxnId(long txnId) {
			this.txnId = txnId;
		}
		public LocalDateTime getTxnDateTime() {
			return txnDateTime;
		}
		public void setTxnDateTime(LocalDateTime txnDateTime) {
			this.txnDateTime = txnDateTime;
		}
		public int getSourceId() {
			return sourceId;
		}
		public void setSourceId(int sourceId) {
			this.sourceId = sourceId;
		}
		public int getTargetId() {
			return targetId;
		}
		public void setTargetId(int targetId) {
			this.targetId = targetId;
		}
		public String getSourceTypeCode() {
			return sourceTypeCode;
		}
		public void setSourceTypeCode(String sourceTypeCode) {
			this.sourceTypeCode = sourceTypeCode;
		}
		public String getDestTypeCode() {
			return destTypeCode;
		}
		public void setDestTypeCode(String destTypeCode) {
			this.destTypeCode = destTypeCode;
		}
		public double getTxnAmount() {
			return txnAmount;
		}
		public void setTxnAmount(double txnAmount) {
			this.txnAmount = txnAmount;
		}
		@Override
		public String toString() {
			return "TransactionEntity [txnId=" + txnId + ", txnDateTime=" + txnDateTime + ", sourceId=" + sourceId
					+ ", targetId=" + targetId + ", sourceTypeCode=" + sourceTypeCode + ", destTypeCode=" + destTypeCode
					+ ", txnAmount=" + txnAmount + "]";
		}
		
}
