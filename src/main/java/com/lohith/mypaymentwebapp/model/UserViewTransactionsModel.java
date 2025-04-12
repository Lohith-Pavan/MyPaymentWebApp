package com.lohith.mypaymentwebapp.model;

import java.time.LocalDateTime;

public class UserViewTransactionsModel {
	private Long txnId;
	private LocalDateTime date;
	private String sender;
	private String receiver;
	private String sourceType;
	private String destType;
	private double amount;
	public Long getTxnId() {
		return txnId;
	}
	public void setTxnId(Long txnId) {
		this.txnId = txnId;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getSourceType() {
		return sourceType;
	}
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
	public String getDestType() {
		return destType;
	}
	public void setDestType(String destType) {
		this.destType = destType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
