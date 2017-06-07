package com.yfc.valueBean;

public class DiscussBean {
	private int discussId;
	private int articleId;
	
	private String name;
	private String email;
	private String content;
	private String time;
	private String state;
	public int getDiscussId() {
		return discussId;
	}
	public void setDiscussId(int discussId) {
		this.discussId = discussId;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
