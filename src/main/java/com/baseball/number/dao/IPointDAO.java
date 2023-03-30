package com.baseball.number.dao;

import java.util.ArrayList;

import com.baseball.number.dto.UserDTO;

public interface IPointDAO {
	
	int insert(int userId);
	
	ArrayList<UserDTO> select(String key); // 전체조회
	
	UserDTO select(int userId); // 유저 조회
	
	int getPoint(int userId, int point); // 유저 점수 획득
	
	int updateWeekpoint(); // 주간 점수 초기화
	
	int updateMonthPoint(); // 월간 점수 초기화
}
