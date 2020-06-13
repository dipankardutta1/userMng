package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDto;

@Service
public class LoginService {
	
	@Autowired
	private UserDao userDao;
	
	
	@Transactional
	public UserDto getUserByUsernameAndPassword(String username,String password) {
		
		try {
			return userDao.findByUsernameAndPassword(username, password);
		
		}catch(Exception e) {
			return null;
		}
		
		
		
	}

}
