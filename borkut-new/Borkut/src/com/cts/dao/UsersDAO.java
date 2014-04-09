package com.cts.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.GenericJDBCException;

import com.cts.domain.Friends;
import com.cts.domain.Photos;
import com.cts.domain.Scrapbook;
import com.cts.domain.Users;
import com.cts.framework.exception.AlreadyExistsException;

public class UsersDAO extends BaseDAO{
	
	public void createNewAccount(Users user)throws AlreadyExistsException{
		Session session = null;
		session = getSessionFactory().openSession();
		
		
		StringBuffer sb=new StringBuffer();
		sb.append("select XJAIUSERNUM from W_USR_JAI where XJAIUSERNAME="+"'"+user.getUsername()+"'");
		
		final Query countQuery = session.createSQLQuery(sb.toString());
		
		List accountList=countQuery.list();
		
		if(accountList.size()!=0){ 
			throw new AlreadyExistsException();
			
		}else{
		
		Transaction transaction = session.beginTransaction();
		session.save(user);
		try {
			transaction.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.disconnect();
		
	}}
	
	public static Users authenticateUser(String username) throws IndexOutOfBoundsException,HibernateException{
		Session session = null;
		int num=0;

		session = getSessionFactory().openSession();

		
		StringBuffer sb=new StringBuffer();
		sb.append("select XJAIUSERNUM from W_USR_JAI where XJAIUSERNAME="+"'"+username+"'");
		
		Users users=null;
		List retList=null;
		
			final Query countQuery = session.createSQLQuery(sb.toString());
			BigDecimal uNum;
			
				//uNum = (BigDecimal)countQuery.list().get(0);
				
				List rList = countQuery.list();
				 //num=uNum.intValue();
				Integer n=(Integer)rList.get(0);
			
			
			
			// users = (Users) session.get(Users.class, new Integer(num));
			
			Criteria criteria=session.createCriteria(Users.class);
			
			criteria.add(Restrictions.eq("usernum",n)).addOrder(Order.desc("usernum"));
			
			criteria.add(Restrictions.eq("deletedflag",Integer.valueOf("0")));
			
			
			 users=(Users)criteria.list().get(0);
			 
			 Set scrapSet=UsersDAO.fetchScrapSet(users.getScrapbook());
			 users.setScrapbook(scrapSet);
			 
			 Set friendSet=UsersDAO.fetchFriendSet(users.getFriends());
			 users.setFriends(friendSet);
			 
			 Set photosSet=UsersDAO.fetchPhotosSet(users.getPhotos());
			 users.setPhotos(photosSet);
			 
			
			
		
		
		 session.disconnect();
		 //throw new HibernateException("");
		
		return users;
		
	}
	
	public static Users fetchProfile(String usernum){
		Session session = null;
		Users users=null;
		
		
		session = getSessionFactory().openSession();
		 //users = (Users) session.get(Users.class, Integer.valueOf(usernum));
		Criteria criteria=session.createCriteria(Users.class);
		
		criteria.add(Restrictions.eq("usernum",Integer.valueOf(usernum))).addOrder(Order.desc("usernum"));
		
		criteria.add(Restrictions.eq("deletedflag",Integer.valueOf("0")));
		
		
		 users=(Users)criteria.list().get(0);
		 
		 Set scrapSet=UsersDAO.fetchScrapSet(users.getScrapbook());
		 users.setScrapbook(scrapSet);
		 
		 Set friendSet=UsersDAO.fetchFriendSet(users.getFriends());
		 users.setFriends(friendSet);
		 
		 Set photosSet=UsersDAO.fetchPhotosSet(users.getPhotos());
		 users.setPhotos(photosSet);
		 
		 session.disconnect();
		 return users;
	}
	
	//method to edit profile of user.
	public static Users editProfile(Users userparam){
		Session session = null;
		Users users=null;

		session = getSessionFactory().openSession();
		 users = (Users) session.get(Users.class, userparam.getUsernum());
		 
		
		 users.setFirstname(userparam.getFirstname());
		 users.setLastname(userparam.getLastname());
		 users.setCity(userparam.getCity());
		 users.setOrganisation(userparam.getOrganisation());
		 
		
		 users.setAboutme(userparam.getAboutme());
		 users.setGender(userparam.getGender());
		 
		 if(userparam.getImage()!=null)
		 users.setImage(userparam.getImage());
		 users.setCountry(userparam.getCountry());
		 
		 Transaction transaction=session.beginTransaction();
		 session.save(users);
		 transaction.commit();
		 
		 session.disconnect();
		 return users;
		
		
	}
	
	
	//method to add records only with deletedflag=0)
	public static Set fetchScrapSet(Set entitySet){
		
		HashSet realentitySet=new HashSet();
		
		Iterator scrapIterator=entitySet.iterator(); 
		while(scrapIterator.hasNext())
		{
			Scrapbook scrap=(Scrapbook)scrapIterator.next();
			if(scrap.getDeletedflag().equals(Integer.valueOf("0"))){
				realentitySet.add(scrap);
			}
		}
		return realentitySet;
		
		
	}
	
public static Set fetchFriendSet(Set entitySet){
		
		HashSet realentitySet=new HashSet();
		
		Iterator friendIterator=entitySet.iterator(); 
		while(friendIterator.hasNext())
		{
			Friends friend=(Friends)friendIterator.next();
			if(friend.getDeletedflag().equals(Integer.valueOf("0"))){
				realentitySet.add(friend);
			}
		}
		return realentitySet;
		
		
	}

public static Set fetchPhotosSet(Set entitySet){
	
	HashSet realentitySet=new HashSet();
	
	Iterator photoIterator=entitySet.iterator(); 
	while(photoIterator.hasNext())
	{
		Photos photo=(Photos)photoIterator.next();
		if(photo.getDeletedflag().equals(Integer.valueOf("0"))){
			realentitySet.add(photo);
		}
	}
	return realentitySet;
	
	
}

public static List searchUsers(String firstname,String lastname,String city){
	
	Session session = null;

	session = getSessionFactory().openSession();
	
	final Criteria criteria=session.createCriteria(Users.class);
	
	if(firstname!="" )
	if(firstname!=null)
	criteria.add(Restrictions.like("firstname",firstname+"%").ignoreCase());
	
	if(lastname!="" )
		if(lastname!=null)
		criteria.add(Restrictions.like("lastname",lastname+"%").ignoreCase());
	
	if(city!="" )
		if(city!=null)
		criteria.add(Restrictions.like("city",city+"%").ignoreCase());
	
	criteria.add(Restrictions.eq("deletedflag",Integer.valueOf("0")));
	
	List retUsers=criteria.list();
	
	return retUsers;

	
}

}
