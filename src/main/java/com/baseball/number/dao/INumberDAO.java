package com.baseball.number.dao;

public interface INumberDAO {
	int insert(int userId); // 숫자 저장
	
	int[] select(int userId);
	
	int delete(int userId);
}
