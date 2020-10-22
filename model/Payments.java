package com.model;

public class Payments {
	int paymentID;
	String paymentType;
	int isAllowed;

	public Payments(int paymentID, String paymentType, int isAllowed) {
		this.paymentID = paymentID;
		this.paymentType = paymentType;
		this.isAllowed = isAllowed;
	}

	public Payments() {
	}

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public int getIsAllowed() {
		return isAllowed;
	}

	public void setIsAllowed(int isAllowed) {
		this.isAllowed = isAllowed;
	}

	@Override
	public String toString() {
		return "Payments [paymentID=" + paymentID + ", paymentType=" + paymentType + ", isAllowed=" + isAllowed + "]";
	}

}
