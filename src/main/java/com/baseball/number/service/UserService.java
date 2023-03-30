package com.baseball.number.service;

import com.baseball.number.dao.PointDAO;
import com.baseball.number.dao.UserDAO;
import com.baseball.number.dto.UserDTO;

public class UserService {

	private UserDAO userDAO;
	private PointDAO pointDAO;

	public UserService() {
		userDAO = new UserDAO();
		pointDAO = new PointDAO();
	}

	public int joinUserByInformation(UserDTO userDTO) {
		int resultCount = 0;
		if (userDTO != null)
			resultCount = userDAO.joinUser(userDTO);
		return resultCount;
	}

	public UserDTO loginUserByEmailAndPassword(String email, String password) {
		UserDTO userDTO = null;
		System.out.println(email + "/" + password);
		if (email != null && password != null) {
			userDTO = userDAO.login(email, password);
			System.out.println("service: " + userDTO.toString());
		}
		return userDTO;
	}
	
	public int getPointForWinner(int userId, int point) {
		
		int resultCount = pointDAO.getPoint(userId, point);
		
		return resultCount;
	}

}
