package com.yfc.valueBean;

public class ArticleBean {
	private int articleId;
	private String  title;
	private String type;
	private String description;
	private String content;
	private String time;
	private int viewCounts;
	private int discussCounts;//此项在数据库中不存在
	
	public int getDiscussCounts() {
		return discussCounts;
	}
	public void setDiscussCounts(int discussCounts) {
		this.discussCounts = discussCounts;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getViewCounts() {
		return viewCounts;
	}
	public void setViewCounts(int viewCounts) {
		this.viewCounts = viewCounts;
	}
	
}
