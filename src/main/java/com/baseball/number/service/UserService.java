package com.baseball.number.service;

import java.util.ArrayList;

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
		if (userDTO != null) {
			resultCount = userDAO.joinUser(userDTO);
			int userId = userDAO.searchIdByEmail(userDTO.getEmail());
			resultCount += pointDAO.insert(userId);
		}
		
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
	
	public ArrayList<UserDTO> selectAllUsersPoint(String key){
		ArrayList<UserDTO> list = new ArrayList<>();
		
		list = pointDAO.select(key);
		
		return list;
	}
	
	public UserDTO selectUsersPointByUserId(int userId) {
		UserDTO userDTO = null;
	System.out.println("111111111111111");
		userDTO = pointDAO.select(userId);
		System.out.println(userDTO.toString());
		System.out.println("2222222222");
		return userDTO;
	}
	
	public int updateUserInfo(UserDTO userDTO, int userId) {
		int resultCount = userDAO.update(userDTO, userId);
		
		return resultCount;
		
	}
	
	public int deleteUser(int userId) {
		int resultCount = userDAO.delete(userId);
		
		return resultCount;
	}
	
	public static void main(String[] args) {
		new UserService().selectUsersPointByUserId(1);
	}

}
