package com.example.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.project.model.CustomerDTO;

@Mapper
public interface CustomerMapper {

	@Select("<script>"
			+ " select"
			+ " customer_id as customerId,"
			+ " email as email,"
			+ " phone as phone,"
			+ " inserted_at as insertedAt"
			+ " from Customer"
			+ " <choose>"
			+ " <when test = \"sort == 0\">"
			+ " </when>"
			+ " <when test = \"sort == 1\">"
			+ " order by customer_id asc"
			+ " </when>"
			+ " <when test = \"sort == 2\">"
			+ " order by email asc"
			+ " </when>"
			+ " <when test = \"sort == 3\">"
			+ " order by phone asc"
			+ " </when>"
			+ " <when test = \"sort == 4\">"
			+ " order by inserted_at asc"
			+ " </when>"
			+ " </choose>"
			+ "</script>")
	List<CustomerDTO> getAllCustomers(int sort);
	
	@Select("select"
			+ " customer_id as customerId,"
			+ " email as email,"
			+ " phone as phone,"
			+ " inserted_at as insertedAt"
			+ " from Customer"
			+ " where customer_id = '${customerId}'")
	CustomerDTO getCustomerById(String customerId);
	
	@Select("<script>"
			+ " select"
			+ " customer_id as customerId,"
			+ " email as email,"
			+ " phone as phone,"
			+ " inserted_at as insertedAt"
			+ " from Customer"
			+ " where email like '%${email}%'"
			+ " <choose>"
			+ " <when test = \"sort == 0\">"
			+ " </when>"
			+ " <when test = \"sort == 1\">"
			+ " order by customer_id asc"
			+ " </when>"
			+ " <when test = \"sort == 2\">"
			+ " order by email asc"
			+ " </when>"
			+ " <when test = \"sort == 3\">"
			+ " order by phone asc"
			+ " </when>"
			+ " <when test = \"sort == 4\">"
			+ " order by inserted_at asc"
			+ " </when>"
			+ " </choose>"
			+ "</script>")
	List<CustomerDTO> getCustomersByEmail(String email, int sort);
	
	@Select("<script>"
			+ " select"
			+ " customer_id as customerId,"
			+ " email as email,"
			+ " phone as phone,"
			+ " inserted_at as insertedAt"
			+ " from Customer"
			+ " where phone like '%${phone}%'"
			+ " <choose>"
			+ " <when test = \"sort == 0\">"
			+ " </when>"
			+ " <when test = \"sort == 1\">"
			+ " order by customer_id asc"
			+ " </when>"
			+ " <when test = \"sort == 2\">"
			+ " order by email asc"
			+ " </when>"
			+ " <when test = \"sort == 3\">"
			+ " order by phone asc"
			+ " </when>"
			+ " <when test = \"sort == 4\">"
			+ " order by inserted_at asc"
			+ " </when>"
			+ " </choose>"
			+ "</script>")
	List<CustomerDTO> getCustomersByPhone(String phone, int sort);
	
	@Select("<script>"
			+ " select"
			+ " customer_id as customerId,"
			+ " email as email,"
			+ " phone as phone,"
			+ " inserted_at as insertedAt"
			+ " from Customer"
			+ " where inserted_at = '${insertedAt}'"
			+ " <choose>"
			+ " <when test = \"sort == 0\">"
			+ " </when>"
			+ " <when test = \"sort == 1\">"
			+ " order by customer_id asc"
			+ " </when>"
			+ " <when test = \"sort == 2\">"
			+ " order by email asc"
			+ " </when>"
			+ " <when test = \"sort == 3\">"
			+ " order by phone asc"
			+ " </when>"
			+ " <when test = \"sort == 4\">"
			+ " order by inserted_at asc"
			+ " </when>"
			+ " </choose>"
			+ "</script>")
	List<CustomerDTO> getCustomersByInsertedAt(String insertedAt, int sort);
	
}
