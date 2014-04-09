package com.cts.to;


public class PhotosTO {

	private Integer sn;
	private Integer usernum;
	private String  photos;
	private Integer deletedflag;
	private String label;
	public Integer getDeletedflag() {
		return deletedflag;
	}
	public void setDeletedflag(Integer deletedflag) {
		this.deletedflag = deletedflag;
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
	public Integer getUsernum() {
		return usernum;
	}
	public void setUsernum(Integer usernum) {
		this.usernum = usernum;
	}
	
}
