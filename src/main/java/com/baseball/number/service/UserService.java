package com.baseball.number.service;

import com.baseball.number.dao.UserDAO;
import com.baseball.number.dto.UserDTO;

public class UserService {
	
	private UserDAO userDAO;
	
	public UserService() {
		userDAO = new UserDAO();
	}
	
	public int joinUserByInformation(UserDTO userDTO) {
		int resultCount = 0;
		
		resultCount = userDAO.joinUser(userDTO);
		
		return resultCount;
	}
	
}
