package com.project.dao;

import com.project.exception.CustomException;
import com.project.exception.WrongEntryException;
import com.project.pojo.Food;

public interface FoodDAO 
{
	public int addFood(Food f) throws CustomException, WrongEntryException;	
	public int deleteFood(int foodID) throws CustomException, WrongEntryException;
	public int updateFood(Food f) throws CustomException, WrongEntryException;
}
