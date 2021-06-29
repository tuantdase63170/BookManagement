package com.example.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.CategoryDTO;
import com.example.project.service.CategoryService;

@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {

	@Autowired
	private CategoryService service;

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
	public ResponseEntity<List<CategoryDTO>> getAllCategories(@PathVariable(name = "is_actived") int is_actived,
			@PathVariable(name = "sort") int sort) {
		ResponseEntity<List<CategoryDTO>> result = service.getAllCategories(is_actived, sort);
		return result;
	}
	// Tested

	@GetMapping(value = "/category_id={category_id}/{is_actived}")
	public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable(name = "category_id") String category_id,
			@PathVariable(name = "is_actived") int is_actived) {
		ResponseEntity<CategoryDTO> result = service.getCategoryById(category_id, is_actived);
		return result;
	}
	// Tested

	@GetMapping(value = "/category_name={category_name}/{is_actived}/{sort}")
	public ResponseEntity<List<CategoryDTO>> getCategoriesByName(@PathVariable(name = "category_name") String category_name,
			@PathVariable(name = "is_actived") int is_actived, @PathVariable(name = "sort") int sort) {
		ResponseEntity<List<CategoryDTO>> result = service.getCategoriesByName(category_name, is_actived, sort);
		return result;
	}
	// Tested

}
