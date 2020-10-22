package com.model;

public class Category {
	int categoryId;
	String categoryName;
	String description;
	int isActive;

	public Category(int categoryId, String categoryName, String description, int isActive) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.description = description;
		this.isActive = isActive;
	}

	public Category() {
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", description=" + description
				+ ", isActive=" + isActive + "]";
	}

}
