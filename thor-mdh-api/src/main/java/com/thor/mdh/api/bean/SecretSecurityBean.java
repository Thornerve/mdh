/*
 * Copyright (C), 2013-2013, 上海汽车集团股份有限公司
 * FileName: SecretSecurity.java
 * Author:   v_xieyuwen
 * Date:     2013年11月27日 下午4:11:39
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.thor.mdh.api.bean;

/**
 * 〈一句话功能简述〉密保问题设置<br>
 * 〈功能详细描述〉.
 * 
 * @author v_xieyuwen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SecretSecurityBean {
    
    /** 用户编号. */
    private Integer userId;
    
    /** 密保问题1. */
    private int questionOneId;
    
    /** 密保问题1. */
    private String questionOne;
    
    /** 密保问题1的值. */
    private String questionOneValue;
    
    /** 密保问题2. */
    private int questionTwoId;
    
    /** 密保问题2. */
    private String questionTwo;
    
    /** 密保问题2的值. */
    private String questionTwoValue;
    
    /** 密保问题3. */
    private int questionThreeId;
    
    /** 密保问题3. */
    private String questionThree;
    
    /** 密保问题3的值. */
    private String questionThreeValue;

    /**
     * Gets the user id.
     * 
     * @return the userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     * 
     * @param userId the userId to set
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Gets the question one.
     * 
     * @return the questionOne
     */
    public String getQuestionOne() {
        return questionOne;
    }

    /**
     * Sets the question one.
     * 
     * @param questionOne the questionOne to set
     */
    public void setQuestionOne(String questionOne) {
        this.questionOne = questionOne;
    }

    /**
     * Gets the question one value.
     * 
     * @return the questionOneValue
     */
    public String getQuestionOneValue() {
        return questionOneValue;
    }

    /**
     * Sets the question one value.
     * 
     * @param questionOneValue the questionOneValue to set
     */
    public void setQuestionOneValue(String questionOneValue) {
        this.questionOneValue = questionOneValue;
    }

    /**
     * Gets the question two.
     * 
     * @return the questionTwo
     */
    public String getQuestionTwo() {
        return questionTwo;
    }

    /**
     * Sets the question two.
     * 
     * @param questionTwo the questionTwo to set
     */
    public void setQuestionTwo(String questionTwo) {
        this.questionTwo = questionTwo;
    }

    /**
     * Gets the question two value.
     * 
     * @return the questionTwoValue
     */
    public String getQuestionTwoValue() {
        return questionTwoValue;
    }

    /**
     * Sets the question two value.
     * 
     * @param questionTwoValue the questionTwoValue to set
     */
    public void setQuestionTwoValue(String questionTwoValue) {
        this.questionTwoValue = questionTwoValue;
    }

    /**
     * Gets the question three.
     * 
     * @return the questionThree
     */
    public String getQuestionThree() {
        return questionThree;
    }

    /**
     * Sets the question three.
     * 
     * @param questionThree the questionThree to set
     */
    public void setQuestionThree(String questionThree) {
        this.questionThree = questionThree;
    }

    /**
     * Gets the question three value.
     * 
     * @return the questionThreeValue
     */
    public String getQuestionThreeValue() {
        return questionThreeValue;
    }

    /**
     * Sets the question three value.
     * 
     * @param questionThreeValue the questionThreeValue to set
     */
    public void setQuestionThreeValue(String questionThreeValue) {
        this.questionThreeValue = questionThreeValue;
    }

    /**
     * Gets the question one id.
     * 
     * @return the question one id
     */
    public int getQuestionOneId() {
        return questionOneId;
    }

    /**
     * Sets the question one id.
     * 
     * @param questionOneId the new question one id
     */
    public void setQuestionOneId(int questionOneId) {
        this.questionOneId = questionOneId;
    }

    /**
     * Gets the question two id.
     * 
     * @return the question two id
     */
    public int getQuestionTwoId() {
        return questionTwoId;
    }

    /**
     * Sets the question two id.
     * 
     * @param questionTwoId the new question two id
     */
    public void setQuestionTwoId(int questionTwoId) {
        this.questionTwoId = questionTwoId;
    }

    /**
     * Gets the question three id.
     * 
     * @return the question three id
     */
    public int getQuestionThreeId() {
        return questionThreeId;
    }

    /**
     * Sets the question three id.
     * 
     * @param questionThreeId the new question three id
     */
    public void setQuestionThreeId(int questionThreeId) {
        this.questionThreeId = questionThreeId;
    }
    
    

}
