package cts.domain;

public class Users {
	private Integer usernum;
	private String username;
	private String firstname;
	private String lastname;
	private String password;
	private Integer deletedflag;
	private String name;
	public Integer getDeletedflag() {
		return deletedflag;
	}
	public void setDeletedflag(Integer deletedflag) {
		this.deletedflag = deletedflag;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getUsernum() {
		return usernum;
	}
	public void setUsernum(Integer usernum) {
		this.usernum = usernum;
	}
	
	public String getName(){
		return lastname+","+firstname;
	}

}
