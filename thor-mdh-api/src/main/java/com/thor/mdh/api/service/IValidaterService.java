package com.thor.mdh.api.service;


public interface IValidaterService {

	String sendValidateCodeToMobile(String mobile);

	Boolean checkCode(String vcode, Long userId);

	String sendValidateCodeToEmail(String email);
	
	

}
