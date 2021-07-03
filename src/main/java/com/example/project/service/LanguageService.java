package com.example.project.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.project.model.LanguageDTO;

public interface LanguageService {

	ResponseEntity<List<LanguageDTO>> getAllLanguages(int isActived, int sort);

	ResponseEntity<LanguageDTO> getLanguageById(String languageId, int isActived);

	ResponseEntity<List<LanguageDTO>> getLanguagesByName(String languageName, int isActived, int sort);

	ResponseEntity<Integer> getTotalLanguages();

}
