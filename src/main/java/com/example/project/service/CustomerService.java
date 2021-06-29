package com.example.project.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.project.model.CustomerDTO;

public interface CustomerService {

	ResponseEntity<List<CustomerDTO>> getAllCustomers(int sort);
	
	ResponseEntity<CustomerDTO> getCustomerByCustomerId(String customerId);
	
	ResponseEntity<List<CustomerDTO>> getCustomersByEmail(String email, int sort);
	
	ResponseEntity<List<CustomerDTO>> getCustomersByPhone(String phone, int sort);
	
	ResponseEntity<List<CustomerDTO>> getCustomersByInsertedAt(String insertedAt, int sort);

}
