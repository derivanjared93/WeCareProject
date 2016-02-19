package com.project.pojo;

import java.io.Serializable;

public class Food implements Serializable
{	

	private static final long serialVersionUID = -7647602036804074319L;

	public enum Category { FRUIT, VEGETABLE, PROTEIN, DAIRY, GRAIN, OIL }
	
	private int foodID;
	private String foodName;
	private double foodPrice;
	private Category foodCategory;
	private boolean isWIC;
	private int foodAmount;
	private String foodBrand;
	
	public Food()
	{
		
	}
	
	public Food(String name, double price, Category category, boolean isWIC, int amount, String brand)
	{
		foodName = name;
		foodPrice = price;
		foodCategory = category;
		this.isWIC = isWIC;
		foodAmount = amount;
		foodBrand = brand;
	}
	
	public int getFoodID() 
	{
		return foodID;
	}
	
	public void setFoodID(int foodID) 
	{
		this.foodID = foodID;
	}
	
	public String getFoodName() 
	{
		return foodName;
	}
	
	public void setFoodName(String foodName) 
	{
		this.foodName = foodName;
	}
	
	public double getFoodPrice() 
	{
		return foodPrice;
	}
	
	public void setFoodPrice(double foodPrice)
	{
		this.foodPrice = foodPrice;
	}
	
	public Category getFoodCategory() 
	{
		return foodCategory;
	}
	
	public void setFoodCategory(Category foodCategory) 
	{
		this.foodCategory = foodCategory;
	}
	
	public boolean isWIC() 
	{
		return isWIC;
	}
	
	public void setWIC(boolean isWIC) 
	{
		this.isWIC = isWIC;
	}
	
	public int getFoodAmount()
	{
		return foodAmount;
	}
	
	public void setFoodAmount(int foodAmount)
	{
		this.foodAmount = foodAmount;
	}
	
	public String getFoodBrand() 
	{
		return foodBrand;
	}
	
	public void setFoodBrand(String foodBrand) 
	{
		this.foodBrand = foodBrand;
	}
	

}
