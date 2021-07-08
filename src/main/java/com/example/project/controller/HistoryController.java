package com.example.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.HistoryDTO;
import com.example.project.service.HistoryService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/history")
public class HistoryController {

	@Autowired
	private HistoryService service;

	// ### sort
	// 0 - No sort
	// 1 - Sort by history_id
	// 2 - Sort by book_id
	// 3 - Sort by amount
	// 4 - Sort by customer_id
	// 5 - Sort by manager_username
	// 6 - Sort by borrow_date
	// 7 - Sort by return_date

	@GetMapping(value = "/all/{sort}")
	public ResponseEntity<List<HistoryDTO>> getAllHistories(@PathVariable(name = "sort") int sort) {
		ResponseEntity<List<HistoryDTO>> result = service.getAllHistories(sort);
		return result;
	}
	// Tested

	@GetMapping(value = "/history_id={history_id}")
	public ResponseEntity<HistoryDTO> getHistoryByHistoryId(@PathVariable(name = "history_id") String history_id) {
		ResponseEntity<HistoryDTO> result = service.getHistoryByHistoryId(history_id);
		return result;
	}
	// Tested

	@GetMapping(value = "/book_id={book_id}/{sort}")
	public ResponseEntity<List<HistoryDTO>> getHistoriesByBookId(@PathVariable(name = "book_id") String book_id,
			@PathVariable(name = "sort") int sort) {
		ResponseEntity<List<HistoryDTO>> result = service.getHistories(book_id, 0, sort);
		return result;
	}
	// Tested

	@GetMapping(value = "/amount={amount}/{sort}")
	public ResponseEntity<List<HistoryDTO>> getHistoriesByAmount(@PathVariable(name = "amount") String amount,
			@PathVariable(name = "sort") int sort) {
		ResponseEntity<List<HistoryDTO>> result = service.getHistories(amount, 1, sort);
		return result;
	}
	// Tested

	@GetMapping(value = "/customer_id={customer_id}/{sort}")
	public ResponseEntity<List<HistoryDTO>> getHistoriesByCustomerId(
			@PathVariable(name = "customer_id") String customer_id, @PathVariable(name = "sort") int sort) {
		ResponseEntity<List<HistoryDTO>> result = service.getHistories(customer_id, 2, sort);
		return result;
	}
	// Tested

	@GetMapping(value = "/manager_username={manager_username}/{sort}")
	public ResponseEntity<List<HistoryDTO>> getHistoriesByManagerUsername(
			@PathVariable(name = "manager_username") String manager_username, @PathVariable(name = "sort") int sort) {
		ResponseEntity<List<HistoryDTO>> result = service.getHistories(manager_username, 3, sort);
		return result;
	}
	// Tested

	@GetMapping(value = "/borrow_date={borrow_date}/{sort}")
	public ResponseEntity<List<HistoryDTO>> getHistoriesByBorrowDate(
			@PathVariable(name = "borrow_date") String borrow_date, @PathVariable(name = "sort") int sort) {
		ResponseEntity<List<HistoryDTO>> result = service.getHistories(borrow_date, 4, sort);
		return result;
	}
	// Tested

	@GetMapping(value = "/return_date={return_date}/{sort}")
	public ResponseEntity<List<HistoryDTO>> getHistoriesByReturnDate(
			@PathVariable(name = "return_date") String return_date, @PathVariable(name = "sort") int sort) {
		ResponseEntity<List<HistoryDTO>> result = service.getHistories(return_date, 5, sort);
		return result;
	}
	// Tested

	@GetMapping(value = "/count")
	public ResponseEntity<Integer> getTotalHistories() {
		ResponseEntity<Integer> result = service.getTotalHistories();
		return result;
	}
	// Tested

}
