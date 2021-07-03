package com.example.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.LanguageDTO;
import com.example.project.service.LanguageService;

@RestController
@RequestMapping(value = "/api/language")
public class LanguageController {

	@Autowired
	private LanguageService service;

	// ### isActived
	// 0 - All
	// 1 - Activated
	// 2 - Not activated

	// ### sort
	// 0 - No sort
	// 1 - Sort by id
	// 2 - Sort by name
	// 3 - Sort by is_actived

	@GetMapping(value = "/all/{is_actived}/{sort}")
	public ResponseEntity<List<LanguageDTO>> getAllLanguages(@PathVariable(name = "is_actived") int is_actived,
			@PathVariable(name = "sort") int sort) {
		ResponseEntity<List<LanguageDTO>> result = service.getAllLanguages(is_actived, sort);
		return result;
	}

	@GetMapping(value = "/language_id={language_id}/{is_actived}")
	public ResponseEntity<LanguageDTO> getLanguageById(@PathVariable(name = "language_id") String language_id,
			@PathVariable(name = "is_actived") int is_actived) {
		ResponseEntity<LanguageDTO> result = service.getLanguageById(language_id, is_actived);
		return result;
	}

	@GetMapping(value = "/language_name={language_name}/{is_actived}/{sort}")
	public ResponseEntity<List<LanguageDTO>> getLanguagesByName(@PathVariable(name = "language_name") String language_name,
			@PathVariable(name = "is_actived") int is_actived, @PathVariable(name = "sort") int sort) {
		ResponseEntity<List<LanguageDTO>> result = service.getLanguagesByName(language_name, is_actived, sort);
		return result;
	}
	
	@GetMapping(value = "/count")
	public ResponseEntity<Integer> getTotalLanguages() {
		ResponseEntity<Integer> result = service.getTotalLanguages();
		return result;
	}
	// Tested
	
}
