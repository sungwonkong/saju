package com.saju.box.model;

import java.io.Serializable;

public class LoginDto implements Serializable{
	String compNo;			//����ī�� ��ȣ
	String compName;		//����ī�� �̸�
	String teacherNo;		//������ ��ȣ
	String teacherNm;		//������ �̸�
	String teacherId; 		//������ ���̵�
	String pwd;				//������ ��й�ȣ
	String reprYn;			//����ī�� ��ǥ����
	
	
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
