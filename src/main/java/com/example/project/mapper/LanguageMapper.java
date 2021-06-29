package com.example.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.project.model.LanguageDTO;

@Mapper
public interface LanguageMapper {
	
	@Select("<script>"
			+ " select"
			+ " language_id as languageId,"
			+ " language_name as languageName,"
			+ " is_actived as isActived"
			+ " from Language"
			+ " <choose>"
			+ " <when test = \"isActived == 0\">"
			+ " </when>"
			+ " <when test = \"isActived == 1\">"
			+ " where is_actived = 1"
			+ " </when>"
			+ " <when test = \"isActived == 2\">"
			+ " where is_actived = 0"
			+ " </when>"
			+ " </choose>"
			+ " <choose>"
			+ " <when test = \"sort == 0\">"
			+ " </when>"
			+ " <when test = \"sort == 1\">"
			+ " order by language_id asc"
			+ " </when>"
			+ " <when test = \"sort == 2\">"
			+ " order by language_name asc"
			+ " </when>"
			+ " <when test = \"sort == 3\">"
			+ " order by is_actived asc"
			+ " </when>"
			+ " </choose>"
			+ "</script>")
	List<LanguageDTO> getAllLanguages(int isActived, int sort);
	
	@Select("<script>"
			+ " select"
			+ " language_id as languageId,"
			+ " language_name as languageName,"
			+ " is_actived as isActived"
			+ " from Language"
			+ " where language_id = #{languageId}"
			+ " <choose>"
			+ " <when test = \"isActived == 0\">"
			+ " </when>"
			+ " <when test = \"isActived == 1\">"
			+ " and is_actived = 1"
			+ " </when>"
			+ " <when test = \"isActived == 2\">"
			+ " and is_actived = 0"
			+ " </when>"
			+ " </choose>"
			+ "</script>")
	LanguageDTO getLanguageById(String languageId, int isActived);
	
	@Select("<script>"
			+ " select"
			+ " language_id as languageId,"
			+ " language_name as languageName,"
			+ " is_actived as isActived"
			+ " from Language"
			+ " where language_name like '%${languageName}%'"
			+ " <choose>"
			+ " <when test = \"isActived == 0\">"
			+ " </when>"
			+ " <when test = \"isActived == 1\">"
			+ " and is_actived = 1"
			+ " </when>"
			+ " <when test = \"isActived == 2\">"
			+ " and is_actived = 0"
			+ " </when>"
			+ " </choose>"
			+ " <choose>"
			+ " <when test = \"sort == 0\">"
			+ " </when>"
			+ " <when test = \"sort == 1\">"
			+ " order by language_id asc"
			+ " </when>"
			+ " <when test = \"sort == 2\">"
			+ " order by language_name asc"
			+ " </when>"
			+ " <when test = \"sort == 3\">"
			+ " order by is_actived asc"
			+ " </when>"
			+ " </choose>"
			+ "</script>")
	List<LanguageDTO> getLanguagesByName(String languageName, int isActived, int sort);
	
}
