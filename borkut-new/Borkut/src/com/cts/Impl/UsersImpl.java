package com.cts.Impl;

import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.HibernateException;

import sun.misc.BASE64Encoder;

import com.cts.dao.UsersDAO;
import com.cts.domain.Users;
import com.cts.framework.exception.AlreadyExistsException;
import com.cts.framework.exception.InvalidPasswordException;
import com.cts.to.UsersTO;

public class UsersImpl {
	
//	method to create new account of user
	public void createNewAccount(UsersTO usersTO) throws AlreadyExistsException {
		Users user = new Users();
		String encryptedPassword = encryption(usersTO.getPassword());

		user.setUsername(usersTO.getUsername());
		user.setFirstname(usersTO.getFirstname());
		user.setLastname(usersTO.getLastname());
		user.setGender(usersTO.getGender());
		user.setOrganisation(usersTO.getOrganisation());
		user.setCity(usersTO.getCity());
		user.setCountry(usersTO.getCountry());
		
		user.setPassword(encryptedPassword);
		user.setDeletedflag(Integer.valueOf("0"));

		UsersDAO usersDAO = new UsersDAO();
		usersDAO.createNewAccount(user);

	}

	//method to encrypt password
	public String encryption(String password) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		messageDigest.update(password.getBytes());
		BASE64Encoder base64Encoder = new BASE64Encoder();

		String encryptedPassword = base64Encoder.encode(messageDigest.digest());
		System.out.println("Encrypt:" + encryptedPassword);

		return encryptedPassword;

	}

	public Users  authenticateUser(String username, String password) 
	throws IndexOutOfBoundsException,HibernateException,InvalidPasswordException{

		Users userparam = UsersDAO.authenticateUser(username);
		if(password==null){
			return userparam;
		}
		
		String encryptedPassword = encryption(password);
		
		if(encryptedPassword.equals(userparam.getPassword()))
		{
			return userparam;
			
		}else{
			
			throw new InvalidPasswordException();
		}
		
		

	}
	
	public Users fetchProfile(String usernum){
		Users users=(Users)UsersDAO.fetchProfile(usernum);
		return users;
	}
	
	public Users editProfile(UsersTO userTO){
		
		Users userparam=new Users();
		try {
			BeanUtils.copyProperties(userparam,userTO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Users users=(Users)UsersDAO.editProfile(userparam);
		return users;
	}
	
	
	public List searchUsers(String firstname,String lastname,String city){
		List retUsers=UsersDAO.searchUsers(firstname,lastname,city);
		
		return retUsers;
	}
}
