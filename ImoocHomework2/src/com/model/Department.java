package com.model;

public class Department {
	//部门成员属性：部门名称、部门编号、该部门员工
	private String departName;
	private String departNo;
	private Person[] departPerson;
	private int departPersonNum;

	public Department() {
		
	}
	
	public Department(String departName ,String departNo ) {
		this.setDepartName(departName);
		this.setDepartNo(departNo);
	}
	
	//部门成员属性相关get、set方法
	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}
	
	public String getDepartNo() {
		return departNo;
	}

	public void setDepartNo(String departNo) {
		this.departNo = departNo;
	}
	
	//部门员工数量为只读属性
	public int getDepartPersonNum() {
		return departPersonNum;
	}

	
	//get部门员工方法，如果不存在，则实例化一个长度为100的Person数组
	public Person[] getDepartPerson() {
		if (this.departPerson == null)
		{
			this.departPerson = new Person[100];
		}
		return departPerson;
	}

	public void setDepartPerson(Person[] departPerson) {
		this.departPerson = departPerson;
	}
	
	//添加部门员工数量方法
	public void addDepartPerson(Person myPerson) {
		int i = 0;
		//添加部门员工
		for (i = 0 ;i < this.getDepartPerson().length ; i++) {
			if (this.getDepartPerson()[i] == null) {
				myPerson.setPerDepartment(this);
				this.getDepartPerson()[i] = myPerson;
			}
		}
		//设置员工数量
		this.departPersonNum = i + 1;
	}



}
