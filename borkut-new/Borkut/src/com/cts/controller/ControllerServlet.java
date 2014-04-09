package com.cts.controller;

import java.io.IOException;
import java.util.ResourceBundle;



import com.cts.framework.exception.ApplicationException;
import com.cts.framework.util.JspPathConstants;

/**
 * Simple fragment of a controller servlet using mappings from application URL
 * to a number of RequestHandler helper classes.
 * 
 */

public class ControllerServlet extends HttpServlet {

	/**
	 * Holds the reference to the logger.
	 */

	/**
	 * Based on the URL within our application, choose a RequestHandler to
	 * handle the request and delegating processing to it
	 */
	
	public void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {


		requestProcesor(request, response);

	}


	public void doPost(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		// TODO Auto-generated method stub

		requestProcesor(request, response);

	}

	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void requestProcesor(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {

		final String servletPath = request.getServletPath();

		ResourceBundle.getBundle("servletConfig");
		final String className = ResourceBundle.getBundle("servletConfig")
				.getString(servletPath);

		try {
			final RequestHandler requestHandler;

			try {
				try {
					requestHandler = (RequestHandler) Class.forName(className)
							.newInstance();
					final Object data = (Object) requestHandler.handleRequest(
							request, response);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher(JspPathConstants.MAIN_MENU_JSP).forward(
				request, response);

	}
}
