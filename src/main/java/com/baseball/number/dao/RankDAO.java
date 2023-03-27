package com.baseball.number.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.baseball.number.utils.DBHelper;

public class RankDAO {
	private DBHelper dbHelper;
	private Connection conn;
	private PreparedStatement pstmt;
	
	public RankDAO() {
		dbHelper = DBHelper.getInstance();
	}
	
	

}
