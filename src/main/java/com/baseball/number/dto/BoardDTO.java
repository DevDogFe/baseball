package com.baseball.number.dto;

public class BoardDTO {
	private int id;
	private String title;
	private String content;
	private int userId;
	private String createTime;
	private int views;
	private String username;
	private int replyCount;
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	// 글 수정용
	public BoardDTO(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	
	// 글 작성용
	public BoardDTO(String title, String content, int userId, String fileName) {
		super();
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.fileName = fileName;
	}

	// 목록조회용
	public BoardDTO(int id, String title, int userId, int views, String username) {
		this.id = id;
		this.title = title;
		this.userId = userId;
		this.views = views;
		this.username = username;
	}

	// 글 조회용
	public BoardDTO(int id, String title, String content, int userId, String createTime, int views, String fileName) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.createTime = createTime;
		this.views = views;
		this.fileName = fileName;
	}
	
	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "BoardDTO [id=" + id + ", title=" + title + ", content=" + content + ", userId=" + userId
				+ ", createTime=" + createTime + "]";
	}
	
	

}
