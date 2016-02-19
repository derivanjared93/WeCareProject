package com.project.service;

import com.project.dao.DAOFactory;

import java.util.List;

import com.project.dao.CustomerDAO;
import com.project.exception.CustomException;
import com.project.exception.WrongEntryException;
import com.project.pojo.Customer;
import com.project.pojo.Order;

public class CustomerServiceImplMySql implements CustomerService {

	CustomerDAO custDAO =  DAOFactory.getDAOFactory(1).getCustomerDAO();
	
	@Override
	public void addCustomer(Customer c) throws CustomException, WrongEntryException 
	{
		custDAO.addCustomer(c);
	}

	@Override
	public void deleteCustomer(int customerID) throws CustomException, WrongEntryException 
	{
		custDAO.deleteCustomer(customerID);
	}

	@Override
	public void updateCustomer(Customer c) throws CustomException, WrongEntryException 
	{
		custDAO.updateCustomer(c);
	}

	@Override
	public List<Customer> searchCustomerByID(int customerID) throws CustomException, WrongEntryException 
	{
		return custDAO.getCustomerByID(customerID);
	}

	@Override
	public List<Customer> searchCustomerFirst(String fname) throws CustomException, WrongEntryException 
	{
		return null;
	}

	@Override
	public List<Customer> searchCustomerLast(String lname) throws CustomException, WrongEntryException 
	{
		return null;
	}

	@Override
	public List<Customer> searchCustomerWIC(boolean isWIC) throws CustomException, WrongEntryException 
	{
		return custDAO.getCustomerByWIC(isWIC);
	}

	@Override
	public List<Order> searchCustomerOrders(int customerID) throws CustomException, WrongEntryException
	{
		return custDAO.getCustomerOrders(customerID);
	}

	@Override
	public List<Customer> getAllCustomers() throws CustomException, WrongEntryException 
	{
		return custDAO.getCustomerByID(0);
	}

}
