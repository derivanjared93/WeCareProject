package com.project.dao;

import java.util.List;

import com.project.exception.CustomException;
import com.project.exception.WrongEntryException;
import com.project.pojo.Food;

public interface FoodDAO 
{
	public int addFood(Food f) throws CustomException, WrongEntryException;	
	public int deleteFood(int foodID) throws CustomException, WrongEntryException;
	public int updateFood(Food f) throws CustomException, WrongEntryException;
	public List<Food> getFood(int foodID) throws CustomException, WrongEntryException;
	public List<Food> getFoodByWIC(boolean isWIC) throws CustomException, WrongEntryException;
	
	
}
