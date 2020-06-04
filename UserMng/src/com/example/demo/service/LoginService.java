package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.User;

public class LoginService {
	
	
	UserDao userDao = new UserDao();
	
	
	public User validateUser(String username,String password) throws Exception{
		
		if(username != null && password != null) {
			
			User user = userDao.getUserByUsernameAndPassword(username, password);
			
			return user;
			
		}else {
			return null;
		}
		
		
		
	}


	public List<User> findAllUsers() throws Exception{
		return userDao.findAll();
	}


	public void saveUser(User user) throws Exception{
		userDao.save(user);
	}
	

}
