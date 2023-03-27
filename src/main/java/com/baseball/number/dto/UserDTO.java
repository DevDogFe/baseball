package com.baseball.number.dto;

public class UserDTO {
	private int userId;
	private String email;
	private String password;
	private String username;
	private String userRole;
	private String joinDate;

	private int weekPoint;
	private int monthPoint;
	private int totalPoint;

	public int getUserId() {
		return userId;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public String getUserRole() {
		return userRole;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public int getWeekPoint() {
		return weekPoint;
	}

	public int getMonthPoint() {
		return monthPoint;
	}

	public int getTotalPoint() {
		return totalPoint;
	}
	
	public UserDTO() {
		
	}

	public UserDTO(String email, String password, String username) {
		super();
		this.email = email;
		this.password = password;
		this.username = username;
	}

	public class Builder {
		private int userId;
		private String email;
		private String password;
		private String username;
		private String userRole;
		private String joinDate;

		private int weekPoint;
		private int monthPoint;
		private int totalPoint;

		public Builder setUserId(int userId) {
			this.userId = userId;
			return this;
		}

		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder setPassword(String password) {
			this.password = password;
			return this;
		}

		public Builder setUsername(String username) {
			this.username = username;
			return this;
		}

		public Builder setUserRole(String userRole) {
			this.userRole = userRole;
			return this;
		}

		public Builder setJoinDate(String joinDate) {
			this.joinDate = joinDate;
			return this;
		}

		public Builder setWeekPoint(int weekPoint) {
			this.weekPoint = weekPoint;
			return this;
		}

		public Builder setMonthPoint(int monthPoint) {
			this.monthPoint = monthPoint;
			return this;
		}

		public Builder setTotalPoint(int totalPoint) {
			this.totalPoint = totalPoint;
			return this;
		}

		public UserDTO build() {
			
			UserDTO userDTO = new UserDTO();
			userDTO.userId = userId;
			userDTO.email = email;
			userDTO.password = password;
			userDTO.username = username;
			userDTO.userRole = userRole;
			userDTO.joinDate = joinDate;
			userDTO.weekPoint = weekPoint;
			userDTO.monthPoint = monthPoint;
			userDTO.totalPoint = totalPoint;
			
			return userDTO;
		}
		
		

	}

}
