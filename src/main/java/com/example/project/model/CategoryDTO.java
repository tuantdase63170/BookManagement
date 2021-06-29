package com.example.project.model;

public class CategoryDTO {

	private String categoryId;
	private String categoryName;
	private boolean isActived;

	public CategoryDTO() {
	}

	public CategoryDTO(String categoryId, String categoryName, boolean isActived) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.isActived = isActived;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public boolean isActived() {
		return isActived;
	}

	public void setActived(boolean isActived) {
		this.isActived = isActived;
	}

}
