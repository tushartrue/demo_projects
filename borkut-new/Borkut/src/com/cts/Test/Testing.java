package com.cts.Test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cts.dao.HibernateUtil;
import com.cts.domain.Scrapbook;



public class Testing{
	
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			SessionFactory sf=null;
			Session session=null;
			sf=HibernateUtil.getSessionFactory();
			session=sf.openSession();
			
			Scrapbook scrapbook=new Scrapbook();
			
			scrapbook.setScraps("Hi how r u?");
			//scrapbook.setUsernum(Integer.valueOf("1001"));
			scrapbook.setDeletedflag(Integer.valueOf("0"));
			
			Transaction transaction=session.beginTransaction();
			session.save(scrapbook);
			transaction.commit();
		}

}

