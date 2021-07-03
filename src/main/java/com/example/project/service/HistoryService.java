package com.example.project.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.project.model.HistoryDTO;

public interface HistoryService {

	ResponseEntity<List<HistoryDTO>> getAllHistories(int sort);

	ResponseEntity<HistoryDTO> getHistoryByHistoryId(String historyId);

	ResponseEntity<List<HistoryDTO>> getHistories(String searchValue, int column, int sort);
	
	ResponseEntity<Integer> getTotalHistories();

}
