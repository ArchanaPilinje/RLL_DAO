package com.dao;

import java.util.ArrayList;

import com.model.Category;

public interface CategoryDAO {
	int save(Category cat);

	int update(int categoryID,int isActive);

	int delete(int categoryID);

	ArrayList<Category> showAllCategory();

	Category showCategoryByID(int categoryID);

}
