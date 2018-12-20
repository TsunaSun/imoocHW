package com.model;

public abstract class Animal {
	//属性：名字、年龄
	private String name;
	
	private int age;
	
	//抽象方法：喜好
	public abstract void love();

	//get、set
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

	//无参构造
	public Animal() {
		super();
	}

	//带参构造
	public Animal(String name, int age) {
		super();
		this.setName(name);
		this.setAge(age);
	}
	
	
}
