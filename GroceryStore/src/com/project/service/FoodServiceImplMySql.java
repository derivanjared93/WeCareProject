package com.project.service;

import java.util.List;

import com.project.dao.DAOFactory;
import com.project.dao.FoodDAO;
import com.project.exception.CustomException;
import com.project.exception.WrongEntryException;
import com.project.pojo.Food;

public class FoodServiceImplMySql implements FoodService
{

	FoodDAO foodDAO =  DAOFactory.getDAOFactory(1).getFoodDAO();
	
	@Override
	public void addFood(Food f) throws CustomException, WrongEntryException 
	{
		foodDAO.addFood(f);
	}

	@Override
	public void deleteFood(int foodID) throws CustomException, WrongEntryException 
	{
		foodDAO.deleteFood(foodID);
	}

	@Override
	public void updateFood(Food f) throws CustomException, WrongEntryException 
	{
		foodDAO.updateFood(f);
	}
	
	@Override
	public List<Food> getAllFood() throws CustomException, WrongEntryException 
	{
		return foodDAO.getFood(0);
	}


	@Override
	public List<Food> searchFoodByID(int foodID) throws CustomException, WrongEntryException 
	{
		return foodDAO.getFood(foodID);
	}


	@Override
	public List<Food> searchFoodByWIC(boolean isWIC) throws CustomException, WrongEntryException 
	{
		return foodDAO.getFoodByWIC(isWIC);
	}

}
