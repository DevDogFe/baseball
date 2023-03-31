package com.baseball.number.service;

import java.util.ArrayList;

import com.baseball.number.dto.ReplyDTO;
import com.baseball.number.repository.ReplyDAO;

public class ReplyService {
	private ReplyDAO replyDAO;

	public ReplyService() {
		replyDAO = new ReplyDAO();
	}

	public int insertReply(ReplyDTO replyDTO) {
		int resultCount = 0;
		resultCount = replyDAO.insert(replyDTO);
		return resultCount;
	}
	public ArrayList<ReplyDTO> showReplies(int boardId) {
		ArrayList<ReplyDTO> list = new ArrayList<>();
		list = replyDAO.select(boardId);
		return list;
	}

	public int deleteReply(int replyId) {
		int resultCount = 0;
		resultCount = replyDAO.delete(replyId);
		return resultCount;
	}
	public int updateReply(String content, int replyId) {
		int resultCount = 0;
		resultCount = replyDAO.update(content, replyId);
		return resultCount;
	}
}
