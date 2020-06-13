package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.UserDto;
import com.example.demo.service.LoginService;

@Controller
public class LoginController {  // 
	
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(value = "/login")
	public String goToLoginPage() {
		
		
		
		return "login.jsp";
	}
	
	
	
	@RequestMapping(value = "/doLogin",method = RequestMethod.POST)
	public String doLogin(@RequestParam("username") String username,@RequestParam("password") String password) {
		
		
		UserDto userDto = loginService.getUserByUsernameAndPassword(username, password);
		
		if(userDto != null) {
			return "dashboard.jsp";
		}else {
			return "login.jsp";
		}
		
		
	}

}
