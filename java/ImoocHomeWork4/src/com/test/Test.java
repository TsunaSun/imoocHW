package com.test;

import java.util.Scanner;

import com.model.GoodsManage;
import com.model.ShoppingCart;

public class Test {

	// 主菜单
	public static void infoMain() {
		System.out.println("*********************************");
		System.out.println("            ***主菜单***            ");
		System.out.println("            1--商品管理            ");
		System.out.println("            2--购物车            ");
		System.out.println("            0--退出            ");
		System.out.println("*********************************");
		System.out.println("请输入正确的数字进行操作");
	}

	// 商品管理
	public static void infoGoodsManage() {
		System.out.println("*********************************************************");
		System.out.println("                          ***商品管理***                       ");
		System.out.println("                          1--商品信息导入                       ");
		System.out.println("                          2--显示所有商品信息                      ");
		System.out.println("                          9--返回上一级菜单                      ");
		System.out.println("*********************************************************");
		System.out.println("请输入正确的数字对商品进行管理");
	}

	// 购物车管理
	public static void infoShoppingCart() {
		System.out.println("*********************************************************");
		System.out.println("                          ***购物车管理***                       ");
		System.out.println("                          1--添加商品到购物车                       ");
		System.out.println("                          2--修改购物车中商品数量                      ");
		System.out.println("                          3--显示购物车中所有商品信息                      ");
		System.out.println("                          4--结算                      ");
		System.out.println("                          9--返回上一级菜单                      ");
		System.out.println("*********************************************************");
		System.out.println("请输入正确的数字对购物车进行管理");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GoodsManage gm = new GoodsManage();
		ShoppingCart sc = new ShoppingCart();
		Scanner input = new Scanner(System.in);
		int tmpMain = 0;
		int tmpGM = 0;
		int tmpSC = 0;
		while (true) {
			infoMain();
			try {
				tmpMain = input.nextInt();
			} catch (Exception e) {
				System.out.println("请输入正整数！");
				input.next();
				continue;
			}
			// 输入1时进入商品管理界面
			if (tmpMain == 1) {
				while (true) {
					infoGoodsManage();
					try {
						tmpGM = input.nextInt();
					} catch (Exception e) {
						System.out.println("请输入正整数！");
						input.next();
						continue;
					}
					// 输入1时导入商品信息
					if (tmpGM == 1) {
						System.out.println("商品信息导入");
						gm.importGoods();
						// 输入2时显示所有商品信息
					} else if (tmpGM == 2) {
						System.out.println("显示所有商品信息");
						gm.displayAllGoods();
						// 输入9时回到主界面
					} else if (tmpGM == 9) {
						break;
					} else {
						System.out.println("请输入正确的数字");
					}
				}
				// 输入2时进入购物车管理界面
			} else if (tmpMain == 2) {
				while (true) {
					infoShoppingCart();
					try {
						tmpSC = input.nextInt();
					} catch (Exception e) {
						System.out.println("请输入正整数！");
						input.next();
						continue;
					}
					// 输入1时添加商品到购物车
					if (tmpSC == 1) {
						System.out.println("添加商品到购物车");
						sc.addGoodsToCart(gm);
						// 输入2时修改购物车中的商品数量
					} else if (tmpSC == 2) {
						System.out.println("修改购物车中的商品数量");
						sc.updateNumInCart();
						// 输入3时显示购物车中所有商品信息
					} else if (tmpSC == 3) {
						System.out.println("显示购物车中所有商品信息");
						sc.displayAllInCart();
						// 输入4时结算
					} else if (tmpSC == 4) {
						System.out.println("结算");
						sc.settleAccounts();
						// 输入9时返回主菜单
					} else if (tmpSC == 9) {
						break;
					} else {
						System.out.println("请输入正确的数字");
					}
				}
				// 输入0时退出
			} else if (tmpMain == 0) {
				System.out.println("感谢使用！");
				break;
				// 输入其他重来
			} else {
				System.out.println("请输入正确的数字");
				continue;
			}
		}
		input.close();
	}

}
