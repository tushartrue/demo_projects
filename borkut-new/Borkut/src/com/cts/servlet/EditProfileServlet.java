package com.cts.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
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
import com.oreilly.servlet.MultipartRequest;

public class EditProfileServlet implements RequestHandler {

	public Object handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List retList = null;
		String photo = "selfImage/";
		String destFolder = "D:/workspace_borkut/Borkut/WebContent/" + photo;
		MultipartRequest multi = new MultipartRequest(request, destFolder,
				10 * 1024 * 1024);
		File f = null;

		Enumeration params = multi.getParameterNames();

		UsersTO userTO = new UsersTO();

		String empname = null, uploadphoto = null;

		while (params.hasMoreElements()) {
			String name = (String) params.nextElement();
			String value = multi.getParameter(name);

			if (name.equalsIgnoreCase("textFirstName")) {
				if (null != value && !ApplicationConstants.BLANK.equals(value)) {
					userTO.setFirstname(value);
				}
			} else if (name.equalsIgnoreCase("textLastName")) {
				if (null != value && !ApplicationConstants.BLANK.equals(value)) {
					userTO.setLastname(value);
				}
			} else if (name.equalsIgnoreCase("aboutMe")) {
				if (null != value && !ApplicationConstants.BLANK.equals(value)) {
					userTO.setAboutme(value);
				}
			} else if (name.equalsIgnoreCase("image")) {
				if (null != value && !ApplicationConstants.BLANK.equals(value)) {
					userTO.setImage(value);
				}
			} else if (name.equalsIgnoreCase("textCity")) {
				if (null != value && !ApplicationConstants.BLANK.equals(value)) {
					userTO.setCity(value);
				}
			} else if (name.equalsIgnoreCase("radioGender")) {
				if (null != value && !ApplicationConstants.BLANK.equals(value)) {
					userTO.setGender(value);
				}
			} else if (name.equalsIgnoreCase("textCountry")) {
				if (null != value && !ApplicationConstants.BLANK.equals(value)) {
					userTO.setCountry(value);
				}
			} else if (name.equalsIgnoreCase("textOrganisation")) {
				if (null != value && !ApplicationConstants.BLANK.equals(value)) {
					userTO.setOrganisation(value);
				}
			} else if (name.equalsIgnoreCase("textUsernum")) {
				if (null != value && !ApplicationConstants.BLANK.equals(value)) {
					userTO.setUsernum(Integer.valueOf(value));
				}
			}

			Enumeration files = multi.getFileNames();
			String fName = (String) files.nextElement(); //will give name of file like "tushar"
			String filename = multi.getFilesystemName(fName); //will give name file like "tushar.jpg"
			uploadphoto = photo + filename;

			f = multi.getFile(fName);

			if (null != filename && ApplicationConstants.BLANK != filename) {
				userTO.setImage(uploadphoto);
			}

		}
		
		UsersImpl userImpl=new UsersImpl();
		Users users=(Users)userImpl.editProfile(userTO);
		
		HttpSession session=request.getSession();
		session.setAttribute("myUser",users);
		
		request.setAttribute(ApplicationConstants.LEFT_PAGE,
				JspPathConstants.LEFT_PAGE_JSP);
		
		request.setAttribute(ApplicationConstants.RIGHT_PAGE,
				JspPathConstants.PROFILE_UPDATION);

		
		return retList;
	}

}