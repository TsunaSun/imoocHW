package com.model;

public class Bear extends Animal implements IAct {

	@Override
	public void skill() {
		// TODO Auto-generated method stub
		System.out.println("技能：会打着伞、踩着球跳舞");
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		System.out.println("表演者：" + this.getName());
		System.out.println("年龄：" + this.getAge());
		this.skill();
		this.love();
	}

	@Override
	public void love() {
		// TODO Auto-generated method stub
		System.out.println("爱好：吃肉！");
	}

	public Bear() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bear(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}

	
}
