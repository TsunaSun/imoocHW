package com.demo;

import java.util.Scanner;

public class Homework1 
{
	//提示语句
	public void notice() 
	{
		System.out.println("***********************************************");
		System.out.println("		1--插入数据");
		System.out.println("		2--显示所有数据");
		System.out.println("		3--在指定位置插入数据");
		System.out.println("		4--查询能被3整除的数据");
		System.out.println("		0--退出");
		System.out.println("***********************************************");
	}
	//插入数据
	public int[] insertData() 
	{
		int[] a1 = new int[10];
		Scanner sc = new Scanner(System.in);
		int i = 0;
		while(i < 9) 
		{
			System.out.println("请输入第"+(i+1)+"个数据：");
			a1[i] = sc.nextInt();
			if (a1[i] != 0)
				i++;
			else 
			{
				System.out.println("请不要输入0哦，再重新输入一次吧！");
			}
		}
		return a1;
	}
	//显示数据
	public void showData(int[] arr) 
	{
		System.out.println("当前数组为：");
		if (arr[9] == 0 )
		{
			for (int i = 0 ; i < 8; i++)
				System.out.print(arr[i] + "   ");
			System.out.println(arr[8]);
		}
		else 
		{
			for (int a:arr)
				System.out.print(a + "   ");
			System.out.print("\n");
		}
	}
	//在指定位置插入数据
	public void insertAtArray(int[] a ,int n,int k)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要插入的位置（为下标）");
		n = sc.nextInt();
		System.out.println("请输入要插入的数值");
		k = sc.nextInt();
		for (int i = 9 ; i > n ; i--)
		{
			a[i] = a[i-1];
		}
		a[n] = k;
	}
	//查询数组中能被3整除的数
	public void divThree(int[] arr)
	{
		int flag = 0;
		for(int a : arr)
		{
			if (a % 3 == 0 && flag ==0 &&a != 0)
			{
				flag = 1;
				System.out.print("能被3整除的数有：\n" + a);
			}
			else if (a % 3 ==0 && flag ==1 &&a != 0)
			{
				System.out.print("   " + a);
			}
		}
		if (flag == 0)
		{
			System.out.print("没有能被3整除的数");
		}
		System.out.print("\n");
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("本系统并不完整，仅以十个元素的数组为例进行操作,并请您尽量按顺序操作。");
		Homework1 hw = new Homework1();
		int arr[] = new int[10];
		int flag = 0;
		while(flag != 1)
		{
			hw.notice();
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			switch (input)
			{
			case 1:
				arr = hw.insertData();
				break;
			case 2:
				hw.showData(arr);
				break;
			case 3:
				hw.insertAtArray(arr, 0, 0);
				break;
			case 4:
				hw.divThree(arr);
				break;
			case 0:
				flag = 1;
				break;
			default:
				System.out.println("请输入0-4哦");
			}
		}
	}

}
