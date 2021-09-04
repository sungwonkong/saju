package com.saju.box.model;

import java.io.Serializable;

public class LoginDto implements Serializable{
	String compNo;			//사주카페 번호
	String compName;		//사주카페 이름
	String teacherNo;		//선생님 번호
	String teacherNm;		//선생님 이름
	String teacherId; 		//선생님 아이디
	String pwd;				//선생님 비밀번호
	String reprYn;			//사주카페 대표여부
	
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getCompNo() {
		return compNo;
	}
	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getTeacherNo() {
		return teacherNo;
	}
	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}
	public String getTeacherNm() {
		return teacherNm;
	}
	public void setTeacherNm(String teacherNm) {
		this.teacherNm = teacherNm;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getReprYn() {
		return reprYn;
	}
	public void setReprYn(String reprYn) {
		this.reprYn = reprYn;
	} 
	
}
