package com.example.project.model;

public class CustomerDTO {

	private String customerId;
	private String email;
	private String phone;
	private String insertedAt;

	public CustomerDTO() {
	}

	public CustomerDTO(String customerId, String email, String phone, String insertedAt) {
		this.customerId = customerId;
		this.email = email;
		this.phone = phone;
		this.insertedAt = insertedAt;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getInsertedAt() {
		return insertedAt;
	}

	public void setInsertedAt(String insertedAt) {
		this.insertedAt = insertedAt;
	}

}
