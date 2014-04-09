package cts.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cts.framework.exception.ApplicationException;


public interface RequestHandler {
	/**
	 * @param request
	 * @param response
	 * @return the url of hte view that should render the response
	 * @throws ServletException
	 * @throws IOException
	 */
	Object handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			ApplicationException;
}
