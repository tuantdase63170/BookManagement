package com.example.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.project.model.HistoryDTO;

@Mapper
public interface HistoryMapper {

	@Select("<script>"
			+ " select"
			+ " history_id as historyId,"
			+ " book_id as bookId,"
			+ " amount as amount,"
			+ " customer_id as customerId,"
			+ " manager_username as managerUsername,"
			+ " borrow_date as borrowDate,"
			+ " return_date as returnDate"
			+ " from History"
			+ "<choose>"
			+ " <when test = \"sort == 0\">"
			+ " </when>"
			+ " <when test = \"sort == 1\">"
			+ " order by history_id asc"
			+ " </when>"
			+ " <when test = \"sort == 2\">"
			+ " order by book_id asc"
			+ " </when>"
			+ " <when test = \"sort == 3\">"
			+ " order by amount asc"
			+ " </when>"
			+ " <when test = \"sort == 4\">"
			+ " order by customer_id asc"
			+ " </when>"
			+ " <when test = \"sort == 5\">"
			+ " order by manager_username asc"
			+ " </when>"
			+ " <when test = \"sort == 6\">"
			+ " order by borrow_date asc"
			+ " </when>"
			+ " <when test = \"sort == 7\">"
			+ " order by return_date asc"
			+ " </when>"
			+ "</choose>"
			+ "</script>")
	List<HistoryDTO> getAllHistories(int sort);
	
	@Select("select"
			+ " history_id as historyId,"
			+ " book_id as bookId,"
			+ " amount as amount,"
			+ " customer_id as customerId,"
			+ " manager_username as managerUsername,"
			+ " borrow_date as borrowDate,"
			+ " return_date as returnDate"
			+ " from History"
			+ " where history_id = '${historyId}'")
	HistoryDTO getHistoryByHistoryId(String historyId);
	
	@Select("<script>"
			+ " select"
			+ " history_id as historyId,"
			+ " book_id as bookId,"
			+ " amount as amount,"
			+ " customer_id as customerId,"
			+ " manager_username as managerUsername,"
			+ " borrow_date as borrowDate,"
			+ " return_date as returnDate"
			+ " from History"
			+ "<choose>"
			+ " <when test = \"column == 0\">"
			+ " where book_id = '${searchValue}'"
			+ " </when>"
			+ " <when test = \"column == 1\">"
			+ " where amount = ${searchValue}"
			+ " </when>"
			+ " <when test = \"column == 2\">"
			+ " where customer_id = '${searchValue}'"
			+ " </when>"
			+ " <when test = \"column == 3\">"
			+ " where manager_username = '${searchValue}'"
			+ " </when>"
			+ " <when test = \"column == 4\">"
			+ " where borrow_date = '${searchValue}'"
			+ " </when>"
			+ " <when test = \"column == 5\">"
			+ " where return_date = '${searchValue}'"
			+ " </when>"
			+ "</choose>"
			+ "<choose>"
			+ " <when test = \"sort == 0\">"
			+ " </when>"
			+ " <when test = \"sort == 1\">"
			+ " order by history_id asc"
			+ " </when>"
			+ " <when test = \"sort == 2\">"
			+ " order by book_id asc"
			+ " </when>"
			+ " <when test = \"sort == 3\">"
			+ " order by amount asc"
			+ " </when>"
			+ " <when test = \"sort == 4\">"
			+ " order by customer_id asc"
			+ " </when>"
			+ " <when test = \"sort == 5\">"
			+ " order by manager_username asc"
			+ " </when>"
			+ " <when test = \"sort == 6\">"
			+ " order by borrow_date asc"
			+ " </when>"
			+ " <when test = \"sort == 7\">"
			+ " order by return_date asc"
			+ " </when>"
			+ "</choose>"
			+ "</script>")
	List<HistoryDTO> getHistories(String searchValue, int column, int sort);
	
	@Select("select count(*) from History")
	Integer getTotalHistories();

}
