package com.project.dao;

import com.project.exception.CustomException;
import com.project.exception.WrongEntryException;
import com.project.pojo.Order;

public interface OrderDAO 
{
	public int addOrder(Order o) throws CustomException, WrongEntryException;	
	public int deleteOrder(int orderID) throws CustomException, WrongEntryException;
	public int updateOrder(Order o) throws CustomException, WrongEntryException;
}
