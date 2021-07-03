package com.example.project.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.project.mapper.HistoryMapper;
import com.example.project.model.HistoryDTO;

@Service
public class HistoryServiceImp implements HistoryService {

	@Autowired
	private HistoryMapper mapper;

	@Override
	public ResponseEntity<List<HistoryDTO>> getAllHistories(int sort) {
		if (sort < 0 || sort > 7) {
			return new ResponseEntity<List<HistoryDTO>>(HttpStatus.BAD_REQUEST);
		}
		List<HistoryDTO> result = mapper.getAllHistories(sort);
		return new ResponseEntity<List<HistoryDTO>>(result, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<HistoryDTO> getHistoryByHistoryId(String historyId) {
		HistoryDTO result = null;
		if (historyId.trim().length() != 36) {
			return new ResponseEntity<HistoryDTO>(result, HttpStatus.OK);
		}
		result = mapper.getHistoryByHistoryId(historyId);
		return new ResponseEntity<HistoryDTO>(result, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<HistoryDTO>> getHistories(String searchValue, int column, int sort) {
		if (sort < 0 || sort > 7) {
			return new ResponseEntity<List<HistoryDTO>>(HttpStatus.BAD_REQUEST);
		}
		switch (column) {
		case 0:
			if (searchValue.trim().length() != 36) {
				return new ResponseEntity<List<HistoryDTO>>(new ArrayList<>(), HttpStatus.OK);
			}
			break;
		case 1:
			try {
				Integer.parseInt(searchValue);
			} catch (NumberFormatException e) {
				return new ResponseEntity<List<HistoryDTO>>(new ArrayList<>(), HttpStatus.OK);
			}
			break;
		case 23:
			if (searchValue.trim().length() != 36) {
				return new ResponseEntity<List<HistoryDTO>>(new ArrayList<>(), HttpStatus.OK);
			}
			break;
		case 3:
			if (searchValue.trim().length() == 0) {
				return new ResponseEntity<List<HistoryDTO>>(new ArrayList<>(), HttpStatus.OK);
			}
			break;
		case 4:
			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				format.parse(searchValue);
				searchValue = searchValue.substring(0, 4) + "-" + searchValue.substring(4, 6) + "-"
						+ searchValue.substring(6);
			} catch (ParseException e) {
				return new ResponseEntity<List<HistoryDTO>>(new ArrayList<>(), HttpStatus.OK);
			}
			break;
		case 5:
			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				format.parse(searchValue);
				searchValue = searchValue.substring(0, 4) + "-" + searchValue.substring(4, 6) + "-"
						+ searchValue.substring(6);
			} catch (ParseException e) {
				return new ResponseEntity<List<HistoryDTO>>(new ArrayList<>(), HttpStatus.OK);
			}
			break;
		default:
			break;
		}
		try {
			List<HistoryDTO> result = mapper.getHistories(searchValue, column, sort);
			return new ResponseEntity<List<HistoryDTO>>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<HistoryDTO>>(new ArrayList<>(), HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<Integer> getTotalHistories() {
		int result = mapper.getTotalHistories();
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

}
