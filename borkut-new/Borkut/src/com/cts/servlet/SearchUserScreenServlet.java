package com.cts.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.Impl.UsersImpl;
import com.cts.controller.RequestHandler;
import com.cts.domain.Users;
import com.cts.framework.util.ApplicationConstants;
import com.cts.framework.util.JspPathConstants;
import com.cts.to.UsersTO;

public class SearchUserScreenServlet implements RequestHandler {

	public Object handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List retList = null;
		UsersTO usersTO = new UsersTO();
		String  usernum=null;
		HttpSession session=request.getSession(false);
		Users user=(Users)session.getValue("myUser");
		
			UsersImpl usersImpl = new UsersImpl();

			Users users=(Users)usersImpl.fetchProfile(user.getUsernum().toString());
			
			request.setAttribute("userparam",users);
			
			String search=(String)request.getParameter("searchUser");
			if(search!=null)
			if(search.equalsIgnoreCase("yes")){
				
				String firstname=(String)request.getParameter("txtFirstname");
				String lastname=(String)request.getParameter("txtLastname");
				String city=(String)request.getParameter("txtCity");
				
				retList=usersImpl.searchUsers(firstname,lastname,city);
				request.setAttribute("userList",retList);
			}
			
			request.setAttribute(ApplicationConstants.LEFT_PAGE,
					JspPathConstants.LEFT_PAGE_JSP);
			
			request.setAttribute(ApplicationConstants.RIGHT_PAGE,
					JspPathConstants.SEARCH_USER_SCREEN_JSP);
			
			
	
		return retList;
	}
}

