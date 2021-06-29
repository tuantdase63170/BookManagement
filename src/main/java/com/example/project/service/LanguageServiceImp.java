package com.example.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.project.mapper.LanguageMapper;
import com.example.project.model.LanguageDTO;

@Service
public class LanguageServiceImp implements LanguageService {

	@Autowired
	private LanguageMapper mapper;

	@Override
	public ResponseEntity<List<LanguageDTO>> getAllLanguages(int isActived, int sort) {
		if (isActived < 0 || isActived > 2) {
			return new ResponseEntity<List<LanguageDTO>>(HttpStatus.BAD_REQUEST);
		}
		if (sort < 0 || sort > 3) {
			return new ResponseEntity<List<LanguageDTO>>(HttpStatus.BAD_REQUEST);
		}
		List<LanguageDTO> result = mapper.getAllLanguages(isActived, sort);
		return new ResponseEntity<List<LanguageDTO>>(result, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<LanguageDTO> getLanguageById(String languageId, int isActived) {
		LanguageDTO result = null;
		if (isActived < 0 || isActived > 2) {
			return new ResponseEntity<LanguageDTO>(HttpStatus.BAD_REQUEST);
		}
		if (languageId.trim().length() != 36) {
			return new ResponseEntity<LanguageDTO>(result, HttpStatus.OK);
		} else {
			result = mapper.getLanguageById(languageId, isActived);
			return new ResponseEntity<LanguageDTO>(result, HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<List<LanguageDTO>> getLanguagesByName(String languageName, int isActived, int sort) {
		if (isActived < 0 || isActived > 2) {
			return new ResponseEntity<List<LanguageDTO>>(HttpStatus.BAD_REQUEST);
		}
		if (sort < 0 || sort > 3) {
			return new ResponseEntity<List<LanguageDTO>>(HttpStatus.BAD_REQUEST);
		}
		if (languageName.trim().length() == 0) {
			return new ResponseEntity<List<LanguageDTO>>(new ArrayList<>(), HttpStatus.OK);
		}
		List<LanguageDTO> result = mapper.getLanguagesByName(languageName, isActived, sort);
		return new ResponseEntity<List<LanguageDTO>>(result, HttpStatus.OK);
	}

}
