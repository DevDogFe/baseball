package com.baseball.number.service;

import java.util.ArrayList;

import com.baseball.number.dto.BoardDTO;
import com.baseball.number.repository.BoardDAO;

public class BoardService {
	
	private BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();
	}
	
	public int writeBoardContent(BoardDTO boardDTO) {
		int resultCount = 0;
		resultCount += boardDAO.insert(boardDTO);
		return resultCount;
	}
	
	public ArrayList<BoardDTO> showList(int page) {
		ArrayList<BoardDTO> list = new ArrayList<>();
		list = boardDAO.selectList(page);
		return list;
	}
	
	public BoardDTO showBoardContent(int boardId) {
		BoardDTO boardDTO = null;
		boardDTO = boardDAO.select(boardId);
		return boardDTO;
	}
	
	public int updateBoardContent(BoardDTO boardDTO, int boardId) {
		int resultCount = 0;
		resultCount += boardDAO.update(boardDTO, boardId);
		return resultCount;
	}
	
	public int deleteBoardContent(int boardId) {
		int resultCount = 0;
		resultCount = boardDAO.delete(boardId);
		return resultCount;
	}

}
