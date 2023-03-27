package com.baseball.number.dao;

import com.baseball.number.dto.UserDTO;

public interface IUserDAO {
	
	int joinUser(UserDTO userDTO);
	
	UserDTO login(String email, String password);
	
}
