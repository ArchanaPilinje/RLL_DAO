package com.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dao.CategoryDAO;
import com.model.Category;

import com.utility.ConnectionUtility;

public class CategoryDAOImpl implements CategoryDAO  {

	@Override
	public int save(Category cat) {
		try {
			PreparedStatement st1 = ConnectionUtility.getCon().prepareStatement("INSERT INTO category values(?,?,?,?)");
			st1.setInt(1, cat.getCategoryId());
			st1.setString(2,cat.getCategoryName());
			st1.setString(3,cat.getDescription());
			st1.setInt(4,cat.getIsActive());
			
			return st1.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(int categoryID,int isActive) {
		try {
			String sqlUpdate = "UPDATE category "
	                + "SET is_active = ? "
	                + "WHERE category_id = ?";
			PreparedStatement st1 = ConnectionUtility.getCon().prepareStatement(sqlUpdate);
			st1.setInt(1,isActive);
			st1.setInt(2,categoryID);
			return st1.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int categoryID) {
		try {
			String sqlDelete = "DELETE from category "
	                + "WHERE category_id = ?";
			PreparedStatement st1 = ConnectionUtility.getCon().prepareStatement(sqlDelete);
			st1.setInt(1,categoryID);
			return st1.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<Category> showAllCategory() {
		ArrayList<Category> category = new ArrayList<>();

		try {
			Statement st = ConnectionUtility.getCon().createStatement();
			ResultSet rs = st.executeQuery("SELECT * from category");
			while (rs.next()) {
				Category c = new Category();
				c.setCategoryId(rs.getInt(1));
				c.setCategoryName(rs.getString(2));
				c.setDescription(rs.getString(3));
				c.setIsActive(rs.getInt(4));
				category.add(c);
			}
			return category;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Category showCategoryByID(int categoryID) {
		try {
			Category c= new Category();
			String sqlShow = "Select * from category "
	                + "WHERE category_id = ?";
			PreparedStatement st1 = ConnectionUtility.getCon().prepareStatement(sqlShow);
			st1.setInt(1,categoryID);
			ResultSet rs1=st1.executeQuery();
			while(rs1.next()){
				c.setCategoryId(rs1.getInt(1));
				c.setCategoryName(rs1.getString(2));
				c.setDescription(rs1.getString(3));
				c.setIsActive(rs1.getInt(4));
			}
			return c;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
