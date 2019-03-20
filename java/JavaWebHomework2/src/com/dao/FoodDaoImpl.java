package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.domain.Food;

public class FoodDaoImpl {
	private static List<Food> db = new ArrayList<Food>();
	
	//添加菜品
	public void addFood(Food food) {
		db.add(food);
	}
	//查询所有菜品信息
	public List<Food> getAllFood(){
		return db;
	}
	
	//根据菜品名称查询菜品信息
	public Food getFoodByName(String foodName) {
		for (Food food : db) {
			if (food.getName().equals(foodName)) {
				return food;
			}
		}
		return null;
	}
	
	//根据菜品id查询菜品信息
	public Food getFoodById(String foodId) {
		for (Food food : db) {
			if (food.getId().equals(foodId)) {
				return food;
			}
		}
		return null;
	}
	
	//菜品修改
	public void updateFood(Food newFood) {
		String id = newFood.getId();
		deleteFoodById(id);
		addFood(newFood);
	}
	//根据菜品ID进行删除
	public void deleteFoodById(String id) {
		for (Food food : db) {
			if (food.getId().equals(id)) {
				db.remove(food);
				break;
			}
		}
	}
	
}
