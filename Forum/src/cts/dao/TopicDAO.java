package cts.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import cts.domain.Topic;
import cts.domain.TopicReply;
import cts.domain.Users;

public class TopicDAO {

	public List getTopics(Integer category_id) {

		SessionFactory sf = null;
		Session session = null;
		sf = HibernateUtil.getSessionFactory();
		session = sf.openSession();

		Criteria criteria = session.createCriteria(Topic.class);

		criteria.add(Restrictions.eq("deletedflag", Integer.valueOf(0)));

		if (category_id == 1)
			criteria.add(Restrictions.eq("category", "housing"));

		else if (category_id == 2)
			criteria.add(Restrictions.eq("category", "byesell"));

		else if (category_id == 3)
			criteria.add(Restrictions.eq("category", "technical"));

		criteria.addOrder(Order.desc("last_posted"));

		List topicList = (List) criteria.list();

		return topicList;

	}

	public void postTopic(Topic topicparam) {

		SessionFactory sf = null;
		Session session = null;
		sf = HibernateUtil.getSessionFactory();
		session = sf.openSession();

		try {
			Transaction tr = session.beginTransaction();
			session.save(topicparam);
			tr.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// method to get details of topic related to topic_id
	public Topic getDetailTopic(String topic_id) {

		SessionFactory sf = null;
		Session session = null;
		sf = HibernateUtil.getSessionFactory();
		session = sf.openSession();

		Topic topicObj = (Topic) session.get(Topic.class, Integer
				.valueOf(topic_id));
		return topicObj;

	}

	// method to get all replies related to topic_id
	public List getTopicReplies(String topic_id) {

		SessionFactory sf = null;
		Session session = null;
		sf = HibernateUtil.getSessionFactory();
		session = sf.openSession();

		Criteria criteria = session.createCriteria(TopicReply.class);
		criteria.add(Restrictions.eq("topic_id", Integer.valueOf(topic_id)));
		criteria.add(Restrictions.eq("deletedflag", Integer.valueOf("0")));
		criteria.addOrder(Order.desc("sn"));
		List repliesList = (List) criteria.list();
		return repliesList;

	}

	// method to post reply.
	public void postReply(TopicReply topicReply) {
		SessionFactory sf = null;
		Session session = null;
		sf = HibernateUtil.getSessionFactory();
		session = sf.openSession();

		Transaction tr = session.beginTransaction();

		session.save(topicReply);

		Topic topicOb = (Topic) session.get(Topic.class, topicReply
				.getTopic_id());

		topicOb.setLast_posted(topicReply.getLast_posted());
		session.saveOrUpdate(topicOb);

		tr.commit();

	}

	public List searchTopic(String topic_name, String arr[], String strDate,
			Integer category_id) {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		Date myDate = new Date();

		try {
			myDate = df.parse(strDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		SessionFactory sf = null;
		Session session = null;
		sf = HibernateUtil.getSessionFactory();
		session = sf.openSession();
		String fname, lname = null;
		if (arr.length > 1) {
			fname = arr[0];
			lname = arr[1];
		} else {
			fname = arr[0];
		}

		// criteria one

		Criteria criteria1 = session.createCriteria(Topic.class);

		if (topic_name != null) {

			criteria1.add(Restrictions.like("topic_name",
					"%" + topic_name + "%").ignoreCase());
		}
		if (fname != null) {
			criteria1.add(Property.forName("user").in(
					getFirstNamekey("%" + fname + "%")));

		}
		if (lname != null) {
			criteria1.add(Property.forName("user").in(
					getLastNamekey("%" + lname + "%")));

		}
		criteria1.add(Restrictions.eq("deletedflag", Integer.valueOf("0")));

		if (category_id == 1)
			criteria1.add(Restrictions.eq("category", "housing"));

		else if (category_id == 2)
			criteria1.add(Restrictions.eq("category", "byesell"));

		else if (category_id == 3)
			criteria1.add(Restrictions.eq("category", "technical"));

		List topicList1 = (List) criteria1.list();

		// criteria second
		// checking for another condition

		Criteria criteria2 = session.createCriteria(Topic.class);

		if (topic_name != null) {

			criteria2.add(Restrictions.like("topic_name",
					"%" + topic_name + "%").ignoreCase());
		}
		if (fname != null) {
			criteria2.add(Property.forName("user").in(
					getLastNamekey("%" + fname + "%")));

		}
		if (lname != null) {
			criteria2.add(Property.forName("user").in(
					getFirstNamekey("%" + lname + "%")));

		}
		criteria2.add(Restrictions.eq("deletedflag", Integer.valueOf("0")));

		if (category_id == 1)
			criteria2.add(Restrictions.eq("category", "housing"));

		else if (category_id == 2)
			criteria2.add(Restrictions.eq("category", "byesell"));

		else if (category_id == 3)
			criteria2.add(Restrictions.eq("category", "technical"));

		List topicList2 = (List) criteria2.list();

		List newList = null;
		if (topicList1.size() > topicList2.size()) {
			newList = topicList1;
		} else {

			newList = topicList2;
		}

		if (strDate != "") {
			SimpleDateFormat sdfDestination = new SimpleDateFormat("MM/dd/yyyy");

			List dateList = new ArrayList();
			Iterator itr = newList.iterator();
			while (itr.hasNext()) {

				Topic topic = (Topic) itr.next();

				Date dbDate = topic.getStarted_date();

				String DBDate = sdfDestination.format(dbDate);
				System.out.println("strDate--" + strDate);
				System.out.println("DBDate--" + DBDate);
				if (strDate.equalsIgnoreCase(DBDate)) {
					dateList.add(topic);
				}

			}

			return dateList;
		} else {

			return newList;
		}

	}

	// method to delete topic

	public void deleteTopic(String topic_id) {

		SessionFactory sf = null;
		Session session = null;
		sf = HibernateUtil.getSessionFactory();
		session = sf.openSession();

		Topic topic = (Topic) session.get(Topic.class, Integer
				.valueOf(topic_id));

		Transaction tr = session.beginTransaction();

		topic.setDeletedflag(Integer.valueOf("1"));

		session.saveOrUpdate(topic);

		tr.commit();
		
		Query qr=session.createSQLQuery("select sn  from TOPICREPLY where topic_id="+Integer.valueOf( topic_id));
		
		
		List replies=qr.list();
		
		Iterator iterator=replies.iterator();
		
		while(iterator.hasNext()){
			
			Integer i1=(Integer )iterator.next();
			
			Transaction tr1=session.beginTransaction();
			
			TopicReply  tp=(TopicReply) session.get(TopicReply.class,i1);
			
			tp.setDeletedflag(Integer.valueOf("1"));
			
			tr1.commit();
		}
		
		
		
		
		session.disconnect();

	}

	private DetachedCriteria getFirstNamekey(String fname) {
		final DetachedCriteria fstname = DetachedCriteria.forClass(Users.class)
				.setProjection(Property.forName("usernum")).add(
						Property.forName("firstname").like(fname).ignoreCase());

		return fstname;
	}

	private DetachedCriteria getLastNamekey(String lname) {
		final DetachedCriteria fstname = DetachedCriteria.forClass(Users.class)
				.setProjection(Property.forName("usernum")).add(
						Property.forName("lastname").like(lname).ignoreCase());

		return fstname;
	}

}
