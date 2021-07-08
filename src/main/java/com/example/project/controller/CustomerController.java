package com.example.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.CustomerDTO;
import com.example.project.service.CustomerService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;

	// ### sort
	// 0 - No sort
	// 1 - Sort by id
	// 2 - Sort by email
	// 3 - Sort by phone
	// 4 - Sort by inserted date

	@GetMapping(value = "/all/{sort}")
	public ResponseEntity<List<CustomerDTO>> getAllCustomers(@PathVariable(name = "sort") int sort) {
		ResponseEntity<List<CustomerDTO>> result = service.getAllCustomers(sort);
		return result;
	}
	// Tested

	@GetMapping(value = "/customer_id={customer_id}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable(name = "customer_id") String customer_id) {
		ResponseEntity<CustomerDTO> result = service.getCustomerByCustomerId(customer_id);
		return result;
	}
	// Tested

	@GetMapping(value = "/email={email}/{sort}")
	public ResponseEntity<List<CustomerDTO>> getCustomersByEmail(@PathVariable(name = "email") String email,
			@PathVariable(name = "sort") int sort) {
		ResponseEntity<List<CustomerDTO>> result = service.getCustomersByEmail(email, sort);
		return result;
	}
	// Tested

	@GetMapping(value = "/phone={phone}/{sort}")
	public ResponseEntity<List<CustomerDTO>> getCustomersByPhone(@PathVariable(name = "phone") String phone,
			@PathVariable(name = "sort") int sort) {
		ResponseEntity<List<CustomerDTO>> result = service.getCustomersByPhone(phone, sort);
		return result;
	}
	// Tested

	@GetMapping(value = "/inserted_at={inserted_at}/{sort}")
	public ResponseEntity<List<CustomerDTO>> getCustomersByInsertedDate(
			@PathVariable(name = "inserted_at") String inserted_at, @PathVariable(name = "sort") int sort) {
		ResponseEntity<List<CustomerDTO>> result = service.getCustomersByInsertedAt(inserted_at, sort);
		return result;
	}
	// Tested
	
	@GetMapping(value = "/count")
	public ResponseEntity<Integer> getTotalCustomers() {
		ResponseEntity<Integer> result = service.getTotalCustomers();
		return result;
	}
	// Tested

}
