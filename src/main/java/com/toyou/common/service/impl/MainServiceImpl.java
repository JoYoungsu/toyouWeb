package com.toyou.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyou.common.service.MainService;
import com.toyou.common.vo.UserVO;
import com.toyou.dao.MainDAO;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private MainDAO dao;
	
}
