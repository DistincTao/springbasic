package com.springbasic.vo;

public class StudentVo {
	private String stuNo;
	private String stuName;
	
	public StudentVo() {
		super();
	}

	public StudentVo(String stuNo, String stuName) {
		super();
		this.stuNo = stuNo;
		this.stuName = stuName;
	}

	public String getStuNo() {
		return stuNo;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	@Override
	public String toString() {
		return "Student [stuNo=" + stuNo + ", stuName=" + stuName + "]";
	};
	
}
