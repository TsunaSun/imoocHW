package com.test;

import com.model.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Department depart1 = new Department("市场部", "D01");
		Department depart2 = new Department("人事部", "D02");
		Post post1 = new Post("经理", "P01");
		Post post2 = new Post("助理", "P02");
		Post post3 = new Post("职员", "P03");
		Person per1 = new Person("张三", "S001", "男", 30, depart1, post1);
		Person per2 = new Person("米莉", "S002", "女", 22, depart1, post2);
		Person per3 = new Person("张美美", "S003", "女", 26, depart1, post3);
		Person per4 = new Person("孙超", "S004", "男", 23, depart2, post1);
		System.out.println(per1.perInfo());
		System.out.println("=================================================");
		System.out.println(per2.perInfo());
		System.out.println("=================================================");
		System.out.println(per3.perInfo());
		System.out.println("=================================================");
		System.out.println(per4.perInfo());
		System.out.println("=================================================");
		
	}

}
