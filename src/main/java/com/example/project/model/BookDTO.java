package com.example.project.model;

public class BookDTO {

	private String bookId;
	private String categoryId;
	private String title;
	private String author;
	private float price;
	private int amount;
	private int printLength;
	private int releaseYear;
	private String publisher;
	private String description;
	private String languageId;
	private String insertedAt;
	private String updatedAt;

	public BookDTO() {
	}

	public BookDTO(String bookId, String categoryId, String title, String author, float price, int amount,
			int printLength, int releaseYear, String publisher, String description, String languageId,
			String insertedAt, String updatedAt) {
		this.bookId = bookId;
		this.categoryId = categoryId;
		this.title = title;
		this.author = author;
		this.price = price;
		this.amount = amount;
		this.printLength = printLength;
		this.releaseYear = releaseYear;
		this.publisher = publisher;
		this.description = description;
		this.languageId = languageId;
		this.insertedAt = insertedAt;
		this.updatedAt = updatedAt;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrintLength() {
		return printLength;
	}

	public void setPrintLength(int printLength) {
		this.printLength = printLength;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguageId() {
		return languageId;
	}

	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}

	public String getInsertedAt() {
		return insertedAt;
	}

	public void setInsertedAt(String insertedAt) {
		this.insertedAt = insertedAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

}
