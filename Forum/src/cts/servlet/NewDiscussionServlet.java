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
import cts.domain.Users;
import cts.framework.util.ApplicationConstants;
import cts.framework.util.JspPathConstants;

public class NewDiscussionServlet implements RequestHandler {

	public Object handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List retList = null;
		
		HttpSession session=request.getSession();
		
		Users user=(Users)session.getAttribute("user");
		
		String  topic,category, message ;
		int category_id=0;
		topic = request.getParameter("topic");
		category = request.getParameter("categoryList");
		message = request.getParameter("message");
		
		String general=request.getParameter("general");
		
		
		
		Topic topicObj=new Topic();
		
		topicObj.setCategory(category);
		topicObj.setTopic_name(topic);
		topicObj.setBody(message);
		topicObj.setDeletedflag(Integer.valueOf(0));
		topicObj.setUser(user);
		topicObj.setStarted_date(new Date());
		topicObj.setLast_posted(new Date());
		
		TopicDAO topicDAO=new TopicDAO();
		topicDAO.postTopic(topicObj);
		
		if(general!=null){
			if(general.equalsIgnoreCase("0"))
			category_id=0;
		}else if(category.equalsIgnoreCase("housing")){
			
			category_id=1;
		}else if(category.equalsIgnoreCase("byesell")){
			category_id=2;
			
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
		
			
			// UsersImpl usersImpl = new UsersImpl();

			/*try {
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
			}*/

			
			
			
		
		return retList;
	}
}

