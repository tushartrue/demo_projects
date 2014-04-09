package cts.dao;

import java.text.SimpleDateFormat;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	static {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	 public static String dateConvertor(String dt) {

			String result = null;
			//SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yy");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String s1 = dt;
			s1 = s1.substring(0, s1.indexOf('.'));
			try {
				//System.out.println("Result==> " + sdf1.format(sdf2.parse(s1)));
				result = sdf1.format(sdf2.parse(s1));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
	 
	 public static String dateConvertor2(String dt) {

			String result = null;
			//SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yy   HH:mm");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String s1 = dt;
			s1 = s1.substring(0, s1.indexOf('.'));
			try {
				//System.out.println("Result==> " + sdf1.format(sdf2.parse(s1)));
				result = sdf1.format(sdf2.parse(s1));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
	 
	 public static String dateCompare(String dt) {

			String result = null;
			//SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
			//SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yy   HH:mm");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			String s1 = dt;
			s1 = s1.substring(0, s1.indexOf('.'));
			try {
				System.out.println("Result==> " + sdf1.format(sdf2.parse(s1)));
				result = sdf1.format(sdf2.parse(s1));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
}


