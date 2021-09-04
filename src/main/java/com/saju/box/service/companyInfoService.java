package com.saju.box.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saju.box.model.companyInfoDto;


public interface companyInfoService {
	public List<companyInfoDto> getCompInfo();
}
