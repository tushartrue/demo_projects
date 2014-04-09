package com.cts.Impl;

import java.util.List;

import org.hibernate.HibernateException;

import com.cts.dao.PhotosDAO;
import com.cts.dao.ScrapbookDAO;

public class PhotosImpl {
	
	public void loadAlbum(String usernum,String image,String label)throws HibernateException{
		
		PhotosDAO photosDAO=new PhotosDAO();
		photosDAO.loadAlbum(usernum,image,label);
		
	}
	
	public List getPhotos(String usernum){
		
		List retPhotos=PhotosDAO.getPhotos(usernum);
		return retPhotos;
			
		}
	
	public void deletePhotos(String sn){
		PhotosDAO photosDAO=new PhotosDAO();
		photosDAO.deletePhoto(sn);
	
	}

}
