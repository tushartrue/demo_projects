package com.cts.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.Impl.ScrapbookImpl;
import com.cts.Impl.UsersImpl;
import com.cts.controller.RequestHandler;
import com.cts.domain.Users;
import com.cts.framework.util.ApplicationConstants;
import com.cts.framework.util.JspPathConstants;
import com.cts.to.UsersTO;

public class FriendsViewScrapbookServlet implements RequestHandler {

	public Object handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List retList = null;
		UsersTO usersTO = new UsersTO();
		String  usernum=null;
		HttpSession session=request.getSession(false);
		usernum=(String)request.getParameter("frUsernum");
		
			UsersImpl usersImpl = new UsersImpl();
			
			Users users=(Users)usersImpl.fetchProfile(usernum);
			
			session.setAttribute("myFriend",users);
			
			ScrapbookImpl scrapbookImp=new ScrapbookImpl();
			List scrapList=scrapbookImp.getScraps(usernum);
			
			request.setAttribute("scraps",scrapList);

			
			request.setAttribute(ApplicationConstants.LEFT_PAGE,
					JspPathConstants.FRIEND_LEFT_PAGE_JSP);
			
			request.setAttribute(ApplicationConstants.RIGHT_PAGE,
					JspPathConstants.VIEW_SCRAPBOOK_JSP);
			
			
	
		return retList;
	}
}