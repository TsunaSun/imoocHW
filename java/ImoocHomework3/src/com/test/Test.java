package com.test;

import java.util.*;
import com.model.*;

public class Test {
	public static void info1() {
		System.out.println("***************欢迎来到月亮马戏团***************");
		System.out.println("******************请选择表演者******************");
		System.out.println("******************   1、 棕熊     ******************");
		System.out.println("******************   2、 狮子     ******************");
		System.out.println("******************   3、 猴子     ******************");
		System.out.println("******************   4、 鹦鹉     ******************");
		System.out.println("******************   5、 小丑     ******************");
	}
	public static void info2() {
		System.out.println("***************是否继续观看(1/0)***************");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		//实例
		Bear bear = new Bear("Jack",2);
		Lion lion = new Lion("Lily", 3, "红色", "雄性");
		Monkey monkey = new Monkey("Tom", 4, "金丝猴");
		Parrot parrot = new Parrot("Sarra", 1, "虎皮鹦鹉");
		Clown clown = new Clown("Tim", 5);
		
		
		//跳出条件
		int flag1 = 0;//循环1
		int flag2 = 0;//循环2
		int flag3 = 0;//大循环
		do {
			flag1 = 0;
			flag2 = 0;
			info1();
			do {
			switch(input.nextLine()) {
			case "1": bear.act();info2();flag1 = 1;break;
			case "2": lion.act();info2();flag1 = 1;break;
			case "3": monkey.act();info2();flag1 = 1;break;
			case "4": parrot.act();info2();flag1 = 1;break;
			case "5": clown.act();info2();flag1 = 1;break;
			default : System.out.println("输入有误请重新输入");info2();
			}
			}while(flag1 == 0);
			do {
			switch(input.nextLine()) {
			case "0": flag2 = 1;flag3 = 1;System.out.println("谢谢您的观看");break;
			case "1": flag2 = 1;break;
			default : System.out.println("输入有误请重新输入");info2();
			}
			}while(flag2 == 0);
			
		}while(flag3 == 0);
	}

}
