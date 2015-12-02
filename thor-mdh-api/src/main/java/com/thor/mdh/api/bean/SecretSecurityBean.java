package com.thor.mdh.api.bean;

import java.io.Serializable;

/**
 * 密保问题
 * @author morlin
 *
 */
public class SecretSecurityBean implements Serializable{
    
	private static final long serialVersionUID = 3495514595296219939L;

	/** 用户编号 */
    private Integer userId;
    
    /** 密保问题1 */
    private int questionOneId;
    
    /** 密保问题1 */
    private String questionOne;
    
    /** 密保问题1的值 */
    private String questionOneValue;
    
    /** 密保问题2 */
    private int questionTwoId;
    
    /** 密保问题2 */
    private String questionTwo;
    
    /** 密保问题2的值 */
    private String questionTwoValue;
    
    /** 密保问题3 */
    private int questionThreeId;
    
    /** 密保问题3 */
    private String questionThree;
    
    /** 密保问题3的值 */
    private String questionThreeValue;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public int getQuestionOneId() {
		return questionOneId;
	}

	public void setQuestionOneId(int questionOneId) {
		this.questionOneId = questionOneId;
	}

	public String getQuestionOne() {
		return questionOne;
	}

	public void setQuestionOne(String questionOne) {
		this.questionOne = questionOne;
	}

	public String getQuestionOneValue() {
		return questionOneValue;
	}

	public void setQuestionOneValue(String questionOneValue) {
		this.questionOneValue = questionOneValue;
	}

	public int getQuestionTwoId() {
		return questionTwoId;
	}

	public void setQuestionTwoId(int questionTwoId) {
		this.questionTwoId = questionTwoId;
	}

	public String getQuestionTwo() {
		return questionTwo;
	}

	public void setQuestionTwo(String questionTwo) {
		this.questionTwo = questionTwo;
	}

	public String getQuestionTwoValue() {
		return questionTwoValue;
	}

	public void setQuestionTwoValue(String questionTwoValue) {
		this.questionTwoValue = questionTwoValue;
	}

	public int getQuestionThreeId() {
		return questionThreeId;
	}

	public void setQuestionThreeId(int questionThreeId) {
		this.questionThreeId = questionThreeId;
	}

	public String getQuestionThree() {
		return questionThree;
	}

	public void setQuestionThree(String questionThree) {
		this.questionThree = questionThree;
	}

	public String getQuestionThreeValue() {
		return questionThreeValue;
	}

	public void setQuestionThreeValue(String questionThreeValue) {
		this.questionThreeValue = questionThreeValue;
	}

}
