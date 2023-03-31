package com.baseball.number.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.baseball.number.dto.BoardDTO;
import com.baseball.number.dto.ReplyDTO;
import com.baseball.number.utils.DBHelper;

public class ReplyDAO implements IReplyDAO {
	private DBHelper dbHelper;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ReplyDAO() {
		dbHelper = DBHelper.getInstance();
	}

	@Override
	public int insert(ReplyDTO replyDTO) {
		int resultCount = 0;
		String queryStr = " INSERT INTO reply(content, userId, boardId) VALUES (?, ?, ?) ";
		conn = dbHelper.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setString(1, replyDTO.getContent());
			pstmt.setInt(2, replyDTO.getUserId());
			pstmt.setInt(3, replyDTO.getBoardId());
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
	public ArrayList<ReplyDTO> select(int boardId) {
		ArrayList<ReplyDTO> list = new ArrayList<>();
		conn = dbHelper.getConnection();
		String sql = " SELECT * FROM reply WHERE boardId = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new ReplyDTO(rs.getInt("id"), rs.getString("content"), rs.getInt("userId"), rs.getInt("boardId"), rs.getString("createTime")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				dbHelper.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public int delete(int replyId) {
		int resultCount = 0;
		String queryStr = " DELETE FROM reply WHERE id = ? ";
		conn = dbHelper.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setInt(1, replyId);
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
	public int update(String content, int replyId) {
		int resultCount = 0;
		String queryStr = " UPDATE reply SET content = ? WHERE id = ? ";
		conn = dbHelper.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setString(1, content);
			pstmt.setInt(2, replyId);
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
}
