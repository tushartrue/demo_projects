package com.cts.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.cts.domain.Photos;
import com.cts.domain.Users;

public class PhotosDAO  extends BaseDAO{

	
		public void loadAlbum(String usernum,String image,String label)throws HibernateException{
			
			Session session = null;
			session = getSessionFactory().openSession();
			
			
			
			Photos photosTO=new Photos();
			
			photosTO.setLabel(label);
			photosTO.setPhotos(image);
			
			Users users=new Users();
			users.setUsernum(Integer.valueOf(usernum));
			photosTO.setUsernum(users);
			photosTO.setDeletedflag(Integer.valueOf("0"));
			
			List listPhotos=null;
			
				Transaction transaction = session.beginTransaction();
				session.save(photosTO);
				transaction.commit();
				session.disconnect();
				
				
		
		
		}
		
		public static List getPhotos(String usernum){
			Session session = null;
			session = getSessionFactory().openSession();
			final Criteria criteria=session.createCriteria(Photos.class);
			Users userparam=new Users();
			userparam.setUsernum(Integer.valueOf(usernum));
			
			List retPhotos=null;
			try {
				criteria.add(Restrictions.eq("usernum",userparam));
				
				criteria.add(Restrictions.eq("deletedflag",Integer.valueOf("0")));
				
				criteria.addOrder(Order.desc("sn"));
				
				retPhotos = criteria.list();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return retPhotos;
			
		}
		
		public void deletePhoto(String sn)
		{
			
			Session session = null;
			session = getSessionFactory().openSession();
			
			try {
				
				
				Photos photosparam=(Photos)session.get(Photos.class,Integer.valueOf(sn));
				photosparam.setDeletedflag(Integer.valueOf("1"));
				Transaction tx=session.beginTransaction();
				session.save(photosparam);
				tx.commit();
				
				session.disconnect();
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
}
