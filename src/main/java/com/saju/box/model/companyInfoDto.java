package com.saju.box.model;

import java.io.Serializable;

public class companyInfoDto implements Serializable {
	String compNo;
	String compName;
	String compAddr;
	String compRepr;
	String compTel;
	
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
	public String getCompAddr() {
		return compAddr;
	}
	public void setCompAddr(String compAddr) {
		this.compAddr = compAddr;
	}
	public String getCompRepr() {
		return compRepr;
	}
	public void setCompRepr(String compRepr) {
		this.compRepr = compRepr;
	}
	public String getCompTel() {
		return compTel;
	}
	public void setCompTel(String compTel) {
		this.compTel = compTel;
	}
}
