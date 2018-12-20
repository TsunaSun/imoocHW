package com.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ShoppingCart {

	// 属性：购物车
	// Map<商品编号，购物车商品>
	Map<String, GoodsInCart> shoppingCart = new HashMap<String, GoodsInCart>();

	// get set
	public Map<String, GoodsInCart> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(Map<String, GoodsInCart> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	// 构造方法

	public ShoppingCart(Map<String, GoodsInCart> shoppingCart) {
		super();
		this.shoppingCart = shoppingCart;
	}

	public ShoppingCart() {
		super();
	}

	// 添加商品到购物车
	public void addGoodsToCart(GoodsManage gm) {

		if (gm.getGoodsSet().isEmpty()) {
			System.out.println("还没有商品，请导入商品信息！");
		} else {
			gm.displayAllGoods();
			System.out.println("请输入要添加的编号：");
			
			Scanner input = new Scanner(System.in);
			boolean flag = false;
			// goodsId记录商品编号
			String goodsId = null;
			// GoodsInCart记录商品
			GoodsInCart goodsInCart = new GoodsInCart();
			
			while (!flag) {
				goodsId = input.nextLine();
				// 如果商品已经存在则要重新输入其他商品
				if (this.getShoppingCart().containsKey(goodsId)) {
					System.out.println("该商品已经在购物车里哦！输入其他商品吧！");
					continue;
				}
				// 寻找对应编号商品并记录
				for (Goods good : gm.getGoodsSet()) {
					if (good.getGoodsId().equals(goodsId)) {
						goodsInCart.setGoods(good);
						flag = true;
						break;
					}
				}
				if (!flag) {
					System.out.println("请输入正确的商品编号！");
				}
			}
			
			System.out.println("请输入要添加的商品数量");
			
			while (true) {
				// 防止输入商品数量出错
				try {
					int num = input.nextInt();
					if (num <= 0) {
						System.out.println("输入的数量不正确，请重新输入");
						continue;
					} else {
						goodsInCart.setNum(num);
						this.shoppingCart.put(goodsId, goodsInCart);
						break;
					}
				} catch (Exception e) {
					System.out.println("请输入大于0的整数！");
					input.next();
					continue;
				}
			}
		}
	}

	//修改购物车中商品数量
	public void updateNumInCart() {
		
		Scanner input = new Scanner(System.in);
		boolean flag = false;
		
		if (this.shoppingCart.isEmpty()) {
			System.out.println("购物车还是空的哦，请添加商品吧！");
		}
		else{
			System.out.println("你的购物车里商品为");
			this.displayAllInCart();
			System.out.println("请输入要修改的商品编号");
			String goodsId = null;
			while (!flag) {
				goodsId = input.nextLine();
				// 寻找对应编号商品并记录
					if (this.getShoppingCart().containsKey(goodsId)) {
						System.out.println("请输入新的商品数量");
						flag = true;
						break;
				}
				if (!flag) {
					System.out.println("请输入正确的商品编号！");
				}
			}
			while (true) {
				// 防止输入商品数量出错
				try {
					int num = input.nextInt();
					if (num < 0) {
						System.out.println("输入的数量不正确，请重新输入");
						continue;
					}else if (num == 0) {
						System.out.println("因为该商品数量变为0，该商品已从购物车中移除");
						this.getShoppingCart().remove(goodsId);
						break;
					}
					else {
						this.getShoppingCart().get(goodsId).setNum(num);
						break;
					}
				} catch (Exception e) {
					System.out.println("请输入大于0的整数！");
					input.next();
					continue;
				}
			}
			System.out.println("修改成功");
		}
	}
	//显示购物车中所有商品
	public void displayAllInCart() {
		if (this.shoppingCart.isEmpty()) {
			System.out.println("购物车还是空的哦，请添加商品吧！");
		}
		else {
			Iterator<GoodsInCart> it = this.shoppingCart.values().iterator();
			GoodsInCart goodsInCart = new GoodsInCart();
			while(it.hasNext()) {
				goodsInCart = it.next();
				System.out.println(goodsInCart.getGoods() + "数量" + goodsInCart.getNum());
			}
		}
	}
	
	//结算
	public void settleAccounts() {
			double sum = 0;
			for (GoodsInCart goodsInCart : this.getShoppingCart().values()) {
				sum += goodsInCart.getNum() * goodsInCart.getGoods().getPrice();
			}
			System.out.println("商品的总价为：" + sum);
			for (GoodsInCart goodsInCart : this.getShoppingCart().values()) {
				System.out.println(goodsInCart.getGoods() + "数量" + goodsInCart.getNum());
			}
	}
}

	
