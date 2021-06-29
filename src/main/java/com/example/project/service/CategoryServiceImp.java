package com.example.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.project.mapper.CategoryMapper;
import com.example.project.model.CategoryDTO;

@Service
public class CategoryServiceImp implements CategoryService {

	@Autowired
	private CategoryMapper mapper;

	@Override
	public ResponseEntity<List<CategoryDTO>> getAllCategories(int isActived, int sort) {
		if (isActived < 0 || isActived > 2) {
			return new ResponseEntity<List<CategoryDTO>>(HttpStatus.BAD_REQUEST);
		}
		if (sort < 0 || sort > 3) {
			return new ResponseEntity<List<CategoryDTO>>(HttpStatus.BAD_REQUEST);
		}
		List<CategoryDTO> result = mapper.getAllCategories(isActived, sort);
		return new ResponseEntity<List<CategoryDTO>>(result, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<CategoryDTO> getCategoryById(String categoryId, int isActived) {
		CategoryDTO result = null;
		if (isActived < 0 || isActived > 2) {
			return new ResponseEntity<CategoryDTO>(HttpStatus.BAD_REQUEST);
		}
		if (categoryId.trim().length() != 36) {
			return new ResponseEntity<CategoryDTO>(result, HttpStatus.OK);
		} else {
			result = mapper.getCategoryById(categoryId, isActived);
			return new ResponseEntity<CategoryDTO>(result, HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<List<CategoryDTO>> getCategoriesByName(String categoryName, int isActived, int sort) {
		if (isActived < 0 || isActived > 2) {
			return new ResponseEntity<List<CategoryDTO>>(HttpStatus.BAD_REQUEST);
		}
		if (sort < 0 || sort > 3) {
			return new ResponseEntity<List<CategoryDTO>>(HttpStatus.BAD_REQUEST);
		}
		if (categoryName.trim().length() == 0) {
			return new ResponseEntity<List<CategoryDTO>>(new ArrayList<>(), HttpStatus.OK);
		}
		List<CategoryDTO> result = mapper.getCategoriesByName(categoryName, isActived, sort);
		return new ResponseEntity<List<CategoryDTO>>(result, HttpStatus.OK);
	}

}
