package cts.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

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

public class SearchTopicServlet implements RequestHandler {

	public Object handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List retList = null;
		
		HttpSession session=request.getSession();
		
		Users user=(Users)session.getAttribute("user");
		
		String  topic,category, message ;
		int category_id=0;
		List topicList=null;
		
		String category_id1=(String)request.getParameter("category_id");
		String hide=(String)request.getParameter("hide");
		String search_id=(String)request.getParameter("search_id");
		
		//parameters from reply form
		String topic_name=(String)request.getParameter("topic");
		String postedBy=(String)request.getParameter("postedby");
		String strDate=(String)request.getParameter("startedDate");
		String arr[]=new String[2];
		int i=0;
		
		if(postedBy !=null){
		StringTokenizer posted=new StringTokenizer(postedBy);
		
		while(posted.hasMoreTokens()){
			
			arr[i]=posted.nextToken();
			i++;
			
			if(i==1)
				break;
			
		}
		}
		if(category_id1!=null)
		category_id=Integer.parseInt(category_id1);
		
		Topic topicObj=new Topic();
		
		
		
		TopicDAO topicDAO=new TopicDAO();
		//topicDAO.postTopic(topicObj);
		
		if(search_id==null){
		 topicList=(List)topicDAO.getTopics(Integer.valueOf(category_id));
		}else{
			 topicList=(List)topicDAO.searchTopic(topic_name,arr,strDate,Integer.valueOf(category_id));
			
		}
		request.setAttribute("topicList",topicList);
		request.setAttribute("flag","no");
		
	
		
		if(hide==null){
		request.setAttribute("search","yes");
		}
		
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

