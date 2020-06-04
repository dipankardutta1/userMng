package com.example.demo.service;

import com.example.demo.dao.UserDao;

public class UserService {
	
	UserDao userDao = new UserDao();
	
	
	public void deleteUserById(Integer id) throws Exception{
		
		userDao.deleteById(id);
		
	}

}
