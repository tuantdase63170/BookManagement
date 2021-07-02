package com.example.project.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.project.model.BookDTO;

public interface BookService {

	ResponseEntity<BookDTO> getBookById(String bookId);

	ResponseEntity<List<BookDTO>> getBooks(String searchValue, int column, int sort);

}
