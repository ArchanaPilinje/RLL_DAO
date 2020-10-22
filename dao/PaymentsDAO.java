package com.dao;

import java.util.ArrayList;

import com.model.Payments;



public interface PaymentsDAO {
	int save(Payments pay);

	int update(int paymentID,int isAllowed) ;

	int delete(int paymentID);

	ArrayList<Payments> showAllPayments();

	Payments showPaymentByID(int paymentID);
}
