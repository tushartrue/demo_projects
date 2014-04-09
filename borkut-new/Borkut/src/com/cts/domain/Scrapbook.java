package com.cts.domain;

import java.util.Date;

public class Scrapbook {
	private Integer sn;
	private Users usernum;
	private String scraps;
	private Integer deletedflag;
	private Users friend;
	private Date createddate;
	
	
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public Integer getDeletedflag() {
		return deletedflag;
	}
	public void setDeletedflag(Integer deletedflag) {
		this.deletedflag = deletedflag;
	}
	public String getScraps() {
		return scraps;
	}
	public void setScraps(String scraps) {
		this.scraps = scraps;
	}
	public Integer getSn() {
		return sn;
	}
	public void setSn(Integer sn) {
		this.sn = sn;
	}
	public Users getFriend() {
		return friend;
	}
	public void setFriend(Users friend) {
		this.friend = friend;
	}
	public Users getUsernum() {
		return usernum;
	}
	public void setUsernum(Users usernum) {
		this.usernum = usernum;
	}
	
	
	
	
	
}
