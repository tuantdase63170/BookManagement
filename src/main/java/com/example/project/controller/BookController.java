package com.example.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.BookDTO;
import com.example.project.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {

	@Autowired
	private BookService service;

	// ### sort
	// 0 - No sort
	// 1 - Sort by book_id
	// 2 - Sort by catogory_id
	// 3 - Sort by title
	// 4 - Sort by author
	// 5 - Sort by price
	// 6 - Sort by amount
	// 7 - Sort by print_length
	// 8 - Sort by release_year
	// 9 - Sort by publisher
	// 10 - Sort by language_id
	// 11 - Sort by inserted_at
	// 12 - Sort by updated_at

	@GetMapping(value = "/all/{sort}")
	public ResponseEntity<List<BookDTO>> getAllBooks(@PathVariable(name = "sort") int sort) {
		ResponseEntity<List<BookDTO>> result = service.getBooks(null, 0, sort);
		return result;
	}
	// Tested

	@GetMapping(value = "/book_id={book_id}")
	public ResponseEntity<BookDTO> getBookByBookId(@PathVariable(name = "book_id") String book_id) {
		ResponseEntity<BookDTO> result = service.getBookById(book_id);
		return result;
	}
	// Tested

	@GetMapping(value = "/category_id={category_id}/{sort}")
	public ResponseEntity<List<BookDTO>> getBooksByCategoryId(@PathVariable(name = "category_id") String category_id,
			@PathVariable(name = "sort") int sort) {
		ResponseEntity<List<BookDTO>> result = service.getBooks(category_id, 1, sort);
		return result;
	}
	// Tested

	@GetMapping(value = "/title={title}/{sort}")
	public ResponseEntity<List<BookDTO>> getBooksByTitle(@PathVariable(name = "title") String title,
			@PathVariable(name = "sort") int sort) {
		ResponseEntity<List<BookDTO>> result = service.getBooks(title, 2, sort);
		return result;
	}
	// Tested

	@GetMapping(value = "/author={author}/{sort}")
	public ResponseEntity<List<BookDTO>> getBooksByAuthor(@PathVariable(name = "author") String author,
			@PathVariable(name = "sort") int sort) {
		ResponseEntity<List<BookDTO>> result = service.getBooks(author, 3, sort);
		return result;
	}
	// Tested

	@GetMapping(value = "/price={price}/{sort}")
	public ResponseEntity<List<BookDTO>> getBooksByPrice(@PathVariable(name = "price") String price,
			@PathVariable(name = "sort") int sort) {
		ResponseEntity<List<BookDTO>> result = service.getBooks(price, 4, sort);
		return result;
	}
	// Tested

	@GetMapping(value = "/amount={amount}/{sort}")
	public ResponseEntity<List<BookDTO>> getBooksByAmount(@PathVariable(name = "amount") String amount,
			@PathVariable(name = "sort") int sort) {
		ResponseEntity<List<BookDTO>> result = service.getBooks(amount, 5, sort);
		return result;
	}
	// Tested

	@GetMapping(value = "/print_length={print_length}/{sort}")
	public ResponseEntity<List<BookDTO>> getBooksByPrintLength(@PathVariable(name = "print_length") String print_length,
			@PathVariable(name = "sort") int sort) {
		ResponseEntity<List<BookDTO>> result = service.getBooks(print_length, 6, sort);
		return result;
	}
	// Tested

	@GetMapping(value = "/release_year={release_year}/{sort}")
	public ResponseEntity<List<BookDTO>> getBooksByReleaseYear(@PathVariable(name = "release_year") String release_year,
			@PathVariable(name = "sort") int sort) {
		ResponseEntity<List<BookDTO>> result = service.getBooks(release_year, 7, sort);
		return result;
	}
	// Tested

	@GetMapping(value = "/publisher={publisher}/{sort}")
	public ResponseEntity<List<BookDTO>> getBooksByPublisher(@PathVariable(name = "publisher") String publisher,
			@PathVariable(name = "sort") int sort) {
		ResponseEntity<List<BookDTO>> result = service.getBooks(publisher, 8, sort);
		return result;
	}
	// Tested

	@GetMapping(value = "/language_id={language_id}/{sort}")
	public ResponseEntity<List<BookDTO>> getBooksByLanguageId(@PathVariable(name = "language_id") String language_id,
			@PathVariable(name = "sort") int sort) {
		ResponseEntity<List<BookDTO>> result = service.getBooks(language_id, 9, sort);
		return result;
	}
	// Tested

	@GetMapping(value = "/inserted_at={inserted_at}/{sort}")
	public ResponseEntity<List<BookDTO>> getBooksByInsertedDate(@PathVariable(name = "inserted_at") String inserted_at,
			@PathVariable(name = "sort") int sort) {
		ResponseEntity<List<BookDTO>> result = service.getBooks(inserted_at, 10, sort);
		return result;
	}
	// Tested

	@GetMapping(value = "/updated_date={updated_date}/{sort}")
	public ResponseEntity<List<BookDTO>> getBooksByUpdatedDate(@PathVariable(name = "updated_date") String updated_date,
			@PathVariable(name = "sort") int sort) {
		ResponseEntity<List<BookDTO>> result = service.getBooks(updated_date, 11, sort);
		return result;
	}
	// Tested

}
