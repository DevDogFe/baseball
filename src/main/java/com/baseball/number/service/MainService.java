package com.baseball.number.service;

import com.baseball.number.dao.NumberDAO;

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
	
	public static void main(String[] args) {
		int [] nums = new MainService().selectNumbers(1);
		System.out.println(nums);
		for (int i : nums) {
			System.out.println(i);
		}
		
		if(nums == null) {
			System.out.println("하이");
		}
		
	}

}
