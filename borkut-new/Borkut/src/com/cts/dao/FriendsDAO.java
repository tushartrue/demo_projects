package com.cts.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.cts.domain.Friends;
import com.cts.domain.Users;
import com.cts.framework.exception.FriendExistException;

public class FriendsDAO  extends BaseDAO{
	
	public static void addFriend(String usernum,String friend) throws FriendExistException{
		
		
		
		

		Session session = null;
		session = getSessionFactory().openSession();
		
		Users usercheck1=new Users();
		usercheck1.setUsernum(Integer.valueOf(usernum));
		
		Users usercheck2=new Users();
		usercheck2.setUsernum(Integer.valueOf(friend));
		
		Criteria crt= session.createCriteria(Friends.class);
		crt.add(Restrictions.eq("usernum",usercheck1));
		
		crt.add(Restrictions.eq("friendnum",usercheck2));
		List friendList=crt.list();
		
		
			if(friendList.size()!=0){
				
				throw new FriendExistException();
			}
		Users userparam=new Users();
		userparam.setUsernum(Integer.valueOf(usernum));
		
		Users friendparam=new Users();
		friendparam.setUsernum(Integer.valueOf(friend));
		
		Friends friends=new Friends();
		
		friends.setUsernum(userparam);
		friends.setFriendnum(friendparam);
		friends.setDeletedflag(Integer.valueOf("0"));
		
		Transaction tx1=session.beginTransaction();
		session.save(friends);
		tx1.commit();
		
		Friends friends2=new Friends();
		friends2.setUsernum(friendparam);
		friends2.setFriendnum(userparam);
		friends2.setDeletedflag(Integer.valueOf("0"));
		
		Transaction tx2=session.beginTransaction();
		session.save(friends2);
		tx2.commit();
		
		
		
		
	}

}
