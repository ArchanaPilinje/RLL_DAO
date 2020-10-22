package com.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dao.PaymentsDAO;
import com.model.Payments;
import com.utility.ConnectionUtility;

public class PaymentsDAOImpl implements PaymentsDAO {

	@Override
	public int save(Payments pay) {
		try {
			PreparedStatement st1 = ConnectionUtility.getCon().prepareStatement("INSERT INTO payments values(?,?,?)");
			st1.setInt(1, pay.getPaymentID());
			st1.setString(2,pay.getPaymentType());
			st1.setInt(3,pay.getIsAllowed());
			
			return st1.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(int paymentID,int isAllowed) {
		try {
			String sqlUpdate = "UPDATE payments "
	                + "SET is_allowed = ? "
	                + "WHERE payment_id = ?";
			PreparedStatement st1 = ConnectionUtility.getCon().prepareStatement(sqlUpdate);
			st1.setInt(1,isAllowed);
			st1.setInt(2,paymentID);
			return st1.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int paymentID) {
		try {
			String sqlDelete = "DELETE from payments "
	                + "WHERE payment_id = ?";
			PreparedStatement st1 = ConnectionUtility.getCon().prepareStatement(sqlDelete);
			st1.setInt(1,paymentID);
			return st1.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<Payments> showAllPayments() {
		ArrayList<Payments> payment = new ArrayList<>();

		try {
			Statement st = ConnectionUtility.getCon().createStatement();
			ResultSet rs = st.executeQuery("SELECT * from payments");
			while (rs.next()) {
				Payments p = new Payments();
				p.setPaymentID(rs.getInt(1));
				p.setPaymentType(rs.getString(2));
				p.setIsAllowed(rs.getInt(3));
				payment.add(p);
			}
			return payment;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Payments showPaymentByID(int paymentID) {
		try {
			Payments p = new Payments();
			String sqlShow = "Select * from payments "
	                + "WHERE payment_id = ?";
			PreparedStatement st1 = ConnectionUtility.getCon().prepareStatement(sqlShow);
			st1.setInt(1,paymentID);
			ResultSet rs1=st1.executeQuery();
			while(rs1.next()){
				p.setPaymentID(rs1.getInt(1));
				p.setPaymentType(rs1.getString(2));
				p.setIsAllowed(rs1.getInt(3));
			}
			return p;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
