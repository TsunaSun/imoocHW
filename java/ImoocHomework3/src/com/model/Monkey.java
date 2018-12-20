package com.model;

public class Monkey extends Animal implements IAct {

	//新增属性：种类
	private String type;
	
	//get set
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public void skill() {
		// TODO Auto-generated method stub
		System.out.println("技能：会算算术");
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		System.out.println("表演者：" + this.getName());
		System.out.println("年龄：" + this.getAge());
		System.out.println("种类：" + this.getType());
		this.skill();

	}

	@Override
	public void love() {
		// TODO Auto-generated method stub
		System.out.println("爱好：吃桃子吃香蕉");
	}

	public Monkey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Monkey(String name, int age, String type) {
		super(name, age);
		// TODO Auto-generated constructor stub
		this.setType(type);
	}
	

}
