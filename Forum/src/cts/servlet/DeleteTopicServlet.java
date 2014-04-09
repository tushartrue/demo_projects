package cts.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cts.controller.RequestHandler;
import cts.dao.TopicDAO;
import cts.framework.util.ApplicationConstants;
import cts.framework.util.JspPathConstants;

public class DeleteTopicServlet implements RequestHandler {

	public Object handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List retList = null;
		int category_id=0;
		
		String topic_id=request.getParameter("topic_id");
		String category=request.getParameter("category");
		TopicDAO topicDAO=new TopicDAO();
		
		topicDAO.deleteTopic(topic_id);
		
		
		
		
		if(category.equalsIgnoreCase("housing")){
			
			category_id=1;
		}else if(category.equalsIgnoreCase("byesell")){
			category_id=2;
			
		}else if(category.equalsIgnoreCase("general")){
			category_id=0;
			
		}else {
			category_id=3;
			
		}
		
		List topicList=(List)topicDAO.getTopics(Integer.valueOf(category_id));
		request.setAttribute("topicList",topicList);
		request.setAttribute("flag","no");
		
		if(category_id==0){
		String sourceImage="images/all-categories-2005-2006[1].gif";
		request.setAttribute("sourceImage",sourceImage);
		request.setAttribute(ApplicationConstants.DETAIL_PAGE,
				JspPathConstants.ALL_CATEGORY);
		}else if(category_id==1){
			
			String sourceImage="images/Housing[1].gif";
			request.setAttribute("sourceImage",sourceImage);
			request.setAttribute(ApplicationConstants.DETAIL_PAGE,
					JspPathConstants.HOUSING);
			
			
		}else if(category_id==2){
			String sourceImage="images/BuySell[1].png";
			request.setAttribute("sourceImage",sourceImage);
			request.setAttribute(ApplicationConstants.DETAIL_PAGE,
					JspPathConstants.BYE_SELL);
			
			
			
		}else{
			
			String sourceImage="images/technical[1].jpg";
			request.setAttribute("sourceImage",sourceImage);
			request.setAttribute(ApplicationConstants.DETAIL_PAGE,
					JspPathConstants.TECHNICAL_ISUUE);
			
			
		}
		
			
			
			
		
		return retList;
	}
}

