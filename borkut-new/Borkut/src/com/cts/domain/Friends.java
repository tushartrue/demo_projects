package com.cts.domain;

public class Friends {
	
	private Integer sn;
	private Users usernum;
	private Users friendnum;
	private Integer deletedflag;
	public Integer getDeletedflag() {
		return deletedflag;
	}
	public void setDeletedflag(Integer deletedflag) {
		this.deletedflag = deletedflag;
	}
	public Users getFriendnum() {
		return friendnum;
	}
	public void setFriendnum(Users friendnum) {
		this.friendnum = friendnum;
	}
	public Integer getSn() {
		return sn;
	}
	public void setSn(Integer sn) {
		this.sn = sn;
	}
	public Users getUsernum() {
		return usernum;
	}
	public void setUsernum(Users usernum) {
		this.usernum = usernum;
	}
	
	
	

}
