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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.UserDto;
import com.example.demo.service.LoginService;

@Controller
public class UserController {  // 
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	
	
	@Autowired
	private LoginService loginService;
	
	
	
	
	
	@RequestMapping(value = "/processUser",method = RequestMethod.POST)
	public String processUser(Model model,@ModelAttribute("user") UserDto userDto) {
		
		
		if(userDto.getId() == null) {
			loginService.saveUser(userDto);
		}else{
			loginService.updateUser(userDto);
		}
		
		
		
		
		UserDto user = new UserDto();
		
		List<UserDto> userList = loginService.getUserList();
		
		model.addAttribute("user", user);
		
		model.addAttribute("userList", userList);
		
		return "dashboard.jsp";
	
		
		
	}
	
	
	
	
	
	@RequestMapping(value = "/editUser",method = RequestMethod.GET)
	public String processUser(Model model,@RequestParam("id") Integer id) {
		
		
		//	
		
		
		
		
		UserDto user = loginService.findUserById(id);
		
		List<UserDto> userList = loginService.getUserList();
		
		model.addAttribute("user", user);
		
		model.addAttribute("userList", userList);
		
		return "dashboard.jsp";
	
		
		
	}
	
	
	
	
	
	
	
	
	

}
