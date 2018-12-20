package com.model;

public class Person {
	// 员工成员属性：姓名、工号、性别、年龄、部门、职位
	private String perName;
	private String perNo;
	private String perSex;
	private int perAge;
	private Department perDepartment;
	private Post perPost;

	// 员工无参构造
	public Person() {

	}

	// 员工有参构造
	public Person(String perName, String perNo, String perSex, int perAge, Department perDepartment, Post perPost) {
		this.setPerAge(perAge);
		this.setPerName(perName);
		this.setPerNo(perNo);
		this.setPerSex(perSex);
		this.setPerDepartment(perDepartment);
		this.setPerPost(perPost);
	}

	// 员工成员属性相关get、set方法
	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}

	public String getPerNo() {
		return perNo;
	}

	public void setPerNo(String perNo) {
		this.perNo = perNo;
	}

	public String getPerSex() {
		return perSex;
	}

	// 设置性别方法，如输入不是男或女，则默认男
	public void setPerSex(String perSex) {
		if (!(perSex.equals("男") || perSex.equals("女")))
			this.perSex = "男";
		else
			this.perSex = perSex;
	}

	public int getPerAge() {
		return perAge;
	}

	// 限定年龄只能是18--65之间,反之则设置默认为18岁
	public void setPerAge(int perAge) {
		if (perAge > 65 || perAge < 18)
			this.perAge = 18;
		else
			this.perAge = perAge;
	}

	public Department getPerDepartment() {
		return perDepartment;
	}

	public void setPerDepartment(Department perDepartment) {
		this.perDepartment = perDepartment;
	}

	public Post getPerPost() {
		return perPost;
	}

	public void setPerPost(Post perPost) {
		this.perPost = perPost;
	}

	/**
	 * 
	 * @return 姓名，工号，性别，年龄，职务
	 */
	public String perInfo() {
		String str = "姓名：" + this.getPerName() + "\n工号：" + this.getPerNo() + "\n性别：" + this.getPerSex() + "\n年龄："
				+ this.getPerAge() + "\n职务：" + this.getPerDepartment().getDepartName() + this.getPerPost().getPostName();
		return str;
	}
}
