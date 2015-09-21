package com.thor.mdh.api.bean;

import java.io.Serializable;

/**
 * 分页
 * @author morlin
 *
 */
public class Pagination implements Serializable{

	private static final long serialVersionUID = 935790112476662665L;
	
	private int pageNo;          //当前页码  
	private int pageSize;        //每页行数  
	private int totalCount;      //总记录数  
	private int totalPage;		//总页数
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}  
}
