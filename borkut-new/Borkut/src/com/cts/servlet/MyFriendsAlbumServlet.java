package com.cts.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.Impl.PhotosImpl;
import com.cts.Impl.UsersImpl;
import com.cts.controller.RequestHandler;
import com.cts.domain.Users;
import com.cts.framework.util.ApplicationConstants;
import com.cts.framework.util.JspPathConstants;
import com.cts.to.UsersTO;

public class MyFriendsAlbumServlet  implements RequestHandler {

	public Object handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List retList = null;
		UsersTO usersTO = new UsersTO();
		String  usernum=null;
		HttpSession session=request.getSession(false);
		usernum=(String)request.getParameter("frUsernum");
		
			UsersImpl usersImpl = new UsersImpl();
			
			Users users=(Users)usersImpl.fetchProfile(usernum);
			
			request.getSession().setAttribute("myFriend",users);
			request.setAttribute("identifier","friend");
			
			
			PhotosImpl photosImpl=new PhotosImpl();
			List photosList=photosImpl.getPhotos(usernum);
			
			request.setAttribute("photos",photosList);
			

			
			request.setAttribute(ApplicationConstants.LEFT_PAGE,
					JspPathConstants.FRIEND_LEFT_PAGE_JSP);
			
			request.setAttribute(ApplicationConstants.RIGHT_PAGE,
					JspPathConstants.VIEW_ALBUM_JSP);
			
			
	
		return retList;
	}
}