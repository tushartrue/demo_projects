package com.cts.to;

import java.util.Set;

public class UsersTO {
	
	private Integer usernum;
	private String firstname;
	private String username;
	private String lastname;
	private String password;
	private String city;
	private String gender;
	private String organisation;
	private String image;
	private String country;
	private String deletedflag;
	private String aboutme;
	
	private Set scrapbook;
	private Set photos;
	private Set friends;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDeletedflag() {
		return deletedflag;
	}
	public void setDeletedflag(String deletedflag) {
		this.deletedflag = deletedflag;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public Set getFriends() {
		return friends;
	}
	public void setFriends(Set friends) {
		this.friends = friends;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getOrganisation() {
		return organisation;
	}
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	public Set getPhotos() {
		return photos;
	}
	public void setPhotos(Set photos) {
		this.photos = photos;
	}
	public Set getScrapbook() {
		return scrapbook;
	}
	public void setScrapbook(Set scrapbook) {
		this.scrapbook = scrapbook;
	}
	public Integer getUsernum() {
		return usernum;
	}
	public void setUsernum(Integer usernum) {
		this.usernum = usernum;
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
	public String getAboutme() {
		return aboutme;
	}
	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}
	
	

}
