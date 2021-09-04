package com.saju.box.dao;

import org.springframework.stereotype.Repository;

import com.saju.box.model.LoginDto;

@Repository
public interface AdminDao {
	public LoginDto getLoginInfo(LoginDto logindto);
}
