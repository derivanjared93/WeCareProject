package com.project.pojo;

import java.io.Serializable;

public class Order implements Serializable
{

	private static final long serialVersionUID = -48684080926967679L;
	private int orderID;
	private int customerID;
	private double orderTotal;
	private String orderDate;
	
	public Order()
	{
		
	}
	
	
	public Order(int customerID, double total, String date)
	{
		this.customerID = customerID;
		orderTotal = total;
		orderDate = date;
	}
	

	public int getOrderID() 
	{
		return orderID;
	}
	
	public void setOrderID(int orderID) 
	{
		this.orderID = orderID;
	}
	
	public int getCustomerID() 
	{
		return customerID;
	}
	
	public void setCustomerID(int customerID) 
	{
		this.customerID = customerID;
	}
	
	public double getOrderTotal()
	{
		return orderTotal;
	}
	
	public void setOrderTotal(double orderTotal) 
	{
		this.orderTotal = orderTotal;
	}
	
	public String getOrderDate() 
	{
		return orderDate;
	}
	
	public void setOrderDate(String orderDate) 
	{
		this.orderDate = orderDate;
	}
	
	
}
