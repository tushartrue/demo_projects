package com.cts.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.Impl.UsersImpl;
import com.cts.controller.RequestHandler;
import com.cts.framework.exception.AlreadyExistsException;
import com.cts.framework.util.ApplicationConstants;
import com.cts.framework.util.JspPathConstants;
import com.cts.to.UsersTO;

public class NewAccountServlet implements RequestHandler {

	public Object handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List retList = null;
		UsersTO usersTO = new UsersTO();
		String  username,firstName, lastname, confirmPassword, rePassword ,city,organisation,gender,country= null;

		username = request.getParameter("textUsername");
		firstName = request.getParameter("textFirstName");
		lastname = request.getParameter("textLastName");
		confirmPassword = request.getParameter("textPassword");
		rePassword = request.getParameter("textRePassword");
		city = request.getParameter("textCity");
		organisation = request.getParameter("textOrganisation");
		gender = request.getParameter("radioGender");
		country = request.getParameter("textCountry");
		
		
		//converting first letter into capital 
		firstName = firstName.substring(0,1).toUpperCase()+firstName.substring(1);
		lastname = lastname.substring(0,1).toUpperCase()+lastname.substring(1);
		city = city.substring(0,1).toUpperCase()+city.substring(1);
		if(organisation!=null)
		organisation = organisation.substring(0,1).toUpperCase()+organisation.substring(1);
		country = country.substring(0,1).toUpperCase()+country.substring(1);

		if (confirmPassword.equals(rePassword)) {
			
			usersTO.setUsername(username);
			usersTO.setFirstname(firstName);
			usersTO.setLastname(lastname);
			usersTO.setPassword(confirmPassword);
			
			usersTO.setGender(gender);
			usersTO.setCity(city);
			usersTO.setOrganisation(organisation);
			usersTO.setCountry(country);
			
			
			UsersImpl usersImpl = new UsersImpl();

			try {
				usersImpl.createNewAccount(usersTO);
				

				request.setAttribute(ApplicationConstants.NEXT_PAGE,
						JspPathConstants.HOMEPAGE);

				request.setAttribute(ApplicationConstants.DETAIL_PAGE,
						JspPathConstants.ACCOUNT_CREATED_MESSGAE_JSP);
				
			} catch (AlreadyExistsException e) {
				// TODO Auto-generated catch block
				
				request.setAttribute(ApplicationConstants.DETAIL_PAGE,
						JspPathConstants.USERNAME_EXISTS_JSP);
				e.printStackTrace();
			}

			
			
			
		} 
		return retList;
	}
}
