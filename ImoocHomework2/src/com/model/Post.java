package com.model;

public class Post {
	//职位成员属性：名称
	private String postName;
	private String postNo;


	public Post() {
		
	}
	
	public Post(String postName ,String postNo) {
		this.setPostName(postName);
		this.setPostNo(postNo);
	}

	//职位成员get、set方法
	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}
	
	public String getPostNo() {
		return postNo;
	}

	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

}
