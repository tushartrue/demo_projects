package com.cts.Impl;

import com.cts.dao.FriendsDAO;
import com.cts.framework.exception.FriendExistException;

public class FriendsImpl {
	
	public static void addFriend(String usernum,String friend) throws FriendExistException{
		
		FriendsDAO.addFriend(usernum,friend);
		
	}

}
