package cts.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cts.controller.RequestHandler;
import cts.framework.util.ApplicationConstants;
import cts.framework.util.JspPathConstants;

public class ContactMeServlet implements RequestHandler {

	public Object handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List retList = null;

			try {
				
				String sourceImage="images/tusharClose.jpg";
				request.setAttribute("sourceImage",sourceImage);
				request.setAttribute(ApplicationConstants.DETAIL_PAGE,
						JspPathConstants.CONTACT_ME);
				
				request.setAttribute("flag","no");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				
				e.printStackTrace();
			}

			
			
			
		
		return retList;
	}
}