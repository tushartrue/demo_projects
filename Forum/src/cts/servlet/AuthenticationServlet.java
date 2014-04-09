package cts.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cts.controller.RequestHandler;
import cts.dao.UsersDAO;
import cts.domain.Users;
import cts.framework.exception.AccountNotFoundException;
import cts.framework.exception.AlreadyExistsException;
import cts.framework.exception.InvalidPasswordException;
import cts.framework.util.ApplicationConstants;
import cts.framework.util.JspPathConstants;

public class AuthenticationServlet implements RequestHandler {

	public Object handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List retList = null;
		String username, password;
		HttpSession session = request.getSession();
		username = request.getParameter("username");
		password = request.getParameter("password");

		if (username == null && password == null) {
			Users user = (Users) session.getValue("user");
			username = user.getUsername();
			password = user.getPassword();
		}

		try {
			UsersDAO usersDAO = new UsersDAO();
			Users user = (Users) usersDAO.authenticate(username, password);
			session.setAttribute("user", user);

			request.setAttribute("flag", "no");

			String sourceImage = "images/mm_lodging_image.jpg";
			request.setAttribute("sourceImage", sourceImage);
			request.setAttribute(ApplicationConstants.DETAIL_PAGE,
					JspPathConstants.HOME_PAGE);

		} catch (InvalidPasswordException ipe) {
			
			request.setAttribute("flag", "invalidPassword");
			
			ipe.printStackTrace();
		}catch (AccountNotFoundException ane) {
			
			request.setAttribute("flag", "noAccount");
			
			ane.printStackTrace();
		}

		return retList;
	}
}