package com.example.project.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.project.mapper.CustomerMapper;
import com.example.project.model.CustomerDTO;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerMapper mapper;

	@Override
	public ResponseEntity<List<CustomerDTO>> getAllCustomers(int sort) {
		if (sort < 0 || sort > 4) {
			return new ResponseEntity<List<CustomerDTO>>(HttpStatus.BAD_REQUEST);
		}
		List<CustomerDTO> result = mapper.getAllCustomers(sort);
		return new ResponseEntity<List<CustomerDTO>>(result, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<CustomerDTO> getCustomerByCustomerId(String customerId) {
		if (customerId.trim().length() != 36) {
			CustomerDTO result = null;
			return new ResponseEntity<CustomerDTO>(result, HttpStatus.OK);
		}
		CustomerDTO result = mapper.getCustomerById(customerId);
		return new ResponseEntity<CustomerDTO>(result, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<CustomerDTO>> getCustomersByEmail(String email, int sort) {
		if (sort < 0 || sort > 4) {
			return new ResponseEntity<List<CustomerDTO>>(HttpStatus.BAD_REQUEST);
		}
		if (email.trim().length() ==0) {
			return new ResponseEntity<List<CustomerDTO>>(new ArrayList<>(), HttpStatus.OK);
		}
		List<CustomerDTO> result = mapper.getCustomersByEmail(email, sort);
		return new ResponseEntity<List<CustomerDTO>>(result, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<CustomerDTO>> getCustomersByPhone(String phone, int sort) {
		if (sort < 0 || sort > 4) {
			return new ResponseEntity<List<CustomerDTO>>(HttpStatus.BAD_REQUEST);
		}
		if (phone.trim().length() ==0) {
			return new ResponseEntity<List<CustomerDTO>>(new ArrayList<>(), HttpStatus.OK);
		}
		List<CustomerDTO> result = mapper.getCustomersByPhone(phone, sort);
		return new ResponseEntity<List<CustomerDTO>>(result, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<CustomerDTO>> getCustomersByInsertedAt(String insertedAt, int sort) {
		if (sort < 0 || sort > 4) {
			return new ResponseEntity<List<CustomerDTO>>(HttpStatus.BAD_REQUEST);
		}
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			format.parse(insertedAt);
			insertedAt = insertedAt.substring(0, 4) + "-" + insertedAt.substring(4, 6) + "-" + insertedAt.substring(6);
		} catch (ParseException e) {
			return new ResponseEntity<List<CustomerDTO>>(new ArrayList<>(), HttpStatus.OK);
		}
		List<CustomerDTO> result = mapper.getCustomersByInsertedAt(insertedAt, sort);
		return new ResponseEntity<List<CustomerDTO>>(result, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Integer> getTotalCustomers() {
		int result = mapper.getTotalCustomers();
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

}
