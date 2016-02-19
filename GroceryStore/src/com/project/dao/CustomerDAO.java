package com.project.dao;

import java.util.List;

import com.project.exception.CustomException;
import com.project.exception.WrongEntryException;
import com.project.pojo.Customer;
import com.project.pojo.Order;

public interface CustomerDAO 
{
	public int addCustomer(Customer c) throws CustomException, WrongEntryException;	
	public int deleteCustomer(int customerID) throws CustomException, WrongEntryException;
	public int updateCustomer(Customer c) throws CustomException, WrongEntryException;
	public List<Customer> getCustomerByID(int customerID) throws CustomException, WrongEntryException;
	public List<Customer> getCustomerByName(String name, int firstLast) throws CustomException, WrongEntryException;
	public List<Customer> getCustomerByWIC(boolean isWIC) throws CustomException, WrongEntryException;
	public List<Order> getCustomerOrders(int customerID) throws CustomException, WrongEntryException;

	
}
