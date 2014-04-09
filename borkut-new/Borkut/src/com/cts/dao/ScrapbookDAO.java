package com.cts.dao;



import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.cts.domain.Scrapbook;
import com.cts.domain.Users;

public class ScrapbookDAO extends BaseDAO{
	
	public void postScrap(String usernum,String friend,String scrap){
		
		Session session = null;
		session = getSessionFactory().openSession();
		Scrapbook scrapbook=new Scrapbook();
		
		Users userparam=new Users();
		userparam.setUsernum(Integer.valueOf(usernum));
		
		Users friendparam=new Users();
		friendparam.setUsernum(Integer.valueOf(friend));
		
		scrapbook.setUsernum(friendparam);
		scrapbook.setFriend( userparam);
		scrapbook.setScraps(scrap);
		scrapbook.setDeletedflag(Integer.valueOf("0"));
		scrapbook.setCreateddate(new Date());
		
		try {
			Transaction transaction =  session.beginTransaction();
			session.save(scrapbook);
			transaction.commit();
			session.disconnect();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
}
	
	public void deleteScrap(String sn)
	{
		
		Session session = null;
		session = getSessionFactory().openSession();
		
		try {
			/*//final Query query=session.createQuery("delete from TUSHAR_SCRAPBOOK where sn="+Integer.valueOf(sn)+"");
			
			String hql="delete from TUSHAR_SCRAPBOOK where sn="+Integer.valueOf(sn);
			//String hql="select *from TUSHAR_SCRAPBOOK where sn="+;
			
			Query query2 = session.createQuery(hql);
		      int row = query2.executeUpdate();
		      */
			
			
			Scrapbook sc=(Scrapbook)session.get(Scrapbook.class,Integer.valueOf(sn));
			sc.setDeletedflag(Integer.valueOf("1"));
			Transaction tx=session.beginTransaction();
			session.save(sc);
			tx.commit();
			
			
			//int row =query.executeUpdate();
			session.disconnect();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List getScraps(String usernum){
		Session session = null;
		session = getSessionFactory().openSession();
		final Criteria criteria=session.createCriteria(Scrapbook.class);
		Users userparam=new Users();
		userparam.setUsernum(Integer.valueOf(usernum));
		
		List retScraps=null;
		try {
			criteria.add(Restrictions.eq("usernum",userparam));
			
			criteria.add(Restrictions.eq("deletedflag",Integer.valueOf("0")));
			
			criteria.addOrder(Order.desc("sn"));
			
			retScraps = criteria.list();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retScraps;
		
	}
}