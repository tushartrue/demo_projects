package cts.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cts.controller.RequestHandler;
import cts.dao.TopicDAO;
import cts.domain.Topic;
import cts.domain.TopicReply;
import cts.domain.Users;
import cts.framework.util.ApplicationConstants;
import cts.framework.util.JspPathConstants;

public class PostReplyServlet implements RequestHandler {

	public Object handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List retList = null;
		String  reply, topic_id,category_id="0" ;
		HttpSession session=request.getSession();
		
			Users user=(Users)session.getValue("user");
			
			 reply=(String)request.getParameter("reply");
			 topic_id=(String) request.getParameter("topic_id");
			 
			String category=(String) request.getParameter("category");
			 
			 TopicReply topicReply=new TopicReply();
			 topicReply.setReply(reply);
			 topicReply.setReplied_user(user);
			 topicReply.setDeletedflag(Integer.valueOf("0"));
			 topicReply.setTopic_id(Integer.valueOf(topic_id));
			 topicReply.setLast_posted(new Date());
			
			TopicDAO topicDAO=new TopicDAO();
			topicDAO.postReply(topicReply);
			
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
			
			
			Topic topicObj=topicDAO.getDetailTopic(topic_id);
			
			List repliesList=topicDAO.getTopicReplies(topic_id);
			
			request.setAttribute("topicObj",topicObj);
			request.setAttribute("repliesList",repliesList);
			
			
			request.setAttribute("flag","no");
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