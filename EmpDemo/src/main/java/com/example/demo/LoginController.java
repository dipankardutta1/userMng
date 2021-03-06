package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.UserDto;
import com.example.demo.service.LoginService;

@Controller
public class LoginController {  // 
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	
	
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(value = "/login")
	public String goToLoginPage() {
		
		
		
		return "login.jsp";
	}
	
	
	
	@RequestMapping(value = "/doLogin",method = RequestMethod.POST)
	public String doLogin(Model model,@RequestParam("username") String username,@RequestParam("password") String password) {
		
		
		UserDto userDto = loginService.getUserByUsernameAndPassword(username, password);
		
		if(userDto != null) {
			
			UserDto user = new UserDto();
			
			List<UserDto> userList = loginService.getUserList();
			
			model.addAttribute("user", user);
			
			model.addAttribute("userList", userList);
			
			return "dashboard.jsp";
		}else {
			return "login.jsp";
		}
		
		
	}

}
