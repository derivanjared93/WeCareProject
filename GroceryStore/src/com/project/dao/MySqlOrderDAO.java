package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.project.exception.CustomException;
import com.project.exception.StatusCode;
import com.project.exception.WrongEntryException;
import com.project.jdbc.mysql.ConnectionPool;
import com.project.pojo.Order;

public class MySqlOrderDAO implements OrderDAO 
{

	public int addOrder(Order o) throws CustomException, WrongEntryException 
	{
		return 0;
	}

	public int deleteOrder(int orderID) throws CustomException, WrongEntryException 
	{
		return 0;
	}
	
	public int updateOrder(Order o) throws CustomException, WrongEntryException 
	{
		return 0;
	}


}
