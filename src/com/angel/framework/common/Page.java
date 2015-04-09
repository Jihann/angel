package com.angel.framework.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Page<T> implements Serializable {
	private static final long serialVersionUID = -6714183641314294883L;

	/**
	 * 每页数目
	 */
	private int pageSize = 12;
	/**
	 * 总页数
	 */
	private int totalRecord;
	/**
	 * 当前页
	 */
	private int currentPage;
	/**
	 * 总页数
	 */
	private int pageCount;
	/**
	 * 目标页
	 */
	private int targetPage;
	/**
	 * 起始目标记录数
	 */
	private int targetStartRecord;
	/**
	 * 截止目标记录数
	 */
	private int targetEndRecord;
	/**
	 * 分页信息
	 */
	private String pageMsg;
	/**
	 * 翻页信息
	 */
	private String turnPage;
	/**
	 * 查询参数
	 */
	private T queryParam;

	public Page() {
		pageSize = 12;
		targetPage = 1;
	}

	public Page(int pageSize) {
		this.pageSize = 12;
		targetPage = 1;
		this.pageSize = pageSize;
	}

	public int getTargetStartRecord() {
		return pageSize * (targetPage - 1);
	}

	public int getTargetEndRecord() {
		return pageSize * targetPage - 1;
	}

	public int getPageSize() {
		return pageSize;
	}



	public int getCurrentPage() {
		if (this.totalRecord == 0) {
			return 0;
		} else {
			return currentPage;
		}
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageCount() {
		int cnt = totalRecord / pageSize;
		if (totalRecord % pageSize != 0){
			cnt++;
		}
		return cnt;
	}

	public int getTargetPage() {
		return targetPage;
	}

	public void setTargetPage(int targetPage) {
		this.targetPage = targetPage;
	}

	public String getPageMsg() {
		StringBuffer sb = new StringBuffer();
		sb.append("共<span class='blue'>");
		sb.append(String.valueOf(this.getTotalRecord()));
		sb.append("</span>条数据 当前第<span class='blue'>");
		sb.append(String.valueOf(this.getCurrentPage()));
		sb.append("</span>/");
		sb.append(String.valueOf(this.getPageCount()));
		sb.append("页");
		
		return sb.toString();
	}

	public void setPageMsg(String pageMsg) {
		this.pageMsg = pageMsg;
	}

	public String getTurnPage() {
		StringBuffer strHtml = new StringBuffer();
		if (getPageCount() < 2){
			return "";
		}
		if (getTargetPage() > 1){
			strHtml.append("<a href='javascript:void(0)' name='pageControl' targetPage='1' class='main-pagea'>首页</a> &nbsp;&nbsp;<a href='javascript:void(0)' class='main-pagea' name='pageControl' targetPage='");
			strHtml.append(String.valueOf(getTargetPage() - 1));
			strHtml.append("'>上一页</a>");
		}
					
		if (getTargetPage() < getPageCount()){
			strHtml.append("&nbsp;&nbsp;<a href='javascript:void(0)' name='pageControl' class='main-pagea' targetPage='");
			strHtml.append(String.valueOf(getTargetPage() + 1));
			strHtml.append("'>下一页</a>");
			strHtml.append("&nbsp;&nbsp;<a href='javascript:void(0)' name='pageControl' class='main-pagea' targetPage='");
			strHtml.append(String.valueOf(getPageCount()));
			strHtml.append("'>末页</a> ");
		}
			
		return strHtml.toString();
	}

	public void setTurnPage(String turnPage) {
		this.turnPage = turnPage;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		targetPage = 1;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public T getQueryParam() {
		return queryParam;
	}

	public void setQueryParam(T queryParam) {
		this.queryParam = queryParam;
	}

}