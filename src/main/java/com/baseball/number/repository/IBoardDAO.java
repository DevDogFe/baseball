package com.baseball.number.repository;

import java.util.ArrayList;

import com.baseball.number.dto.BoardDTO;

public interface IBoardDAO {
	
	// 글 작성
	int insert(BoardDTO boardDTO);
	// 목록 조회용
	ArrayList<BoardDTO> selectList(int page);
	// 글 조회
	BoardDTO select(int boardId);
	// 글 수정
	int update(BoardDTO boardDTO, int boardId);
	// 글 삭제
	int delete(int boardId);
	// 글 목록 전체 갯수 카운트
	int countBoard();
	// 조회수++
	int viewsUp(int boardId);
	
	
	
}
