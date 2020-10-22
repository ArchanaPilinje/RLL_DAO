package com.main;

import java.util.ArrayList;
import java.util.Scanner;


import com.dao.impl.PaymentsDAOImpl;

import com.model.Payments;

public class TestPaymentsDAO {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PaymentsDAOImpl pay = new PaymentsDAOImpl();
		int flag = 0;
		do {
		System.out.println("Choose from any one of the following options");
		System.out.println(
				"1.Insert a new Payment  2.Update isAllowed field  3.Delete  4.Show All Payments  5.Show Details of a particular Payment");
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			System.out.println("Enter the PaymentID,Payment Type and isAllowed(0/1)");
			Payments p= new Payments();
			p.setPaymentID(sc.nextInt());
			sc.nextLine();
			p.setPaymentType(sc.nextLine());
			p.setIsAllowed(sc.nextInt());
			int res = pay.save(p);
			System.out.println("Rows updated :" + res);
			break;
			
		case 2:
			System.out.println("Enter the PaymentID and new isAllowed value(It should be 0/1)");
			int paymentId = sc.nextInt();
			int isAllowed = sc.nextInt();
			int res1 = pay.update(paymentId, isAllowed);
			System.out.println("Rows updated :" + res1);
			break;
			
		case 3:
			System.out.println("Enter the PaymentID to be deleted");
			int res2 = pay.delete(sc.nextInt());
			System.out.println("Rows updated :" + res2);
			break;
		
		case 4:
			ArrayList<Payments> payment = new ArrayList<>();
			payment = pay.showAllPayments();
			for (Payments x : payment) {
				System.out.println(x);
			}
			break;
			
		case 5:
			System.out.println("Enter the payment_id to be shown");
			Payments c5 = pay.showPaymentByID(sc.nextInt());
			System.out.println(c5);
			break;
		}
		System.out.println("Press the Corresponding option:\n1.Continue 0. Exit");
		flag = sc.nextInt();
	} while (flag == 1);

	}

}
