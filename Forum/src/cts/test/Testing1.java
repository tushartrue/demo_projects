package cts.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cts.dao.HibernateUtil;
import cts.domain.Users;

public class Testing1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		SessionFactory sf=null;
		Session session=null;
		sf=HibernateUtil.getSessionFactory();
		session=sf.openSession();
		
		Users users=new Users();
		
		users.setUsername("tusharfasate");
		users.setFirstname("tushar");
		users.setLastname("fasate");
		users.setPassword("123");
		users.setDeletedflag(Integer.valueOf(0));
		
		Transaction tr=session.beginTransaction();
		session.save(users);
		tr.commit();
		session.disconnect();
		

	}

}
