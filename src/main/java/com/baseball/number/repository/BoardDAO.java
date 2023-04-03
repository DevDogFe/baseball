package com.baseball.number.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.baseball.number.dto.BoardDTO;
import com.baseball.number.dto.UserDTO;
import com.baseball.number.dto.UserDTO.Builder;
import com.baseball.number.utils.BaseballCalculater;
import com.baseball.number.utils.DBHelper;

public class BoardDAO implements IBoardDAO{

	private DBHelper dbHelper;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public BoardDAO() {
		dbHelper = DBHelper.getInstance();
	}
	
	@Override // 글 작성
	public int insert(BoardDTO boardDTO) {
		int resultCount = 0;
		String queryStr = " INSERT INTO board (title, content, userId) VALUES "
				+ " (?, ?, ?) ";
		conn = dbHelper.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setString(1, boardDTO.getTitle());
			pstmt.setString(2, boardDTO.getContent());
			pstmt.setInt(3, boardDTO.getUserId());
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

	@Override 	// 게시글 목록 조회용
	public ArrayList<BoardDTO> selectList(int page) {
		ArrayList<BoardDTO> list = new ArrayList<>();
		conn = dbHelper.getConnection();
		String sql = " SELECT b.id, b.title, b.views, b.userId, u.username "
				+ " FROM board AS b LEFT JOIN users AS u ON b.userId = u.id "
				+ " ORDER BY id DESC LIMIT ?, 10 ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BoardDTO(rs.getInt("id"), rs.getString("title"), rs.getInt("userId"), rs.getInt("views"), rs.getString("username")));
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

	@Override // 글 조회
	public BoardDTO select(int boardId) {
		BoardDTO BoardDTO = null;
		conn = dbHelper.getConnection();
		String sql = " SELECT * FROM board WHERE id = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String ceateTime = rs.getString("createTime");
				int userId = rs.getInt("userId");
				int views = rs.getInt("views");
				BoardDTO = new BoardDTO(id, title, content, userId, ceateTime, views);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				dbHelper.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return BoardDTO;
	}

	@Override
	public int update(BoardDTO boardDTO, int boardId) {
		int resultCount = 0;
		String queryStr = " UPDATE board SET title = ?, content = ? WHERE id = ? ";
		conn = dbHelper.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setString(1, boardDTO.getTitle());
			pstmt.setString(2, boardDTO.getContent());
			pstmt.setInt(3, boardId);
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
	public int delete(int boardId) {
		int resultCount = 0;
		String queryStr = " DELETE FROM board WHERE id = ? ";
		conn = dbHelper.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setInt(1, boardId);
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
	public int countBoard() {
		int boardCount = 0;
		conn = dbHelper.getConnection();
		String sql = " SELECT count(*) AS boardCount from board ";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				boardCount = rs.getInt("boardCount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				dbHelper.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return boardCount;
	}
	
	@Override
	public int viewsUp(int boardId) {
		int resultCount = 0;
		String queryStr = " UPDATE board SET views = views + 1 WHERE id = ? ";
		conn = dbHelper.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(queryStr);
			pstmt.setInt(1, boardId);
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
