package com.model;

public class Clown  implements IAct {

	//属性：名字、艺龄
	private String name;
	private int age;
	
	//get set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void skill() {
		// TODO Auto-generated method stub

	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		System.out.println("表演者：" + this.getName());
		System.out.println("艺龄：" + this.getAge());
		this.dress();
		this.skill();
	}

	//着装方法：
	public void dress() {
		System.out.println("着装：穿着五彩衣服，带着高帽子，脸上画着彩妆，带着红鼻子");
	}
	
	//构造方法
	public Clown(String name, int age) {
		super();
		this.setAge(age);
		this.setName(name);
	}
	public Clown() {
		
	}

	
}
