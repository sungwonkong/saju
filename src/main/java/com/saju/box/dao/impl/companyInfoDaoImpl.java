package com.saju.box.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.saju.box.dao.companyInfoDao;
import com.saju.box.model.companyInfoDto;

@Repository
public class companyInfoDaoImpl implements companyInfoDao{
	@Inject
	private SqlSession sqlSession;
	private String NS ="com.saju.box.companyInfoMapper";
	
	private static final Logger logger = LoggerFactory.getLogger(companyInfoDaoImpl.class);

	
	@Override
	public List<companyInfoDto> getCompanyNm() {
		logger.info("companyInfoDaoImpl start!!!");
		
		return sqlSession.selectList(NS+".getCompanyInfo");
	}

}
