package com.cts.domain;

public class Photos {
private Integer sn;
private Users usernum;
private String  photos;
private Integer deletedflag;
private String label;
public Integer getDeletedflag() {
	return deletedflag;
}
public String getLabel() {
	return label;
}
public void setLabel(String label) {
	this.label = label;
}
public String getPhotos() {
	return photos;
}
public void setPhotos(String photos) {
	this.photos = photos;
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
public void setDeletedflag(Integer deletedflag) {
	this.deletedflag = deletedflag;
}


}
