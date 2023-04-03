package com.baseball.number.repository;

import com.baseball.number.dto.UserDTO;

public interface IUserDAO {
	
	//회원가입
	int joinUser(UserDTO userDTO);
	//로그인
	UserDTO login(String email, String password);
	//회원정보 수정
	int update(UserDTO userDTO, int userId);
	//회원 탈퇴
	int delete(int userId);
	
	int searchIdByEmail(String email);
	
	String searchUser(int userId);
	
	
}
