package com.thor.mdh.api.bean;

import java.io.Serializable;

/**
 * 返回结果
 * @author liu_yong
 *
 */
public class ResultVO implements Serializable{

	private static final long serialVersionUID = -7734562850041613427L;
	
	private String returnStatus;//返回状态值
	private String returnMsg;//返回信息
	
	public String getReturnStatus() {
		return returnStatus;
	}
	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}
	public String getReturnMsg() {
		return returnMsg;
	}
	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
}
