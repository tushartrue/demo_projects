package com.cts.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;

import com.cts.Impl.UsersImpl;
import com.cts.controller.RequestHandler;
import com.cts.domain.Users;
import com.cts.framework.exception.InvalidPasswordException;
import com.cts.framework.util.ApplicationConstants;
import com.cts.framework.util.JspPathConstants;

public class AuthenticationServlet implements RequestHandler {

	

	public Object handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

			List retList=null;
			HttpSession session=null;
			session=request.getSession();
			String username,password=null;
			username=(String)request.getParameter("UserName");
			password=(String)request.getParameter("Password");
			
			System.out.println("User login----->"+username);
			
			if(username==null & password==null){
				
				Users user=(Users)session.getAttribute("myUser");
				username=user.getUsername();
				//password=user.getPassword();
				
				
			}
			
			UsersImpl usersImpl=new UsersImpl();
			
		
				Users userparam;
				try {
					userparam = (Users)usersImpl.authenticateUser(username,password);
					
					request.setAttribute("userparam",userparam);
					request.setAttribute("myaccount","yes");
					
					session.setAttribute("myUser",userparam);
					
					request.setAttribute(ApplicationConstants.LEFT_PAGE,
							JspPathConstants.LEFT_PAGE_JSP);
					
					request.setAttribute(ApplicationConstants.RIGHT_PAGE,
							JspPathConstants.RIGHT_PAGE_JSP);
					
				} catch (HibernateException e) {
					// TODO Auto-generated catch block
					
					request.setAttribute(ApplicationConstants.DETAIL_PAGE,
							JspPathConstants.DATABASE_EXCEPTION_JSP);
					
					
					e.printStackTrace();
				} catch (IndexOutOfBoundsException e) {
					
					request.setAttribute(ApplicationConstants.DETAIL_PAGE,
							JspPathConstants.ACCOUNT_NOT_EXISTS_JSP);
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidPasswordException e) {
					
					request.setAttribute(ApplicationConstants.DETAIL_PAGE,
							JspPathConstants.INVALID_PASSWORD_MESSEGE_JSP);
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
		
			
		return retList;
	}
}