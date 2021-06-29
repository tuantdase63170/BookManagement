package com.example.project.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.project.mapper.BookMapper;
import com.example.project.model.BookDTO;

@Service
public class BookServiceImp implements BookService {

	@Autowired
	private BookMapper mapper;

	@Override
	public ResponseEntity<BookDTO> getBookById(String bookId, int sort) {
		if (bookId.trim().length() != 36) {
			return null;
		}
		BookDTO result = mapper.getBookById(bookId, sort);
		return new ResponseEntity<BookDTO>(result, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<BookDTO>> getBooks(String searchValue, int column, int sort) {
		if (sort < 0 || sort > 12) {
			return new ResponseEntity<List<BookDTO>>(HttpStatus.BAD_REQUEST);
		}
		switch (column) {
		case 0:
			break;
		case 1:
			if (searchValue.trim().length() != 36) {
				return new ResponseEntity<List<BookDTO>>(new ArrayList<>(), HttpStatus.OK);
			}
			break;
		case 2:
			if (searchValue.trim().length() == 0) {
				return new ResponseEntity<List<BookDTO>>(new ArrayList<>(), HttpStatus.OK);
			}
			break;
		case 3:
			if (searchValue.trim().length() == 0) {
				return new ResponseEntity<List<BookDTO>>(new ArrayList<>(), HttpStatus.OK);
			}
			break;
		case 4:
			try {
				Float.parseFloat(searchValue);
			} catch (NumberFormatException e) {
				return new ResponseEntity<List<BookDTO>>(new ArrayList<>(), HttpStatus.OK);
			}
			break;
		case 5:
			try {
				Integer.parseInt(searchValue);
			} catch (NumberFormatException e) {
				return new ResponseEntity<List<BookDTO>>(new ArrayList<>(), HttpStatus.OK);
			}
			break;
		case 6:
			try {
				Integer.parseInt(searchValue);
			} catch (NumberFormatException e) {
				return new ResponseEntity<List<BookDTO>>(new ArrayList<>(), HttpStatus.OK);
			}
			break;
		case 7:
			try {
				Integer.parseInt(searchValue);
			} catch (NumberFormatException e) {
				return new ResponseEntity<List<BookDTO>>(new ArrayList<>(), HttpStatus.OK);
			}
			break;
		case 8:
			if (searchValue.length() == 0) {
				return new ResponseEntity<List<BookDTO>>(new ArrayList<>(), HttpStatus.OK);
			}
			break;
		case 9:
			if (searchValue.trim().length() != 36) {
				return new ResponseEntity<List<BookDTO>>(new ArrayList<>(), HttpStatus.OK);
			}
			break;
		case 10:
			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				format.parse(searchValue);
				searchValue = searchValue.substring(0, 4) + "-" + searchValue.substring(4, 6) + "-"
						+ searchValue.substring(6);
			} catch (ParseException e) {
				return new ResponseEntity<List<BookDTO>>(new ArrayList<>(), HttpStatus.OK);
			}
			break;
		case 11:
			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				format.parse(searchValue);
				searchValue = searchValue.substring(0, 4) + "-" + searchValue.substring(4, 6) + "-"
						+ searchValue.substring(6);
			} catch (ParseException e) {
				return new ResponseEntity<List<BookDTO>>(new ArrayList<>(), HttpStatus.OK);
			}
			break;
		default:
			break;
		}
		try {
			List<BookDTO> result = mapper.getBooks(searchValue, column, sort);
			return new ResponseEntity<List<BookDTO>>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<BookDTO>>(new ArrayList<>(), HttpStatus.OK);
		}
	}

}
