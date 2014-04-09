package cts.domain;

import java.util.Date;

public class TopicReply {
	
	private Integer sn;
	private Integer topic_id;
	private Users replied_user;
	private String reply;
	private Date last_posted;
	private Integer deletedflag;
	public Integer getDeletedflag() {
		return deletedflag;
	}
	public void setDeletedflag(Integer deletedflag) {
		this.deletedflag = deletedflag;
	}
	public Date getLast_posted() {
		return last_posted;
	}
	public void setLast_posted(Date last_posted) {
		this.last_posted = last_posted;
	}
	public Users getReplied_user() {
		return replied_user;
	}
	public void setReplied_user(Users replied_user) {
		this.replied_user = replied_user;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public Integer getTopic_id() {
		return topic_id;
	}
	public void setTopic_id(Integer topic_id) {
		this.topic_id = topic_id;
	}
	public Integer getSn() {
		return sn;
	}
	public void setSn(Integer sn) {
		this.sn = sn;
	}
	
	
	

}
