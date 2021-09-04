package com.saju.box.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.saju.box.HomeController;
import com.saju.box.dao.companyInfoDao;
import com.saju.box.model.companyInfoDto;
import com.saju.box.service.companyInfoService;

@Service("companyInfoService")
public class companyInfoServiceImpl implements companyInfoService{
	@Inject
	companyInfoDao Dao;
	
	private static final Logger logger = LoggerFactory.getLogger(companyInfoServiceImpl.class);
	
	@Override
	public List<companyInfoDto> getCompInfo() {
		// TODO Auto-generated method stub
		logger.info("companyInfoService start!!!");
		return Dao.getCompanyNm();
	}

}
