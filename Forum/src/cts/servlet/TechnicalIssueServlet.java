package cts.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cts.controller.RequestHandler;
import cts.dao.TopicDAO;
import cts.domain.Users;
import cts.framework.util.ApplicationConstants;
import cts.framework.util.JspPathConstants;

public class TechnicalIssueServlet implements RequestHandler {

	public Object handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List retList = null;
		String  username, password ;
		HttpSession session=request.getSession();
		
			Users user=(Users)session.getValue("user");
			Integer usernum=user.getUsernum();
			String category_id=(String)request.getParameter("category_id");
			String discussion_id=(String)request.getParameter("discussion_id");
			TopicDAO topicDAO=new TopicDAO();
			
			List topicList=topicDAO.getTopics(Integer.valueOf(category_id));
			
			request.setAttribute("topicList",topicList);
			
			request.setAttribute("flag","no");
			
			if(discussion_id!=null)
			if(discussion_id.equalsIgnoreCase("1")){
			request.setAttribute("show","yes");
			}
			try {
				
				String sourceImage="images/technical[1].jpg";
				request.setAttribute("sourceImage",sourceImage);
				request.setAttribute(ApplicationConstants.DETAIL_PAGE,
						JspPathConstants.TECHNICAL_ISUUE);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				
				e.printStackTrace();
			}

			
			
			
		
		return retList;
	}
}