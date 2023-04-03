package com.baseball.number.service;

import com.baseball.number.repository.NumberDAO;

public class MainService {
	
	private NumberDAO numberDAO;
	
	public MainService() {
		numberDAO = new NumberDAO();
	}
	
	public int[] insertNumbers(int userId) {
		int resultCount = numberDAO.insert(userId);
		numberDAO.tryCountUp(userId);
		int[] nums = numberDAO.select(userId);
		return nums;
	}
	
	public int[] selectNumbers(int userId) {
		numberDAO.tryCountUp(userId);
		int[] nums = numberDAO.select(userId);
		
		return nums;
	}
	
	public int deleteNumbers(int userId) {
		int resultCount = numberDAO.delete(userId);
		
		return resultCount;
	}
	


}
