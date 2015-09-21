package com.thor.mdh.service.impl;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.thor.mdh.api.dao.IAccountDao;
import com.thor.mdh.api.service.account.IPassWordService;

@Service
public class PassWordServiceImpl implements IPassWordService{

	@Resource
	private IAccountDao accountDao;
	
	@Override
	public Boolean findPassWordByMobile(String mobile, Long userId, String newPassWord) {
		if(StringUtils.isEmpty(mobile) || null == userId || StringUtils.isEmpty(newPassWord)){
			return false;
		}else{
			/** 根据用户id查询手机号 */
			String mobileDB = accountDao.queryMobileById(userId);
			/** 对比手机号 */
			if(mobile.equals(mobileDB)){
				Long id = accountDao.updateUserPassWord(newPassWord, userId);
				if(null != id && id > 0){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Boolean findPassWordByEmail(String email, Long userId, String newPassWord) {
		if(StringUtils.isEmpty(email) || null == userId || StringUtils.isEmpty(newPassWord)){
			return false;
		}else{
			/** 根据用户id查询手机号 */
			String emailDB = accountDao.queryEmailById(userId);
			/** 对比手机号 */
			if(email.equals(emailDB)){
				Long id = accountDao.updateUserPassWord(newPassWord, userId);
				if(null != id && id > 0){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Boolean updatePassWordById(String password, Long userId) {
		if(StringUtils.isEmpty(password) || null == userId){
			return false;
		}else{
			Long id = accountDao.updateUserPassWord(password, userId);
			if(null != id && id > 0){
				return true;
			}
		}
		return false;
	}

}
