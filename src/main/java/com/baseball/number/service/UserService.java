package com.baseball.number.service;

import java.util.ArrayList;

import com.baseball.number.dto.UserDTO;
import com.baseball.number.repository.PointDAO;
import com.baseball.number.repository.UserDAO;

public class UserService {

	private UserDAO userDAO;
	private PointDAO pointDAO;

	public UserService() {
		userDAO = new UserDAO();
		pointDAO = new PointDAO();
	}

	public int joinUserByInformation(UserDTO userDTO) {
		int resultCount = 0;
		if (userDTO != null) {
			resultCount = userDAO.joinUser(userDTO);
			int userId = userDAO.searchIdByEmail(userDTO.getEmail());
			resultCount += pointDAO.insert(userId);
		}

		return resultCount;
	}

	public UserDTO loginUserByEmailAndPassword(String email, String password) {
		UserDTO userDTO = null;
		if (email != null && password != null) {
			userDTO = userDAO.login(email, password);
		}
		return userDTO;
	}

	public int getPointForWinner(int userId, int point) {

		int resultCount = pointDAO.getPoint(userId, point);

		return resultCount;
	}

	public ArrayList<UserDTO> selectAllUsersPoint(String key) {
		ArrayList<UserDTO> list = new ArrayList<>();

		list = pointDAO.select(key);

		return list;
	}

	public UserDTO selectUsersPointByUserId(int userId) {
		UserDTO userDTO = null;
		userDTO = pointDAO.select(userId);
		return userDTO;
	}

	public int updateUserInfo(UserDTO userDTO, int userId) {
		int resultCount = userDAO.update(userDTO, userId);

		return resultCount;

	}

	public int deleteUser(int userId) {
		int resultCount = pointDAO.delete(userId);
		resultCount += userDAO.delete(userId);

		return resultCount;
	}

	public String searchUserById(int userId) {
		String username = null;
		username = userDAO.searchUser(userId);
		return username;
	}
	
	public int checkEmail(String email) {
		int resultCount = 0;
		resultCount = userDAO.checkEmail(email);
		return resultCount;
	}

	
	public int checkUsername(String username) {
		int resultCount = 0;
		resultCount = userDAO.checkUsername(username);
		return resultCount;
	}

}
