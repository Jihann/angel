package com.angel.queen.model;

public class ArticleModelReply {
	
	//论坛标题
    private String title;
    
    //发表作者
    private String author;
    
    //发布时间描述
    private String publishDateDescribe;
    
    //最后回复的人
    private String lastReplyer;
    
    //最后回复时间描述
    private String lastReplyDateDesribe;
    
    //浏览次数
    private Integer viewCount;
    
    //回复次数
    private Integer replyCount;
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishDateDescribe() {
		return publishDateDescribe;
	}
	public void setPublishDateDescribe(String publishDateDescribe) {
		this.publishDateDescribe = publishDateDescribe;
	}
	public String getLastReplyer() {
		return lastReplyer;
	}
	public void setLastReplyer(String lastReplyer) {
		this.lastReplyer = lastReplyer;
	}
	public String getLastReplyDateDesribe() {
		return lastReplyDateDesribe;
	}
	public void setLastReplyDateDesribe(String lastReplyDateDesribe) {
		this.lastReplyDateDesribe = lastReplyDateDesribe;
	}
	public Integer getViewCount() {
		return viewCount;
	}
	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}
	public Integer getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}
}
