package com.model;

public class Goods {
	/*
	 * 商品属性：编号 名称 价格 描述
	 */
	private String goodsId;
	private String goodsName;
	private double price;
	private String goodsDesp;

	// get set 方法
	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getGoodsDesp() {
		return goodsDesp;
	}

	public void setGoodsDesp(String goodsDesp) {
		this.goodsDesp = goodsDesp;
	}

	// 构造方法
	public Goods(String goodsId, String goodsName, double price, String goodsDesp) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.price = price;
		this.goodsDesp = goodsDesp;
	}

	public Goods() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goodsDesp == null) ? 0 : goodsDesp.hashCode());
		result = prime * result + ((goodsId == null) ? 0 : goodsId.hashCode());
		result = prime * result + ((goodsName == null) ? 0 : goodsName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	// 重写equals方法
	// 当商品名称和编号相同时则认为是同一商品
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj.getClass() == Goods.class) {
			Goods goods = (Goods) obj;
			return goods.getGoodsId() == this.getGoodsId() && goods.getGoodsName() == this.getGoodsName();
		}
		return false;
	}

	// 重写toString方法
	@Override
	public String toString() {
		return "商品 信息[编号=" + goodsId + ", 名称=" + goodsName + ", 价格=" + price + ", 描述=" + goodsDesp + "]";
	}

}
