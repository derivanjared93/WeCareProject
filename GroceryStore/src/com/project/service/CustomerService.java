package com.project.service;

import java.util.List;

import com.project.exception.CustomException;
import com.project.exception.WrongEntryException;
import com.project.pojo.Customer;
import com.project.pojo.Order;

public interface CustomerService 
{
	public abstract void addCustomer(Customer c) throws CustomException, WrongEntryException;	
	public abstract void deleteCustomer(int customerID) throws CustomException, WrongEntryException;	
	public abstract void updateCustomer(Customer c) throws CustomException, WrongEntryException;
	public abstract List<Customer> getAllCustomers() throws CustomException, WrongEntryException;
	
	//Admin features
	public abstract List<Customer> searchCustomerByID(int customerID) throws CustomException, WrongEntryException;
	public abstract List<Customer> searchCustomerFirst(String fname) throws CustomException, WrongEntryException;
	public abstract List<Customer> searchCustomerLast(String lname) throws CustomException, WrongEntryException; 
	public abstract List<Customer> searchCustomerWIC(boolean isWIC) throws CustomException, WrongEntryException;
	public abstract List<Order> searchCustomerOrders(int customerID) throws CustomException, WrongEntryException;

	
}
