package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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


	public void save(UserDto userDto){
		String sql = "INSERT INTO user(name,phone_no,dob,username,password) values(?, ?, ?,?,?)";

			
		jdbcTemplate.update(sql, new Object[] { userDto.getName(),userDto.getPhoneNo(),userDto.getDob(),userDto.getUsername(),userDto.getPassword() });
	}


	public List<UserDto> findAll() {
		String sql = "SELECT * FROM user";

        return jdbcTemplate.query(sql,new UserRowMapper());
	}


	public UserDto findUserById(Integer id) {
		String sql = "SELECT * FROM user WHERE id=?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserRowMapper());
	}


	public void update(UserDto userDto) {
		String sql = "update user set name=?,phone_no=?,dob=?,username=?,password=? where id=?";

		
		jdbcTemplate.update(sql, new Object[] { userDto.getName(),userDto.getPhoneNo(),userDto.getDob(),userDto.getUsername(),userDto.getPassword(),userDto.getId() });
	}
	

}
