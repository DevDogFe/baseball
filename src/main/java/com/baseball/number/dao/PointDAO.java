package com.baseball.number.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.baseball.number.dto.UserDTO;
import com.baseball.number.dto.UserDTO.Builder;
import com.baseball.number.utils.DBHelper;

public class PointDAO implements IPointDAO {
	private DBHelper dbHelper;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public PointDAO() {
		dbHelper = DBHelper.getInstance();
	}

	@Override
	public int insert(int userId) {
		int resultCount = 0;
		String queryStr = " INSERT INTO userspoint(userId) VALUES (?) ";
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
	public ArrayList<UserDTO> select() {
		ArrayList<UserDTO> list = new ArrayList<>();
		conn = dbHelper.getConnection();
		String sql = " SELECT p.userId, u.username, p.weekPoint, p.monthPoint, p. totalPoint FROM usersPoint AS p "
				+ " LEFT JOIN users AS u ON p.userId = u.id ";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String username = rs.getString("username");
				int weakPoint = rs.getInt("weekPoint");
				int monthPoint = rs.getInt("monthPoint");
				int totalPoint = rs.getInt("totalPoint");
				
				UserDTO userDTO = new Builder().setUsername(username).setWeekPoint(weakPoint).setMonthPoint(monthPoint).setTotalPoint(monthPoint).build();
				list.add(userDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
				dbHelper.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public UserDTO select(int userId) {
		UserDTO userDTO = null;
		conn = dbHelper.getConnection();
		String sql = " SELECT * FROM userspoint WHERE userId = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String username = rs.getString("username");
				int weakPoint = rs.getInt("weekPoint");
				int monthPoint = rs.getInt("monthPoint");
				int totalPoint = rs.getInt("totalPoint");
				
				userDTO = new Builder().setUsername(username).setWeekPoint(weakPoint).setMonthPoint(monthPoint).setTotalPoint(monthPoint).build();
				System.out.println(userDTO.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
				dbHelper.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userDTO;
	}

	@Override
	public int getPoint(int userId, int point) {
		int resultCount = 0;
		String queryStr = " UPDATE usersPoint "
				+ " SET weekPoint = weekPoint + ?, monthPoint = monthPoint + ?, totalPoint = totalPoint + ? "
				+ " WHERE userId = ? ";
		conn = dbHelper.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setInt(1, point);
			pstmt.setInt(2, point);
			pstmt.setInt(3, point);
			pstmt.setInt(4, userId);
			resultCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				conn.close();
				dbHelper.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultCount;
	}

	@Override
	public int updateWeekpoint() {
		int resultCount = 0;
		String queryStr = " UPDATE usersPoint SET weekPoint = 0 ";
		conn = dbHelper.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(queryStr);
			resultCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				conn.close();
				dbHelper.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultCount;
	}

	@Override
	public int updateMonthPoint() {
		int resultCount = 0;
		String queryStr = " UPDATE usersPoint SET monthPoint = 0 ";
		conn = dbHelper.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(queryStr);
			resultCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				conn.close();
				dbHelper.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultCount;
	}
	
	public static void main(String[] args) {
		int a = new PointDAO().getPoint(1, 10);
		System.out.println(a);
		
		int b = new PointDAO().updateMonthPoint();
		
	}

}
