package com.example.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.dto.User;
import com.example.demo.service.LoginService;
import com.example.demo.service.UserService;

public class DeleteUserServlet extends HttpServlet{
	
	UserService userService = new UserService();
	
	LoginService loginService = new LoginService();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
		
		Integer id = Integer.parseInt(req.getParameter("id"));
		
		userService.deleteUserById(id);
		
		List<User> userList = loginService.findAllUsers();
		
		req.setAttribute("userList", userList);
		
		req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
		
		}catch(Exception e) {
			
		}
		
		
	}
}
