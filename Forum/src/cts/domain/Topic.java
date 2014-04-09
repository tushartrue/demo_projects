package cts.domain;

import java.util.Date;
import java.util.Set;

import cts.dao.HibernateUtil;

public class Topic {
	private Integer topic_id;
	private String topic_name;
	private String category;
	private String body;
	private Users user;
	private Date started_date;
	
	private Date last_posted;
	
	
	private String strDate;
	private String lastDate;
	private Integer deletedflag;
	private Set replies;
	private Integer repliesSize;

	public Set getReplies() {
		return replies;
	}
	public void setReplies(Set replies) {
		this.replies = replies;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getDeletedflag() {
		return deletedflag;
	}
	public void setDeletedflag(Integer deletedflag) {
		this.deletedflag = deletedflag;
	}
	public Date getStarted_date() {
		return started_date;
	}
	public void setStarted_date(Date started_date) {
		this.started_date = started_date;
	}
	public Integer getTopic_id() {
		return topic_id;
	}
	public void setTopic_id(Integer topic_id) {
		this.topic_id = topic_id;
	}
	public String getTopic_name() {
		return topic_name;
	}
	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Integer getRepliesSize() {
		return replies.size();
	}
	public void setRepliesSize(Integer repliesSize) {
		this.repliesSize = repliesSize;
	}
	public String getStrDate(){
		
		return HibernateUtil.dateConvertor(started_date.toString());
	}
	public Date getLast_posted() {
		return last_posted;
	}
	public void setLast_posted(Date last_posted) {
		this.last_posted = last_posted;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public String getLastDate() {
		return  HibernateUtil.dateConvertor(last_posted.toString());
	}
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	
/*public String getLastDate(){
		
		return HibernateUtil.dateConvertor(last_posted.toString());
	}*/
	
	

}
