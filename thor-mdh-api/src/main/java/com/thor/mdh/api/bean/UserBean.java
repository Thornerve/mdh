package com.thor.mdh.api.bean;

import java.io.Serializable;
import java.util.Date;

public class UserBean implements Serializable{

	private static final long serialVersionUID = -293714187271317286L;
	/** 用户id */
	private Long userId;
	/** 用户名 */
	private String userName;
	/** 用户密码 */
	private String password;
	/** 用户手机 */
	private String mobile;
	/** 用户图像 */
	private Long coverImgUrl;
	/** 用户类型(1:个人，2：企业)*/
	private Integer userType;
	/** 是否认证(1:认证，2：未认证)*/
	private Integer identification;
	/** 营业执照 */
	private Long businessLicence;
	/** 创建时间 */
	private Date createTime;
	/** 更新时间 */
	private Date updateTime;
	/** 数据状态(1:正常，2：废弃) */
	private Integer status;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCoverImgUrl() {
		return coverImgUrl;
	}

	public void setCoverImgUrl(Long coverImgUrl) {
		this.coverImgUrl = coverImgUrl;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Long getBusinessLicence() {
		return businessLicence;
	}

	public void setBusinessLicence(Long businessLicence) {
		this.businessLicence = businessLicence;
	}

	public Integer getIdentification() {
		return identification;
	}

	public void setIdentification(Integer identification) {
		this.identification = identification;
	}

}
