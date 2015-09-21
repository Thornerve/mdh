package com.thor.mdh.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.thor.mdh.api.bean.UserBean;
import com.thor.mdh.api.dao.IUserDao;
import com.thor.mdh.api.service.IUserService;
import com.thor.mdh.api.util.MD5Util;

/**
 * 用户服务
 * @author morlin
 *
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService{

	/** 日志 */
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Resource
	private IUserDao userDao;
	
	@Override
	public UserBean queryUserById(Long userId) {
		logger.info("call finfUserById, param userId:{}", userId);
		UserBean user = userDao.queryUserById(userId);
		logger.info("call finfUserById, result user:{}", JSONObject.toJSONString(user));
		return user;
	}

	@Override
	public Long createUser(UserBean user) {
		logger.info("call createUser, param user:{}", JSONObject.toJSONString(user));
		user.setPassword(MD5Util.encodeByMD5(user.getPassword()));
		Long userId = userDao.createUser(user);
		logger.info("call createUser, result userId:{}", userId);
		return userId;
	}

	@Override
	public List<UserBean> queryUnIdentificationUserList() {
		logger.info("call queryUnIdentificationUserList ");
		List<UserBean> userList = userDao.queryUnIdentificationUserList();
		if(null != userList && userList.size() > 0){
			logger.info("call queryUnIdentificationUserList, result list size:{}", userList.size());
		}else{
			logger.info("call queryUnIdentificationUserList, result list null");
		}
		return userList;
	}

	@Override
	public Boolean queryMobileExist(String mobile) {
		logger.info("call queryMobileExist, param mobile:{}", mobile);
		UserBean user = userDao.queryMobileExist(mobile);
		logger.info("call queryMobileExist, result user:{}", JSONObject.toJSONString(user));
		return null != user;
	}

	@Override
	public Boolean queryEmailExist(String email) {
		logger.info("call queryEmailExist, param email:{}", email);
		UserBean user = userDao.queryEmailExist(email);
		logger.info("call queryEmailExist, result user:{}", JSONObject.toJSONString(user));
		return null != user;
	}

	@Override
	public Long updateUserEmail(String email, Long userId) {
		logger.info("call updateUserEmail, param email:{}, userId:{}", email, userId);
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("email", email);
		paramMap.put("userId", userId);
		Long id = userDao.updateUserEmail(paramMap);
		logger.info("call updateUserEmail, result userId:{}", id);
		return id;
	}

	@Override
	public Long updateUserMobile(String mobile, Long userId) {
		logger.info("call updateUserMobile, param mobile:{}, userId:{}", mobile, userId);
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("mobile", mobile);
		paramMap.put("userId", userId);
		Long id = userDao.updateUserEmail(paramMap);
		logger.info("call updateUserMobile, result userId:{}", id);
		return id;
	}

	@Override
	public Long updateUserIdentification(Long userId) {
		logger.info("call updateUserIdentification, param userId:{}", userId);
		Long id = userDao.updateUserIdentification(userId);
		logger.info("call updateUserIdentification, result userId:{}", id);
		return id;
	}

	@Override
	public Long deleteUserById(Long userId) {
		logger.info("call deleteUserById, param userId:{}", userId);
		Long id = userDao.deleteUserById(userId);
		logger.info("call deleteUserById, result userId:{}", id);
		return id;
	}

}
