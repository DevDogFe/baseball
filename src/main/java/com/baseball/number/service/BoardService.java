package com.baseball.number.service;

import java.util.ArrayList;

import com.baseball.number.dto.BoardDTO;
import com.baseball.number.repository.BoardDAO;
import com.baseball.number.repository.ReplyDAO;

public class BoardService {
	
	private BoardDAO boardDAO;
	private ReplyDAO replyDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();
		replyDAO = new ReplyDAO();
	}
	
	public int writeBoardContent(BoardDTO boardDTO) {
		int resultCount = 0;
		resultCount += boardDAO.insert(boardDTO);
		return resultCount;
	}
	
	public ArrayList<BoardDTO> showList(int page) {
		ArrayList<BoardDTO> list = new ArrayList<>();
		list = boardDAO.selectList(page);
		for(int i = 0; i < list.size(); i++) {
			list.get(i).setReplyCount(replyDAO.replyCount(list.get(i).getId()));
		}
		return list;
	}
	
	public BoardDTO showBoardContent(int boardId, int userId) {
		BoardDTO boardDTO = null;
		boardDTO = boardDAO.select(boardId);
		if(boardDTO.getUserId() != userId) {
			boardDAO.viewsUp(boardId);
		}
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
	
	public int countBoardPage() {
		int boardPageCount = 0;
		boardPageCount = boardDAO.countBoard();
		return boardPageCount;
	}
	

	

}
