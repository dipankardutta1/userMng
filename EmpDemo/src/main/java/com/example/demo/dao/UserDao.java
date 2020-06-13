package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.UserDto;

@Repository
public class UserDao {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public UserDto findByUsernameAndPassword(String username,String password) {
		String sql = "SELECT * FROM user WHERE username = ? and password=?";

        return jdbcTemplate.queryForObject(sql, new Object[]{username,password}, new UserRowMapper());
	}
	
	
	public class UserRowMapper implements RowMapper<UserDto> {

	    @Override
	    public UserDto mapRow(ResultSet resultSet, int rowNum) throws SQLException {

	    	UserDto user = new UserDto();
			
			user.setId(resultSet.getInt("id"));
			user.setName(resultSet.getString("name"));
			user.setDob(resultSet.getDate("dob"));
			user.setPhoneNo(resultSet.getString("phone_no"));
			user.setUsername(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));

	        return user;

	    }
	}
	

}
