package com.example.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.project.model.CategoryDTO;

@Mapper
public interface CategoryMapper {
	
	@Select("<script>"
			+ " select"
			+ " category_id as categoryId,"
			+ " category_name as categoryName,"
			+ " is_actived as isActived"
			+ " from Category"
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
			+ " order by category_id asc"
			+ " </when>"
			+ " <when test = \"sort == 2\">"
			+ " order by category_name asc"
			+ " </when>"
			+ " <when test = \"sort == 3\">"
			+ " order by is_actived asc"
			+ " </when>"
			+ " </choose>"
			+ "</script>")
	List<CategoryDTO> getAllCategories(int isActived, int sort);
	
	@Select("<script>"
			+ " select"
			+ " category_id as categoryId,"
			+ " category_name as categoryName,"
			+ " is_actived as isActived"
			+ " from Category"
			+ " where category_id = '${categoryId}'"
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
	CategoryDTO getCategoryById(String categoryId, int isActived);
	
	@Select("<script>"
			+ " select"
			+ " category_id as categoryId,"
			+ " category_name as categoryName,"
			+ " is_actived as isActived"
			+ " from Category"
			+ " where category_name like '%${categoryName}%'"
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
			+ " order by category_id asc"
			+ " </when>"
			+ " <when test = \"sort == 2\">"
			+ " order by category_name asc"
			+ " </when>"
			+ " <when test = \"sort == 3\">"
			+ " order by is_actived asc"
			+ " </when>"
			+ " </choose>"
			+ "</script>")
	List<CategoryDTO> getCategoriesByName(String categoryName, int isActived, int sort);
	
}
