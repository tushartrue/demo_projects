package cts.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cts.controller.RequestHandler;
import cts.dao.TopicDAO;
import cts.domain.Topic;
import cts.domain.Users;
import cts.framework.util.ApplicationConstants;
import cts.framework.util.JspPathConstants;

public class DetailTopicServlet implements RequestHandler {

	public Object handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List retList = null;
		String  topic_id ;
		HttpSession session=request.getSession();
		
			Users user=(Users)session.getValue("user");
			Integer usernum=user.getUsernum();
			 topic_id=(String)request.getParameter("t_id");
			
			TopicDAO topicDAO=new TopicDAO();
			Topic topicObj=topicDAO.getDetailTopic(topic_id);
			
			List repliesList=topicDAO.getTopicReplies(topic_id);
			
			request.setAttribute("topicObj",topicObj);
			request.setAttribute("repliesList",repliesList);
			request.setAttribute("flag","no");
			String reply_id=(String)request.getParameter("reply_id");
			
			String category_id=(String)request.getParameter("category_id");
			String category=(String)request.getParameter("category");
			
			if(category!=null){
				
				if(category.equalsIgnoreCase("general")){
					category_id="0";
				}else if(category.equalsIgnoreCase("housing")){
					category_id="1";
				}else if(category.equalsIgnoreCase("byesell")){
					category_id="2";
				}else {
					category_id="3";
				}
			}
			
			if(reply_id!=null)
			if(reply_id.equalsIgnoreCase("1"))
			request.setAttribute("show_reply","yes");
			
			
			if(category_id.equalsIgnoreCase("0")){
				String sourceImage="images/all-categories-2005-2006[1].gif";
				request.setAttribute("sourceImage",sourceImage);
				request.setAttribute(ApplicationConstants.DETAIL_PAGE,
						JspPathConstants.DETAIL_TOPIC);
				}else if(category_id.equalsIgnoreCase("1")){
					
					String sourceImage="images/Housing[1].gif";
					request.setAttribute("sourceImage",sourceImage);
					request.setAttribute(ApplicationConstants.DETAIL_PAGE,
							JspPathConstants.DETAIL_TOPIC);
					
					
				}else if(category_id.equalsIgnoreCase("2")){
					String sourceImage="images/BuySell[1].png";
					request.setAttribute("sourceImage",sourceImage);
					request.setAttribute(ApplicationConstants.DETAIL_PAGE,
							JspPathConstants.DETAIL_TOPIC);
					
				}else{
					
					String sourceImage="images/technical[1].jpg";
					request.setAttribute("sourceImage",sourceImage);
					request.setAttribute(ApplicationConstants.DETAIL_PAGE,
							JspPathConstants.DETAIL_TOPIC);
					
					
				}
				
		
		return retList;
	}
}