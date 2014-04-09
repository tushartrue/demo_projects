package com.cts.Impl;

import java.util.List;

import com.cts.dao.ScrapbookDAO;

public class ScrapbookImpl {
	
	public void postScrap(String usernum,String friend,String scrap){
		
		ScrapbookDAO scrapDAO=new ScrapbookDAO();
		scrapDAO.postScrap(usernum,friend,scrap);
	}



	public void deleteScrap(String sn){
		ScrapbookDAO scrapDAO=new ScrapbookDAO();
		scrapDAO.deleteScrap(sn);
	
	}
	
	public List getScraps(String usernum){
		
	List retScraps=ScrapbookDAO.getScraps(usernum);
	return retScraps;
		
	}
}