package cts.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cts.domain.Users;
import cts.framework.exception.AccountNotFoundException;
import cts.framework.exception.InvalidPasswordException;

public class UsersDAO {
	
	public void createNewAccount(Users users){
		
		SessionFactory sf=null;
		Session session=null;
		sf=HibernateUtil.getSessionFactory();
		session=sf.openSession();
		try{
		Transaction tr= session.beginTransaction();
		session.save(users);
		tr.commit();
		}
		catch(Exception e){
			
		}finally{
			session.disconnect();
		}
	}
	
	public Users authenticate(String username,String password) throws InvalidPasswordException,AccountNotFoundException{
		
		SessionFactory sf=null;
		Session session=null;
		sf=HibernateUtil.getSessionFactory();
		session=sf.openSession();
		Users user=null;
		
		try {
			final Query query=session.createSQLQuery("select usernum from USERS where username="+"'"+username+"'");
			List userList=(List)query.list();
			
			 if(userList.size()==0){
				 throw new AccountNotFoundException();
				 
			 }
			 Integer usernum=(Integer)userList.get(0);
			 
			 Criteria criteria=session.createCriteria(Users.class);
			 
			 criteria.add(Restrictions.eq("usernum",usernum));
			 
			 criteria.add(Restrictions.eq("deletedflag",Integer.valueOf(0)));
			 List userList1=(List)criteria.list();
			 
			 
			user=(Users) userList1.get(0);
			
			if(!user.getPassword().equals(password)){
				throw new InvalidPasswordException();
				
				
			}
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}

}
