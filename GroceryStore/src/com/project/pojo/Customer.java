package com.project.pojo;

import java.io.Serializable;
import java.util.List;

public class Customer implements Serializable
{
	private static final long serialVersionUID = -4818899542758347131L;

	private int customerID;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String ccNumber;
	private boolean isWIC;
	private boolean isAdmin;
	private List<Order> orderList;
	private List<Food> currentOrder;
	
	public Customer()
	{
		
	}
	
	public Customer(String email, String password)
	{
		this.email = email;
		this.password = password;
		
	}
	
	public Customer(String email, String password, boolean isWIC)
	{
		this.email = email;
		this.password = password;
		this.isWIC = isWIC;
	}
	
	public int getCustomerID() 
	{
		return customerID;
	}

	public void setCustomerID(int customerID) 
	{
		this.customerID = customerID;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public String getFirstName() 
	{
		return firstName;
	}
	
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	public String getCcNumber() 
	{
		return ccNumber;
	}
	
	public void setCcNumber(String ccNumber) 
	{
		this.ccNumber = ccNumber;
	}
	
	public boolean isWIC() 
	{
		return isWIC;
	}

	public void setWIC(boolean isWIC) 
	{
		this.isWIC = isWIC;
	}
	
	public List<Order> getOrderList() 
	{
		return orderList;
	}
	
	public void setOrderList(List<Order> orderList) 
	{
		this.orderList = orderList;
	}


	public String getEmail() 
	{
		return email;
	}
	

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public boolean isAdmin() 
	{
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) 
	{
		this.isAdmin = isAdmin;
	}

	public List<Food> getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(List<Food> currentOrder) {
		this.currentOrder = currentOrder;
	}


}
