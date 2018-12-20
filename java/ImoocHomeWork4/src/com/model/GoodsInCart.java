package com.model;

public class GoodsInCart {
	// 属性：商品信息，商品数量
	private Goods goods;
	private int num;

	// get set方法
	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	// 构造方法
	public GoodsInCart(Goods goods, int num) {
		super();
		this.goods = goods;
		this.num = num;
	}

	public GoodsInCart() {
		super();
	}
	
	

}
