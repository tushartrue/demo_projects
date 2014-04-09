package cts.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cts.controller.RequestHandler;
import cts.dao.UsersDAO;
import cts.domain.Users;

public class NewAccountServlet implements RequestHandler {

	public Object handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List retList = null;
		
		String  username,firstname, lastname, confirmPassword, rePassword ;
		username = request.getParameter("username");
		firstname = request.getParameter("firstname");
		lastname = request.getParameter("lastname");
		confirmPassword = request.getParameter("password");
		rePassword = request.getParameter("retypepassword");
		
		
		
		//converting first letter into capital 
		firstname = firstname.substring(0,1).toUpperCase()+firstname.substring(1);
		lastname = lastname.substring(0,1).toUpperCase()+lastname.substring(1);
		
		
			Users users=new Users();
			users.setUsername(username);
			users.setFirstname(firstname);
			users.setLastname(lastname);
			users.setPassword(confirmPassword);
			users.setDeletedflag(Integer.valueOf(0));
			
			UsersDAO usersDAO=new UsersDAO();
			usersDAO.createNewAccount(users);
			
			request.setAttribute("flag","yes");
			
		
		
		return retList;
	}
}
