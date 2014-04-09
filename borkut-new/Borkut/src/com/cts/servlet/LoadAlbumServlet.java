package com.cts.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;

import com.cts.Impl.PhotosImpl;
import com.cts.Impl.UsersImpl;
import com.cts.controller.RequestHandler;
import com.cts.domain.Users;
import com.cts.framework.util.ApplicationConstants;
import com.cts.framework.util.JspPathConstants;
import com.cts.to.UsersTO;
import com.oreilly.servlet.MultipartRequest;

public class LoadAlbumServlet implements RequestHandler {

	public Object handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List retList = null;
		UsersTO usersTO = new UsersTO();
	
		HttpSession session=request.getSession(false);
	
		
		String photo = "album/";
		String destFolder = "D:/workspace_borkut/Borkut/WebContent/" + photo;
		MultipartRequest multi = new MultipartRequest(request, destFolder,
				10 * 1024 * 1024);
		File f = null;

		Enumeration params = multi.getParameterNames();
		
		String usernum=null,albumImage=null,label=null,name=null,value=null;
		
		while(params.hasMoreElements()){
			
			 name=(String)params.nextElement();
			 value=multi.getParameter(name);
		
		
		if (name.equalsIgnoreCase("albumImage")) {
			albumImage=value;
		}
		 else if (name.equalsIgnoreCase("textLabel")){
			 label=value;
			}
		 else if (name.equalsIgnoreCase("usernum")){
			 usernum=value;
			}
		}
		Enumeration files = multi.getFileNames();
		String fName = (String) files.nextElement();  //will give name of file like "tushar"
		String filename = multi.getFilesystemName(fName); //will give name file like "tushar.jpg"
		String uploadphoto=photo+filename;
		
		f = multi.getFile(fName);

		
			PhotosImpl  photosImpl = new PhotosImpl();

			try {
				photosImpl.loadAlbum(usernum,uploadphoto,label);
				
				UsersImpl usersImpl = new UsersImpl();
				
				Users users=(Users)usersImpl.fetchProfile(usernum);
				
				request.getSession().setAttribute("myUser",users);
				
				String identifier=(String)request.getSession().getAttribute("fromFriendPage");

				if(identifier!=null){
					request.setAttribute(ApplicationConstants.LEFT_PAGE,
							JspPathConstants.FRIEND_LEFT_PAGE_JSP);
					
				}else{
				request.setAttribute(ApplicationConstants.LEFT_PAGE,
						JspPathConstants.LEFT_PAGE_JSP);
				
				
				List photosList=photosImpl.getPhotos(usernum);
				
				request.setAttribute("photos",photosList);
				}
				
				request.setAttribute(ApplicationConstants.RIGHT_PAGE,
						JspPathConstants.VIEW_ALBUM_JSP);
			} catch (HibernateException e) {
				// TODO Auto-generated catch block

				request.setAttribute(ApplicationConstants.DETAIL_PAGE,
						JspPathConstants.DATABASE_EXCEPTION_JSP);
				e.printStackTrace();
			}
			
			
	
		return retList;
	}
}
