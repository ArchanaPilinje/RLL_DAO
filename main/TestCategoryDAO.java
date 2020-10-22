package com.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.dao.impl.CategoryDAOImpl;
import com.model.Category;

public class TestCategoryDAO {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CategoryDAOImpl cat = new CategoryDAOImpl();
		int flag = 0;
		do {
			System.out.println("Choose from any one of the following options");
			System.out.println(
					"1.Insert a new Category  2.Update isActive field  3.Delete  4.Show All Category  5.Show Details of a particular Category");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter the CategoryID,Category Name,Category Description and isActive");
				Category c = new Category();
				c.setCategoryId(sc.nextInt());
				sc.nextLine();
				c.setCategoryName(sc.nextLine());
				c.setDescription(sc.nextLine());
				c.setIsActive(sc.nextInt());
				int res = cat.save(c);
				System.out.println("Rows updated :" + res);
				break;

			case 2:
				System.out.println("Enter the CategoryID and new isActive value(It should be 0/1)");
				int categoryId = sc.nextInt();
				int isActive = sc.nextInt();
				int res1 = cat.update(categoryId, isActive);
				System.out.println("Rows updated :" + res1);
				break;

			case 3:
				System.out.println("Enter the CategoryID to be deleted");
				int res2 = cat.delete(sc.nextInt());
				System.out.println("Rows updated :" + res2);
				break;

			case 4:
				ArrayList<Category> category = new ArrayList<>();
				category = cat.showAllCategory();
				for (Category x : category) {
					System.out.println(x);
				}
				break;
			case 5:
				System.out.println("Enter the category_id to be shown");
				Category c5 = cat.showCategoryByID(sc.nextInt());
				System.out.println(c5);
				break;

			}
			System.out.println("Press the Corresponding option:\n1.Continue 0. Exit");
			flag = sc.nextInt();
		} while (flag == 1);

	}

}
