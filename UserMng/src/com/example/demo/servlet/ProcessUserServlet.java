package com.example.demo.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.dto.User;
import com.example.demo.service.LoginService;

public class ProcessUserServlet extends HttpServlet{
	
	
	LoginService loginService = new LoginService();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
					
		
			String name = req.getParameter("name");
			
			String phoneNo = req.getParameter("phoneNo");
			
			Date dob = format.parse(req.getParameter("dob"));
			String username = req.getParameter("username");
			
			String password = req.getParameter("password");
			
			
			User user = new User();
			
			user.setName(name);
			user.setPhoneNo(phoneNo);
			user.setDob(dob);
			user.setUsername(username);
			user.setPassword(password);
			
			
			
			
			loginService.saveUser(user);
			
			
				
				//req.setAttribute("name", user.getName());
				//req.setAttribute("phoneNo", user.getPhoneNo());
				
				
				List<User> userList = loginService.findAllUsers();
				
				req.setAttribute("userList", userList);
				
				req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
				
		
		}catch(Exception e) {
			
		}


		
		
		
	}
}
