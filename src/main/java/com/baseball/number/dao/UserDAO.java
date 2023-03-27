package com.baseball.number.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.baseball.number.dto.UserDTO;
import com.baseball.number.utils.DBHelper;

public class UserDAO implements IUserDAO{
	private DBHelper dbHelper;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() {
		dbHelper = DBHelper.getInstance();
	}

	@Override
	public int joinUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserDTO login(String email, String password) {
		conn = dbHelper.getConnection();
		String sql = " SELECT * FROM users "
				+ " WHERE email = ? AND password = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public int update(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
