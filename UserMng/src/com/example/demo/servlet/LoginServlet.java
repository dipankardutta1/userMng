package com.example.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.demo.dto.User;
import com.example.demo.service.LoginService;

public class LoginServlet extends HttpServlet{
	
	
	LoginService loginService = new LoginService();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String username = req.getParameter("username");
			
			String password = req.getParameter("password");
			
			User user = loginService.validateUser(username, password);
			
			if(user == null) {
				
				resp.sendRedirect("page.jsp");
				
			}else {
				
				
				
				HttpSession session = req.getSession();
				
				
				
				session.setAttribute("name", user.getName());
				session.setAttribute("phoneNo", user.getPhoneNo());
				
				
				List<User> userList = loginService.findAllUsers();
				
				req.setAttribute("userList", userList);
				
				req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
				
				
			}
		
		}catch(Exception e) {
			
		}


		
		
		
	}
}
