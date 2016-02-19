package com.project.dao;

public class MySqlDAOFactory extends DAOFactory
{
	
	public CustomerDAO getCustomerDAO()
	{
		return new MySqlCustomerDAO();
	}
	
	public FoodDAO getFoodDAO()
	{
		return new MySqlFoodDAO();
	}
	
	public OrderDAO getOrderDAO() 
	{
		return new MySqlOrderDAO();
	}

}
