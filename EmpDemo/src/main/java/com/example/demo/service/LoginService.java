package com.example.demo.service;

import java.util.List;

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


	public void saveUser(UserDto userDto) {
		try {
			userDao.save(userDto);
		
		}catch(Exception e) {
			
		}
		
	}


	public List<UserDto> getUserList() {
		try {
			return userDao.findAll();
		
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public UserDto findUserById(Integer id) {
		try {
			return userDao.findUserById(id);
		
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public void updateUser(UserDto userDto) {
		try {
			userDao.update(userDto);
		
		}catch(Exception e) {
			
		}	
	}

}
