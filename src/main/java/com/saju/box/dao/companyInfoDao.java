package com.saju.box.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.saju.box.model.companyInfoDto;

@Repository
public interface companyInfoDao {
	
	public List<companyInfoDto> getCompanyNm();
}
