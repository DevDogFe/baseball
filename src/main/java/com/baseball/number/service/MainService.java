package com.baseball.number.service;

import com.baseball.number.dao.NumberDAO;

public class MainService {
	
	private NumberDAO numberDAO;
	
	public MainService() {
		numberDAO = new NumberDAO();
	}
	
	public int insertNumbers(int userId) {
		int resultCount = numberDAO.insert(userId);
		
		return resultCount;
	}
	
	public int[] selectNumbers(int userId) {
		int[] nums = numberDAO.select(userId);
		
		return nums;
	}
	
	public int deleteNumbers(int userId) {
		int resultCount = numberDAO.delete(userId);
		
		return resultCount;
	}

}
