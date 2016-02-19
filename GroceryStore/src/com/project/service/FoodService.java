package com.project.service;

import java.util.List;

import com.project.exception.CustomException;
import com.project.exception.WrongEntryException;
import com.project.pojo.Food;

public interface FoodService 
{
	public abstract void addFood(Food f) throws CustomException, WrongEntryException;	
	public abstract void deleteFood(int foodID) throws CustomException, WrongEntryException;	
	public abstract void updateFood(Food f) throws CustomException, WrongEntryException;
	public abstract List<Food> searchFoodByID(int foodID) throws CustomException, WrongEntryException;
	public abstract List<Food> searchFoodByWIC(boolean isWIC) throws CustomException, WrongEntryException;
	public abstract List<Food> getAllFood() throws CustomException, WrongEntryException;
	
	
	
	
	
}


