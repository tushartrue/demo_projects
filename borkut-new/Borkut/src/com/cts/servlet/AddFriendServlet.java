package com.cts.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.Impl.FriendsImpl;
import com.cts.Impl.PhotosImpl;
import com.cts.Impl.UsersImpl;
import com.cts.controller.RequestHandler;
import com.cts.domain.Users;
import com.cts.framework.exception.FriendExistException;
import com.cts.framework.util.ApplicationConstants;
import com.cts.framework.util.JspPathConstants;
import com.cts.to.UsersTO;

public class AddFriendServlet implements RequestHandler {

	public Object handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List retList = null;
		UsersImpl usersImpl=new UsersImpl();	
		
		HttpSession session=request.getSession();
		Users user=(Users)session.getAttribute("myUser");
		
		
		Users friends=(Users)session.getAttribute("myFriend");
		
		String friend=(String)request.getParameter("frUsernum");
		
	
		String usernum=user.getUsernum().toString();
		
			try {
				FriendsImpl.addFriend(usernum,friend);
				
				Users users=(Users)usersImpl.fetchProfile(friend);
				
				session.setAttribute("myFriend",users);
				request.setAttribute(ApplicationConstants.LEFT_PAGE,
						JspPathConstants.FRIEND_LEFT_PAGE_JSP);
				
				request.setAttribute(ApplicationConstants.RIGHT_PAGE,
						JspPathConstants.RIGHT_PAGE_JSP);
			} catch (FriendExistException e) {
				// TODO Auto-generated catch block
				
				Users users=(Users)usersImpl.fetchProfile(friend);
				
				session.setAttribute("myFriend",users);
				request.setAttribute(ApplicationConstants.LEFT_PAGE,
						JspPathConstants.FRIEND_LEFT_PAGE_JSP);
				request.setAttribute(ApplicationConstants.RIGHT_PAGE,
						JspPathConstants.FRIEND_EXISTS_JSP);
			}
		
				
			
			//Users users=(Users)usersImpl.fetchProfile(usernum);
			
			
			
			
	
		return retList;
	}
}
