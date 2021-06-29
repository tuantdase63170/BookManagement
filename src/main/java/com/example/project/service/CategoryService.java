package com.example.project.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.project.model.CategoryDTO;

public interface CategoryService {

	ResponseEntity<List<CategoryDTO>> getAllCategories(int isActived, int sort);

	ResponseEntity<CategoryDTO> getCategoryById(String categoryId, int isActived);

	ResponseEntity<List<CategoryDTO>> getCategoriesByName(String categoryName, int isActived, int sort);

}
