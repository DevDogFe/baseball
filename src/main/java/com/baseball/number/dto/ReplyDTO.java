package com.baseball.number.dto;

public class ReplyDTO {
	private int id;
	private String content;
	private int userId;
	private int boardId;
	private String createTime;
	
	// 생성용
	public ReplyDTO(String content, int userId, int boardId) {
		super();
		this.content = content;
		this.userId = userId;
		this.boardId = boardId;
	}
	
	// 조회용
	public ReplyDTO(int id, String content, int userId, int boardId, String createTime) {
		super();
		this.id = id;
		this.content = content;
		this.userId = userId;
		this.boardId = boardId;
		this.createTime = createTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "ReplyDTO [id=" + id + ", content=" + content + ", userId=" + userId + ", boardId=" + boardId
				+ ", createTime=" + createTime + "]";
	}
	
	

	
	
	
	
}
