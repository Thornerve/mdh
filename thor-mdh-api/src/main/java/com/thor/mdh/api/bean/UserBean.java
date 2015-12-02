package com.thor.mdh.api.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体
 * @author liu_yong
 *
 */
public class UserBean implements Serializable{

	private static final long serialVersionUID = -293714187271317286L;

	/** 用户id */
	private Long userId;
	/** 用户名 */
	private String userName;
	/** 用户密码 MD5加密 */
	private String password;
	/** 用户手机 */
	private String mobile;
	/** 用户验证状态 */
	private Integer verification;
	/** 审核日期 */
	private Date verificationDate;
	/** 用户提交审核时间 */
	private Date userSubmitTime;
	/** 用户类型(1:个人，2：企业)*/
	private Integer userType;
	/** 昵称 */
	private String nickName;
	/** 性别(1:男，2:女，3:未知)*/
	private Integer sexualty;
	/** 年龄 */
	private Integer age;
	/** 生日 */
	private Date birthday;
	/** 数据是否有效(1:有效，2:无效) */
	private Integer status;
	/** 婚姻状况(1:未婚，2：已婚，3：为知) */
	private Integer married;
	/** 用户图像 */
	private Long coverImgUrl;
	/** 是否接收邮件 (1:是;2:否) */
	private Integer receiveEmailFlag;
	/** 是否接收短信 (1:是;2:否) */
	private Integer receiveSmsFlag;
	/** 营业执照 */
	private Long businessLicence;
	/** 创建时间 */
	private Date createTime;
	/** 创建人 */
	private Integer createdBy;
	/** 更新时间 */
	private Date updateTime;
	/** 更新人 */
	private Integer updatedBy;
	/** 删除标识 (1:已删除 2:未删除) */
	private Integer deleteFlag;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getVerification() {
		return verification;
	}
	public void setVerification(Integer verification) {
		this.verification = verification;
	}
	public Date getVerificationDate() {
		return verificationDate;
	}
	public void setVerificationDate(Date verificationDate) {
		this.verificationDate = verificationDate;
	}
	public Date getUserSubmitTime() {
		return userSubmitTime;
	}
	public void setUserSubmitTime(Date userSubmitTime) {
		this.userSubmitTime = userSubmitTime;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Integer getSexualty() {
		return sexualty;
	}
	public void setSexualty(Integer sexualty) {
		this.sexualty = sexualty;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getMarried() {
		return married;
	}
	public void setMarried(Integer married) {
		this.married = married;
	}
	public Long getCoverImgUrl() {
		return coverImgUrl;
	}
	public void setCoverImgUrl(Long coverImgUrl) {
		this.coverImgUrl = coverImgUrl;
	}
	public Integer getReceiveEmailFlag() {
		return receiveEmailFlag;
	}
	public void setReceiveEmailFlag(Integer receiveEmailFlag) {
		this.receiveEmailFlag = receiveEmailFlag;
	}
	public Integer getReceiveSmsFlag() {
		return receiveSmsFlag;
	}
	public void setReceiveSmsFlag(Integer receiveSmsFlag) {
		this.receiveSmsFlag = receiveSmsFlag;
	}
	public Long getBusinessLicence() {
		return businessLicence;
	}
	public void setBusinessLicence(Long businessLicence) {
		this.businessLicence = businessLicence;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
}
