package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.User;

public class UserDao {
	
	
	
	public User getUserByUsernameAndPassword(String username,String password) throws Exception{
		
		Connection connection = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_419","root","root");
			
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user where username=? and password = ?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			User user = null;
			
			while(resultSet.next()) {
				user = new User();
				
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setDob(resultSet.getDate("dob"));
				user.setPhoneNo(resultSet.getString("phone_no"));
				user.setUsername(username);
				user.setPassword(password);
				
				
			}
			
			return user;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			connection.close();
		}
	}

	public List<User> findAll() throws Exception{
		Connection connection = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_419","root","root");
			
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user");
		
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			List<User> list = new ArrayList<User>();
			
			while(resultSet.next()) {
				User user = new User();
				
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setDob(resultSet.getDate("dob"));
				user.setPhoneNo(resultSet.getString("phone_no"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				
				
				list.add(user);
				
			}
			
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			connection.close();
		}
	}

	public void save(User user) throws Exception{
		Connection connection = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_419","root","root");
			
			
			PreparedStatement preparedStatement = connection.prepareStatement("insert into user(name,phone_no,dob,username,password) values(?,?,?,?,?)");
		
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPhoneNo());
			preparedStatement.setDate(3, new java.sql.Date(user.getDob().getTime()));
			preparedStatement.setString(4, user.getUsername());
			preparedStatement.setString(5, user.getPassword());
			
			preparedStatement.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
	}

	public void deleteById(Integer id)throws Exception {
		Connection connection = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_419","root","root");
			
			
			PreparedStatement preparedStatement = connection.prepareStatement("delete from user where id=?");
		
			preparedStatement.setInt(1,id);
		
			
			preparedStatement.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
		
	}

}
