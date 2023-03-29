package com.baseball.number.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.baseball.number.dto.UserDTO;
import com.baseball.number.dto.UserDTO.Builder;
import com.baseball.number.utils.BaseballCalculater;
import com.baseball.number.utils.DBHelper;

public class NumberDAO implements INumberDAO {
	private DBHelper dbHelper;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public NumberDAO() {
		dbHelper = DBHelper.getInstance();
	}

	@Override
	public int insert(int userId) {
		int resultCount = 0;
		String queryStr = " INSERT INTO numbers VALUES (?, ?, ?, ?) ";
		BaseballCalculater baseballCalculater = new BaseballCalculater();
		int[] nums = baseballCalculater.getNumbers();
		conn = dbHelper.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, nums[0]);
			pstmt.setInt(3, nums[1]);
			pstmt.setInt(4, nums[2]);
			resultCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				dbHelper.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return resultCount;
	}

	@Override
	public int[] select(int userId) {
		int[] nums = new int[3];
		conn = dbHelper.getConnection();
		String sql = " SELECT * FROM numbers WHERE userId = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				nums[0] = rs.getInt("num1");
				nums[1] = rs.getInt("num2");
				nums[2] = rs.getInt("num3");
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
		return nums;
	}

	@Override
	public int delete(int userId) {
		int resultCount = 0;
		String queryStr = " DELETE FROM numbers WHERE userId = ? ";
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
				if (pstmt != null)
					pstmt.close();
				dbHelper.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultCount;
	}

}
