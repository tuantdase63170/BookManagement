package com.example.project.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.project.model.BookDTO;

public interface BookService {

	ResponseEntity<BookDTO> getBookById(String bookId);

	ResponseEntity<List<BookDTO>> getBooks(String searchValue, int column, int sort);

	ResponseEntity<List<BookDTO>> getBooksByAttributes(String title, String releaseYear, String languageId,
			String categoryId, String minPrice, String maxPrice, int sort);
	
	ResponseEntity<Integer> getTotalBooks();

}
