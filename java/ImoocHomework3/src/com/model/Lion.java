package com.model;

public class Lion extends Animal implements IAct {

	//新增属性：颜色、性别
	private String color;
	private String sex;
	
	//get set
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Override
	public void skill() {
		// TODO Auto-generated method stub
		System.out.println("技能：会钻火圈");
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		System.out.println("表演者：" + this.getName());
		System.out.println("年龄：" + this.getAge());
		System.out.println("毛色：" + this.getColor());
		System.out.println("性别：" + this.getSex());
		this.skill();
		this.love();
	}

	@Override
	public void love() {
		// TODO Auto-generated method stub
		System.out.println("爱好：顺自己的毛叫两声");
	}

	public Lion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Lion(String name, int age, String color, String sex) {
		super(name, age);
		// TODO Auto-generated constructor stub
		this.setColor(color);
		this.setSex(sex);
	}

	
}
