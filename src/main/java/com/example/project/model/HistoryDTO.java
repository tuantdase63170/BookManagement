package com.example.project.model;

public class HistoryDTO {

	private String historyId;
	private String bookId;
	private int amount;
	private String customerId;
	private String managerUsername;
	private String borrowDate;
	private String returnDate;

	public HistoryDTO() {
	}

	public HistoryDTO(String historyId, String bookId, int amount, String customerId, String managerUsername,
			String borrowDate, String returnDate) {
		this.historyId = historyId;
		this.bookId = bookId;
		this.amount = amount;
		this.customerId = customerId;
		this.managerUsername = managerUsername;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}

	public String getHistoryId() {
		return historyId;
	}

	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getManagerUsername() {
		return managerUsername;
	}

	public void setManagerUsername(String managerUsername) {
		this.managerUsername = managerUsername;
	}

	public String getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

}
