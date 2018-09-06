package com.model;

import java.util.HashSet;
import java.util.Set;

public class GoodsManage {
	// 存放商品的Set
	private Set<Goods> goodsSet = new HashSet<Goods>();

	// get set方法
	public Set<Goods> getGoodsSet() {
		return goodsSet;
	}

	public void setGoodsSet(Set<Goods> goodsSet) {
		this.goodsSet = goodsSet;
	}

	// 导入商品信息方法
	public void importGoods() {
		// 实例化商品
		if (!this.getGoodsSet().isEmpty()) {
			System.out.println("商品已经导入过啦！");
		} else {
			System.out.println("开始导入商品信息啦！");
			Goods good1 = new Goods("g001", "电视机", 1000.0d, "索尼20寸超级大电视");
			Goods good2 = new Goods("g002", "电脑", 15500.0d, "戴尔外星人超级笔记本");
			Goods good3 = new Goods("g003", "手机", 10000.0d, "IPhone9");
			Goods good4 = new Goods("g004", "电扇", 1000.0d, "镶金电扇");
			this.goodsSet.add(good1);
			this.goodsSet.add(good2);
			this.goodsSet.add(good3);
			this.goodsSet.add(good4);
			System.out.println("所有商品都导入成功啦！");
		}
	}

	// 显示所有商品方法
	public void displayAllGoods() {
		if (this.getGoodsSet().isEmpty()) {
			System.out.println("还没有商品被导入哦");
		} else {
			System.out.println("所有商品信息如下：");
			for (Goods goods : this.getGoodsSet()) {
				System.out.println(goods);
			}
			System.out.println("所有商品显示完毕");
		}
	}
}
