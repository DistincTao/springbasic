package com.springbasic.dto;

import java.sql.Date;

public class MemberDto {
	private String userId;
	private String userPwd;
	private String userEmail;
	private Date regdate;
	private int userImg;
	private int userPoint;
	private String memberImg;
	private String isAdmin;
	private String isDelete;
	
	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberDto(String userId, String userPwd, String userEmail, Date regdate, int userImg, int userPoint,
			String memberImg, String isAdmin, String isDelete) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userEmail = userEmail;
		this.regdate = regdate;
		this.userImg = userImg;
		this.userPoint = userPoint;
		this.memberImg = memberImg;
		this.isAdmin = isAdmin;
		this.isDelete = isDelete;
	}
	public String getUserId() {
		return userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public Date getRegdate() {
		return regdate;
	}
	public int getUserImg() {
		return userImg;
	}
	public int getUserPoint() {
		return userPoint;
	}
	public String getMemberImg() {
		return memberImg;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public String getIsDelete() {
		return isDelete;
	}
	
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public void setUserImg(int userImg) {
		this.userImg = userImg;
	}
	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}
	public void setMemberImg(String memberImg) {
		this.memberImg = memberImg;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	
	
	@Override
	public String toString() {
		return "MemberVo [userId=" + userId + ", userPwd=" + userPwd + ", userEmail=" + userEmail + ", regdate="
				+ regdate + ", userImg=" + userImg + ", userPoint=" + userPoint + ", memberImg=" + memberImg
				+ ", isAdmin=" + isAdmin + ", isDelete=" + isDelete + "]";
	}
	
	
	
	
}
