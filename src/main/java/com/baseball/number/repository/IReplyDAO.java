package com.baseball.number.repository;

import java.util.ArrayList;

import com.baseball.number.dto.ReplyDTO;

public interface IReplyDAO {
	
	// 댓글 작성
	int insert(ReplyDTO replyDTO);
	// 댓글 보기
	ArrayList<ReplyDTO> select(int boardId);
	// 삭제
	int delete(int replyId);
	// 수정
	int update(String content, int replyId);
	
}
