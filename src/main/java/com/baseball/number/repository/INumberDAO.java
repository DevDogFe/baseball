package com.baseball.number.repository;

public interface INumberDAO {
	int insert( int userId); // 숫자 저장
	
	int[] select(int userId);
	
	int delete(int userId);
	
	int tryCountUp(int userId); // tryCount++
}
