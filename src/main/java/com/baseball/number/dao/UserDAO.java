package com.baseball.number.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.baseball.number.dto.UserDTO;
import com.baseball.number.dto.UserDTO.Builder;
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
		int resultCount = 0;
		String queryStr = " INSERT INTO users(email, username, password) VALUES "
				+ "(?, ?, ?) ";
		conn = dbHelper.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setString(1, userDTO.getEmail());
			pstmt.setString(2, userDTO.getUsername());
			pstmt.setString(3, userDTO.getPassword());
			resultCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				dbHelper.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultCount;
	}

	@Override
	public UserDTO login(String email, String password) {
		UserDTO userDTO = null;
		conn = dbHelper.getConnection();
		String sql = " SELECT * FROM users "
				+ " WHERE email = ? AND password = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int userId = rs.getInt("id");
				String userEmail = rs.getString("email");
				String username = rs.getString("username");
				String userRole = rs.getString("userRole");
				
				userDTO = new Builder().setUserId(userId).setEmail(userEmail).setUsername(username).setUserRole(userRole).build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				dbHelper.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userDTO;
	}

	@Override
	public int update(UserDTO userDTO, int userId) {
		int resultCount = 0;
		String queryStr = " UPDATE users SET username = ?, password = ? WHERE id = ? ";
		conn = dbHelper.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setString(1, userDTO.getUsername());
			pstmt.setString(2, userDTO.getPassword());
			pstmt.setInt(3, userId);
			resultCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				dbHelper.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultCount;
	}
	
	@Override
	public int delete(int userId) {
		int resultCount = 0;
		String queryStr = " DELETE FROM users WHERE id = ?; ";
		conn = dbHelper.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setInt(1, userId);
			resultCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				dbHelper.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultCount;
	}
	
	@Override
	public int searchIdByEmail(String email) {
		int userId = 0;
		conn = dbHelper.getConnection();
		String sql = " SELECT * FROM users "
				+ " WHERE email = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				userId = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				dbHelper.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userId;
	}
	

}
