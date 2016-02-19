package com.project.dao;

public abstract class DAOFactory 
{
	
	public static final int MYSQL = 1;
	public static final int ORACLE = 2;
	
	public abstract CustomerDAO getCustomerDAO();
	public abstract FoodDAO getFoodDAO();
	public abstract OrderDAO getOrderDAO();
	
	public static DAOFactory getDAOFactory(int databaseType)
	{
		switch(databaseType)
		{
			case MYSQL:  return new MySqlDAOFactory();
			case ORACLE: return null;
			default: return new MySqlDAOFactory();
		}
	}
	
}