package com.saju.box.model;

import java.io.Serializable;

public class OrderDto implements Serializable {
	String orderNo;			//������ȣ
	String compNo;			//����ī�� ��ȣ
	String orderGubun;		//��������(S:����, T:Ÿ��)
	String orderName;		//�̸�
	String orderYear;		//����⵵
	String orderMonth;		//�����
	String orderDay;		//�����
	String orderHour;		//����ð�
	String orderMin;		//�����
	String orderGender;		//����(M),����(F)
	String orderLunaYn;		//���¿��� Y:����
	String orderDt;			//�������
	String regDtm;			//�������(�ð��б���)
		
	String userId;
	String completeYn;
	String namingYn;
	String remark;
	
	int orderAmt;			//���ݾ�(�̸��� ����)
	int namingAmt;			//�۸�ݾ�
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}	
	public String getCompNo() {
		return compNo;
	}
	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getOrderYear() {
		return orderYear;
	}
	public void setOrderYear(String orderYear) {
		this.orderYear = orderYear;
	}
	public String getOrderMonth() {
		return orderMonth;
	}
	public void setOrderMonth(String orderMonth) {
		this.orderMonth = orderMonth;
	}
	public String getOrderDay() {
		return orderDay;
	}
	public void setOrderDay(String orderDay) {
		this.orderDay = orderDay;
	}
	public String getOrderHour() {
		return orderHour;
	}
	public void setOrderHour(String orderHour) {
		this.orderHour = orderHour;
	}
	public String getOrderMin() {
		return orderMin;
	}
	public void setOrderMin(String orderMin) {
		this.orderMin = orderMin;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCompleteYn() {
		return completeYn;
	}
	public void setCompleteYn(String completeYn) {
		this.completeYn = completeYn;
	}
	public String getNamingYn() {
		return namingYn;
	}
	public void setNamingYn(String namingYn) {
		this.namingYn = namingYn;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}	
	public String getOrderGender() {
		return orderGender;
	}
	public void setOrderGender(String orderGender) {
		this.orderGender = orderGender;
	}
	
	public String getOrderLunaYn() {
		return orderLunaYn;
	}
	public void setOrderLunaYn(String orderLunaYn) {
		this.orderLunaYn = orderLunaYn;
	}
	public String getOrderGubun() {
		return orderGubun;
	}
	public void setOrderGubun(String orderGubun) {
		this.orderGubun = orderGubun;
	}
	public String getOrderDt() {
		return orderDt;
	}
	public void setOrderDt(String orderDt) {
		this.orderDt = orderDt;
	}
	public String getRegDtm() {
		return regDtm;
	}
	public void setRegDtm(String regDtm) {
		this.regDtm = regDtm;
	}
	public int getOrderAmt() {
		return orderAmt;
	}
	public void setOrderAmt(int orderAmt) {
		this.orderAmt = orderAmt;
	}
	public int getNamingAmt() {
		return namingAmt;
	}
	public void setNamingAmt(int namingAmt) {
		this.namingAmt = namingAmt;
	}
	
	
	
	
}
